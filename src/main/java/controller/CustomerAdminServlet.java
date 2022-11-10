package controller;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Context.DBConnection;
import DAO.DaoCart;
import model.cart;

/**
 * Servlet implementation class CustomerAdminServlet
 */
@WebServlet("/CustomerAdminServlet")
public class CustomerAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	static cart cart;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerAdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		try {
			//Tạo kết nối
			Connection con = DBConnection.getConnection();			
//			HttpSession session = request.getSession();
			//Lấy thông tin từ form
			String action2 = request.getParameter("action2");
			System.out.println(action2);
			
			String product_name = request.getParameter("product_name");
			String product_named = request.getParameter("product_named");
			
			//Set up truy vấn
			String condition = "product_name = '"+product_name+"'" ;
			
			
			String messageUpdate = "";
			String messageDelete = "";
			DaoCart dc = null;

			System.out.println("Condition: "+condition);
			//Thực hiện lệnh
			if(action2.equals("dodelete")) {
				System.out.println("chạy");
				int intDelete = dc.getInstance().deleteCondition(condition);
				messageDelete = "Your cart is deleted";
				request.setAttribute("messageDelete", messageDelete);
				
				request.getRequestDispatcher("/CustomerAD.jsp").forward(request, response);
			}
			
			if(action2.equals("doupdate")) {
				int quantity = Integer.parseInt(request.getParameter("quantity"));
				String set = "quantity = "+quantity;
				int intUpdate = dc.getInstance().updateCondition(set,condition);
				messageUpdate = "Your cart is updated";
				request.setAttribute("messageUpdate", messageUpdate);
				
				request.getRequestDispatcher("/CustomerAD.jsp").forward(request, response);
			} else {
				String messageAction = "No action";
				request.setAttribute("messageAction", messageAction);
			}
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			// Ngắt kết nối
			DBConnection.disConnection(con);
			
		} catch(NullPointerException e) {
			RequestDispatcher rd = request.getRequestDispatcher("CustomerAD.jsp");
			rd.forward(request, response);
		} catch(Exception ex) {
			response.getWriter().println(ex);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		doGet(request, response);
		try {
			//Tạo kết nối
			Connection con = DBConnection.getConnection();	
			HttpSession session = request.getSession();
			
			//lấy thông tin từ client
			String action = request.getParameter("action");
			String cus_name = request.getParameter("cus_name");
			String cus_phone = request.getParameter("cus_phone");
			
			
			//Truy vấn dữ liệu từ database
			String condition = "cus_name = '"+cus_name+"' and cus_phone='"+cus_phone+"'";
			DaoCart dc = new DaoCart();
			cart = dc.getInstance().selectByConditionOB(condition);
			
			String product_name = cart.getProduct_name();
			Double product_price = cart.getProduct_price();
			int quantity = cart.getQuantity();
			Double amount_product = cart.getAmount_product();
			Double total = cart.getTotal();
			
			
			

			
			//Hiển thị thông tin
			String message = "";
			
			if(action.equals("dosubmit")) {
				if(product_name != null) {
					message = "Hello: "+cus_name;
					session.setAttribute("message", message);
					session.setAttribute("cus_name", cus_name);
					session.setAttribute("cus_phone", cus_phone);
					session.setAttribute("product_name", product_name);
					session.setAttribute("product_price", product_price);
					session.setAttribute("quantity", quantity);
					session.setAttribute("amount_product", amount_product);
					session.setAttribute("total", total);
				} else {
					message = "Your cart is not exits !";
					session.setAttribute("message", message);
				}
				
				
				request.getRequestDispatcher("/CustomerAD.jsp").forward(request, response);
			}
			
			
			
			
			//-------------------------result---------------------
					


			
			
			
			
			
			
			
			
			// Ngắt kết nối
			DBConnection.disConnection(con);
			
		} catch(NullPointerException e) {
			RequestDispatcher rd = request.getRequestDispatcher("CustomerAD.jsp");
			rd.forward(request, response);
		} catch(Exception ex) {
			response.getWriter().println(ex);
		}
	}

}
