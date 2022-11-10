package controller;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Context.DBConnection;
import model.Account;
import model.AccountManagement;
import model.User;

/**
 * Servlet implementation class LoginServlet


// */

//@WebServlet(urlPatterns="/login", initParams = {@WebInitParam(name="username",value="cong"),
//		@WebInitParam(name="password",value="123") })
//@WebServlet(name = "LoginServlet", urlPatterns = { "/LoginServlet" })//sửa name lại trong web.xml
//@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
//		doGet(request, response);
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		try {
			//Tạo kết nối
			Connection con = DBConnection.getConnection();			
			String action = request.getParameter("action");
			System.out.println("action: "+action);
			
			
			/*Login*/
			if(action.equals("dologin")) {
			
			request.getSession(true).invalidate();
			
			//make sure that email is valid
			String regexMail = "^[A-Z0-9_a-z]+@[A-Z0-9\\.a-z]+\\.[A-Za-z]{2,6}$";
			String regex = "[a-zA-Z0-9_!@#$%^&*]+";
			
			//collect data from a login form
			String user = request.getParameter("username");
			String password = request.getParameter("password");
			
			Account acc = new Account();
			acc.setUsr(user);
			acc.setPwd(password);
			
			System.out.println("user: "+acc.getUsr());
			System.out.println("password: "+acc.getPwd());
			
			
			// create scope session
			HttpSession session = request.getSession(true);
			
			request.setAttribute("user", user);
			request.setAttribute("password", "");
			
			AccountManagement account = new AccountManagement(con);
			
			System.out.println("Boolean: " +account.login(user, password));
			
			if(account.login(user, password)) {
				request.getRequestDispatcher("/adminIndex.jsp").forward(request, response);
			} else {
				request.setAttribute("message", "email address or password not recognised");
				request.getRequestDispatcher("/login.jsp").forward(request, response);
			}
		}	// end login
		
			
			/*Register*/
			else if(action.equals("docreateaccount")) {
				String user_mail = request.getParameter("username");
				String password = request.getParameter("password");
				String password2 = request.getParameter("password2");
				String account_role = request.getParameter("age");
				String user_name = request.getParameter("fullName");
				String user_address = request.getParameter("mail");
				String user_phone = request.getParameter("phone");
				
				
				User user = new User(user_mail, password);
				System.out.println(action);
				request.setAttribute("email", user_mail);
				request.setAttribute("password", "");
				request.setAttribute("password2", "");
				
				AccountManagement account = new AccountManagement(con);
				
				//Kiểm tra mật khẩu trùng khớp
				if(!password.equals(password2)) {
				do {
					//mật khẩu ko khớp
					request.setAttribute("message", "Mat khau khong khop");
					request.getRequestDispatcher("/register.jsp").forward(request, response);
				} while(!password.equals(password2));
				}
				
				//Kiểm tra các giá trị nhập vào
				if(!user.validate()) {
				do {
					//email hoặc MK ko phù hợp
					request.setAttribute("message", user.getMessage());
					request.getRequestDispatcher("/register.jsp").forward(request, response);
				} while (!user.validate());
				}
				
				//Kiểm tra sự tồn tại của email nhập
				if(account.exists(user_mail)) {
				do {
					//email đã tồn tại trong database
					request.setAttribute("message", "Email đã tồn tại");
					request.getRequestDispatcher("/register.jsp").forward(request, response);
				} while(account.exists(user_mail));
				}
				
				//Gọi phương thức create()
				account.create(user_mail, password, account_role, user_name, user_address, user_phone);
				request.getRequestDispatcher("/home.jsp").forward(request, response);
				
			}
			
		
		// Ngắt kết nối
			DBConnection.disConnection(con);
			
			
		} catch(NullPointerException e) {
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		} catch(Exception ex) {
			response.getWriter().println(ex);
		}
		
		
	}
	
	

}
