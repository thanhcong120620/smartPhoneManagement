package Context;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	static Connection con;
	
	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mySQL://localhost:3306/webapp";
			String user = "root";
			String password = "Ntcong0368279613";
			con = DriverManager.getConnection(url, user, password);
			System.out.println("Connected: "+con);
		} catch (ClassNotFoundException e) {
			System.out.println("Can not connect !");
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	
	public static Connection disConnection(Connection con) {
		try {
			con.close();
			System.out.println("Disconnected");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
}
