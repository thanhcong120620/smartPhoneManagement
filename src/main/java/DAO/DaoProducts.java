package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Context.DBConnection;
import model.Products;

public class DaoProducts implements DaoInterface<Products>{
/*SỬ DỤNG PREPARED STATEMENT*/
	
	
	public static DaoProducts getInstance() {
		return new DaoProducts();
	}
	

	
	/*
	 * Thêm sản phẩm vào data
	 * */
	@Override
	public int insert(Products t) {
		System.out.println("INSERT FUNCTION-----------------");
		int check =0;
		try {
			/* Kết nối data base */
			Connection con = DBConnection.getConnection();

	
			String sql =  "INSERT INTO khachhang (ID, tenKH, ngaySinh, diachi) values (?,?,?,?)";
			
			PreparedStatement st = con.prepareStatement(sql);
			
//			st.setInt(1,t.getID());
//			st.setString(2, t.getTenKH());
//			st.setString(3,t.getNgaySinh());
//			st.setString(4,t.getDiaChi());

			check = st.executeUpdate();

			System.out.println(sql);
			System.out.println("Bạn đã thêm " + check + " dòng");

			/* Ngắt kết nối */
			DBConnection.disConnection(con);
			;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	
	
	/*
	 * Chỉnh sửa sản phẩm trong data
	 * */
	@Override
	public int update(Products t) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	
	/*
	 * Xóa sản phẩm khỏi data
	 * */
	@Override
	public int delete(Products t) {
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

	
	
	/*
	 * Hiển thị data
	 * */
	@Override
	public ArrayList<Products> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * Truy vấn có điều kiện không sử dụng arraylist
	 * */
	public Products selectByConditionOB(String condition) {
		
		Products kqua = new Products();
		
		try {
		/*Tạo kết nối*/
		Connection con = DBConnection.getConnection();
		
		/*Tạo câu lệnh statement*/
		Statement st = con.createStatement();
		String sql = "select * from products where "+condition+";";
		
		/*Thực thi và xử lý kết quả*/
		ResultSet rs = st.executeQuery(sql);	
		while(rs.next()) { // lấy kết quả ra từ result set
			String product_id = rs.getString("product_id");
			String product_name = rs.getString("product_name");
			Double product_price = rs.getDouble("product_price");
			String product_img_source  = rs.getString("product_img_source");
			String product_type = rs.getString("product_type");
			String product_brand = rs.getString("product_brand");
			
			Products products = new Products(product_id, product_name, product_img_source, product_type, product_brand, product_price);
			kqua=products;
		}
		
		/*Ngắt kết nối*/
		DBConnection.disConnection(con);
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return kqua;
	}
	
	
	
	
	/*
	 * Truy vấn có điều kiện sử dụng arraylist
	 * */
	@Override
	public ArrayList<Products> selectByCondition(String condition) {
		
		ArrayList<Products> kqua = new ArrayList<>();
		
		try {
		/*Tạo kết nối*/
		Connection con = DBConnection.getConnection();
		
		/*Tạo câu lệnh statement*/
		Statement st = con.createStatement();
		String sql = "select * from products where "+condition+";";
		
		/*Thực thi và xử lý kết quả*/
		ResultSet rs = st.executeQuery(sql);	
		while(rs.next()) { // lấy kết quả ra từ result set
			String product_id = rs.getString("product_id");
			String product_name = rs.getString("product_name");
			Double product_price = rs.getDouble("product_price");
			String product_img_source  = rs.getString("product_img_source");
			String product_type = rs.getString("product_type");
			String product_brand = rs.getString("product_brand");
			
			Products products = new Products(product_id, product_name, product_img_source, product_type, product_brand, product_price);
			kqua.add(products);
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
			String sql = "select count(*) from products;";
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
