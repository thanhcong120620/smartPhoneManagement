package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Context.DBConnection;
import model.Orders;

public class DaoOrders implements DaoInterface<Orders>{
	
	public static DaoOrders getInstance() {
		return new DaoOrders();
	}

	@Override
	public int insert(Orders t) {
		System.out.println("INSERT FUNCTION-----------------");
		int check =0;
		try {
			/* Kết nối data base */
			Connection con = DBConnection.getConnection();

	
			String sql =  "INSERT INTO orders (order_id, order_status, order_date, order_discount_code, order_address, cus_id) values (?,?,?,?,?,?)";
			
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setString(1,t.getOrder_id());
			st.setString(2, t.getOrder_status());
			st.setString(3,t.getOrder_date());
			st.setString(4, t.getOrder_discount_code());
			st.setString(5,t.getOrder_address());
			st.setString(6, t.getCus_id());

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

	@Override
	public int update(Orders t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Orders t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<Orders> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Orders> selectByCondition(String condition) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int count() {
		int kqua = 0;
		try {
			/*Tạo kết nối*/
			Connection con = DBConnection.getConnection();
			
			/*Tạo câu lệnh statement*/
			Statement st = con.createStatement();
			String sql = "select count(*) from orders;";
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
