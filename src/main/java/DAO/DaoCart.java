package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Context.DBConnection;
import model.Customer;
import model.OrderDetails;
import model.cart;

public class DaoCart implements DaoInterface<cart>{
	
	public static DaoCart getInstance() {
		return new DaoCart();
	}

	@Override
	public int insert(cart t) {
		System.out.println("INSERT FUNCTION-----------------");
		int check =0;
		try {
			/* Kết nối data base */
			Connection con = DBConnection.getConnection();

	
			String sql =  "INSERT INTO cart (cus_name, cus_phone, product_name, product_price, quantity, amount_product, total) values (?,?,?,?,?,?,?)";
			
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setString(1, t.getCus_name());
			st.setString(2, t.getCus_phone());
			st.setString(3, t.getProduct_name());
			st.setDouble(4, t.getProduct_price());
			st.setInt(5, t.getQuantity());
			st.setDouble(6, t.getAmount_product());
			st.setDouble(7, t.getTotal());

			check = st.executeUpdate();

			System.out.println(sql);
			System.out.println("Bạn đã thêm " + check + " dòng");

			/* Ngắt kết nối */
			DBConnection.disConnection(con);
			;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return check;
	}
	
	
	/*
	 * Truy vấn có điều kiện không sử dụng arraylist
	 * */
	public cart selectByConditionOB(String condition) {
		
		cart kqua = new cart();
		
		try {
			/*Tạo kết nối*/
			Connection con = DBConnection.getConnection();
			
			/*Tạo câu lệnh statement*/
			Statement st = con.createStatement();
			String sql = "select * from cart where "+condition+";";
			
			/*Thực thi và xử lý kết quả*/
			ResultSet rs = st.executeQuery(sql);	
			while(rs.next()) { // lấy kết quả ra từ result set
				String cus_name = rs.getString("cus_name");
				String cus_phone = rs.getString("cus_phone");
				String product_name = rs.getString("product_name");
				Double product_price = rs.getDouble("product_price");
				int quantity = rs.getInt("quantity");
				Double amount_product = rs.getDouble("amount_product");
				Double total = rs.getDouble("total");
				
				cart cart = new cart(cus_name, cus_phone, product_name, product_price, quantity, amount_product, total);
				kqua=cart;
			}
			
			/*Ngắt kết nối*/
			DBConnection.disConnection(con);
			
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return kqua;
	}
	

	public int updateCondition(String set, String condition) {
		try {
			/* Tạo kết nối */
			Connection con = DBConnection.getConnection();

			/* Tạo Statement */
			Statement st = con.createStatement();
			String sql = "update cart set "+set+" where "+condition+";";
			int check = st.executeUpdate(sql);
			
			/* Xử lý kết quả */
			System.out.println(sql);
			System.out.println("Bạn cập nhật " + check + " dòng");
			
			/* Ngắt kết nối */
			DBConnection.disConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	
	public int deleteCondition(String condition) {
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = DBConnection.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			String sql = "DELETE from cart "+
					 " WHERE "+condition;
			
			PreparedStatement st = con.prepareStatement(sql);
//			st.setInt(1, t.getID());
			
			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ketQua = st.executeUpdate();
			
			// Bước 4:
			System.out.println("Bạn đã thực thi: "+ sql);
			System.out.println("Có "+ ketQua+" dòng bị thay đổi!");
			
			// Bước 5:
			DBConnection.disConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ketQua;
	}
	
	
	@Override
	public int update(cart t) {
		try {
			/* Tạo kết nối */
			Connection con = DBConnection.getConnection();

			/* Tạo Statement */
			Statement st = con.createStatement();
			String sql = "update cart set cus_name='"+t.getCus_name()+"', cus_phone= "+t.getCus_phone()+", product_name='"+t.getProduct_name()+t.getProduct_price()+"', product_price= "+t.getQuantity()+", amount_product='"+t.getAmount_product()+", total='"+t.getTotal()+"' where cus_name = '"+t.getCus_name()+"';";
			int check = st.executeUpdate(sql);
			
			/* Xử lý kết quả */
			System.out.println(sql);
			System.out.println("Bạn cập nhật " + check + " dòng");
			
			/* Ngắt kết nối */
			DBConnection.disConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int delete(cart t) {
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = DBConnection.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			String sql = "DELETE from khachhang "+
					 " WHERE ID=?";
			
			PreparedStatement st = con.prepareStatement(sql);
//			st.setInt(1, t.getID());
			
			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ketQua = st.executeUpdate();
			
			// Bước 4:
			System.out.println("Bạn đã thực thi: "+ sql);
			System.out.println("Có "+ ketQua+" dòng bị thay đổi!");
			
			// Bước 5:
			DBConnection.disConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ketQua;
	}

	@Override
	public ArrayList<cart> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<cart> selectByCondition(String condition) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return 0;
	}

}
