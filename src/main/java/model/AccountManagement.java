package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountManagement {
	private Connection conn;
	
	public AccountManagement(Connection con) {
		this.conn = con;
	}
	
	
	public boolean login(String email, String password) throws SQLException {
		String sql = "select count(*) as count from account where user_mail=? and password=?";
		
		PreparedStatement stmt = conn.prepareStatement(sql);
		
		stmt.setString(1, email);
		stmt.setString(2, password);
		
		ResultSet rs = stmt.executeQuery();
		
		int count = 0;
		
		if(rs.next()) {
			count = rs.getInt("count");
		}
		
		if(count == 0) {
			return false;
		}
		else {
			return true;
		}		
	}
	
	
	
	public boolean exists(String email) throws SQLException {
		String sql = "select count(*) as count from account where user_mail=?";
		
		PreparedStatement stmt = conn.prepareStatement(sql);
		
		stmt.setString(1,email);
		
		ResultSet rs = stmt.executeQuery();
		
		int count=0;
		
		if(rs.next()) {
			count = rs.getInt("count");
		}
		
		if(count == 0) {
			return false;
		}
		else {
			return true;
		}
	}
	
	
	
	public void create(String user_mail, String password, String account_role, String user_name, String user_address, String user_phone) throws SQLException {
		String sql = "insert into account (user_mail, password, account_role, user_name, user_address, user_phone) values (?, ?, ?, ?, ?, ?)";
		
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1,user_mail);
		stmt.setString(2,password);
		stmt.setString(3,account_role);
		stmt.setString(4,user_name);
		stmt.setString(5,user_address);
		stmt.setString(6,user_phone);
		
		stmt.executeUpdate();
		
		stmt.close();
		
	}
}
