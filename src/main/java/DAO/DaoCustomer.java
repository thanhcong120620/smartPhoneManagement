package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Context.DBConnection;
import model.Customer;
import model.ProductDescription;

public class DaoCustomer implements DaoInterface<Customer>{

	public static DaoCustomer getInstance() {
		return new DaoCustomer();
	}
	
	@Override
	public int insert(Customer t) {
		System.out.println("INSERT FUNCTION-----------------");
		int check =0;
		try {
			/* Kết nối data base */
			Connection con = DBConnection.getConnection();

	
			String sql =  "INSERT INTO customer (cus_id, cus_name, cus_age, cus_phone, cus_mail, cus_address) values (?,?,?,?,?,?)";
			
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setString(1,t.getCus_id());
			st.setString(2, t.getCus_name());
			st.setInt(3,t.getCus_age());
			st.setString(4, t.getCus_phone());
			st.setString(5, t.getCus_mail());
			st.setString(6, t.getCus_address());

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
	public int update(Customer t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Customer t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<Customer> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Customer> selectByCondition(String condition) {
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
			String sql = "select count(*) from customer";
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
