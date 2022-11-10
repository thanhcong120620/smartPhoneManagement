package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Context.DBConnection;
import model.ProductDescription;

public class DaoProductDescription implements DaoInterface<ProductDescription>{

	public static DaoProductDescription getInstance() {
		return new DaoProductDescription();
	}
	
	@Override
	public int insert(ProductDescription t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(ProductDescription t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(ProductDescription t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<ProductDescription> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<ProductDescription> selectByCondition(String condition) {
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
			String sql = "select count(*) from product_des;";
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
