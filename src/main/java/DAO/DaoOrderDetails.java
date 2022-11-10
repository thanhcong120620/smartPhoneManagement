package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Context.DBConnection;
import model.OrderDetails;

public class DaoOrderDetails implements DaoInterface<OrderDetails>{
	
	
	public static DaoOrderDetails getInstance() {
		return new DaoOrderDetails();
	}
	

	@Override
	public int insert(OrderDetails t) {
		System.out.println("INSERT FUNCTION-----------------");
		int check =0;
		try {
			/* Kết nối data base */
			Connection con = DBConnection.getConnection();

	
			String sql =  "INSERT INTO orders_detail (order_id, product_id, amount_product, product_price) values (?,?,?,?)";
			
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setString(1,t.getOrder_id());
			st.setString(2, t.getProduct_id());
			st.setDouble(3,t.getAmount_product());
			st.setDouble(4,t.getProduct_price());

			check = st.executeUpdate();

			System.out.println(sql);
			System.out.println("Bạn đã thêm " + check + " dòng");

			/* Ngắt kết nối */
			DBConnection.disConnection(con);
			

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int update(OrderDetails t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(OrderDetails t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<OrderDetails> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<OrderDetails> selectByCondition(String condition) {
		ArrayList<OrderDetails> kqua = new ArrayList<>();
		
		try {
		/*Tạo kết nối*/
		Connection con = DBConnection.getConnection();
		
		/*Tạo câu lệnh statement*/
		Statement st = con.createStatement();
		String sql = "select * from orders_detail where "+condition+";";
		
		/*Thực thi và xử lý kết quả*/
		ResultSet rs = st.executeQuery(sql);	
		while(rs.next()) { // lấy kết quả ra từ result set
			String order_id = rs.getString("order_id");
			String product_id = rs.getString("product_id");
			Double amount_product = rs.getDouble("amount_product");
			Double product_price = rs.getDouble("product_price");
			
			OrderDetails order_detail = new OrderDetails(order_id,product_id,amount_product, product_price);
			kqua.add(order_detail);
		}
		
		/*Ngắt kết nối*/
		DBConnection.disConnection(con);
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return kqua;
	}
	
	
	/*
	 * Truy vấn có điều kiện không sử dụng arraylist
	 * */
	public OrderDetails selectByConditionOB(String condition) {
		
		OrderDetails kqua = new OrderDetails();
		
		try {
			/*Tạo kết nối*/
			Connection con = DBConnection.getConnection();
			
			/*Tạo câu lệnh statement*/
			Statement st = con.createStatement();
			String sql = "select * from orders_detail where "+condition+";";
			
			/*Thực thi và xử lý kết quả*/
			ResultSet rs = st.executeQuery(sql);	
			while(rs.next()) { // lấy kết quả ra từ result set
				String order_id = rs.getString("order_id");
				String product_id = rs.getString("product_id");
				Double amount_product = rs.getDouble("amount_product");
				Double product_price = rs.getDouble("product_price");
				
				OrderDetails order_detail = new OrderDetails(order_id,product_id,amount_product, product_price);
				kqua=order_detail;
			}
			
			/*Ngắt kết nối*/
			DBConnection.disConnection(con);
			
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return kqua;
	}


	@Override
	public int count() {
		int kqua = 0;
		try {
			/*Tạo kết nối*/
			Connection con = DBConnection.getConnection();
			
			/*Tạo câu lệnh statement*/
			Statement st = con.createStatement();
			String sql = "select count(*) from orders_detail;";
			ResultSet rs = st.executeQuery(sql);	
			while(rs.next()) { // lấy kết quả ra từ result set
				kqua = rs.getInt("count(*)");

			}
			
			
			/*Ngắt kết nối*/
			DBConnection.disConnection(con);
			
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return kqua;
	}

}
