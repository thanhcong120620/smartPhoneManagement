package Context;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class jdbcConnection
 */
@WebServlet("/jdbcConnection")
public class jdbcConnection extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static Connection connection;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public jdbcConnection() {
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out = response.getWriter();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mySQL://localhost:3306/webapp";
			String user = "root";
			String password = "Ntcong0368279613";
			connection = DriverManager.getConnection(url, user, password);
			System.out.println(connection);
			out.println("Connected");
			
			connection.close();
			out.println("Disconnected");
			
		} catch (ClassNotFoundException e) {
			out.println("Can not connect !");
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
