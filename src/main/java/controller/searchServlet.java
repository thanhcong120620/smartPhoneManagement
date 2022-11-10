package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Context.DBConnection;
import DAO.DaoProducts;
import model.Products;

/**
 * Servlet implementation class searchServlet
 */
@WebServlet("/searchServlet")
public class searchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public searchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		doGet(request, response);
		
		try {
		Connection con = DBConnection.getConnection();
		
		String searchInfo = request.getParameter("searchProduct");
		System.out.println("seacrhInfo: " +searchInfo);
		String message = "";
		String placeholder = "  Bạn đã tìm "+searchInfo +"   | EL";
		String action = request.getParameter("action");
		System.out.println("action: "+action);
		
		//Xử lý chuỗi nhập vào
		String searchProduct = "product_name like '" + searchInfo + "%'";
		System.out.println("searchProduct: "+searchProduct);
		
		//Hiển thị trang tìm kiếm
		String searchProductHienThi = "select * from products where "+searchProduct;
		System.out.println(searchProductHienThi);
		
		request.setAttribute("placeholder", placeholder);

		
		ArrayList<Products> listProducts = DaoProducts.getInstance().selectByCondition(searchProduct);
		
		request.setAttribute("message", message);
		request.setAttribute("listProducts", listProducts);
		
		
		if(action.equals("dosearch")) {
			//Nếu đúng thì thêm vào list
			if(listProducts.size() != 0) {
//				request.setAttribute("searchProduct", searchProduct);
//				request.setAttribute("listProducts", listProducts);
				request.setAttribute("searchProductHienThi", searchProductHienThi);
				request.getRequestDispatcher("/kqua.jsp").forward(request, response);
			}
			
			//Nếu sai thì xuất thông báo và quay về lại home.jsp
			else {
				message = "Sản phẩm đã bán hết hoặc không tồn tại !";
				request.setAttribute("message", message);
				request.getRequestDispatcher("/home.jsp").forward(request, response);
			}
						
			
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
			rd.forward(request, response);
		}
		
		
		//Ngắt kết nối
		DBConnection.disConnection(con);
		
		} catch(NullPointerException e) {
			request.getRequestDispatcher("/home.jsp").forward(request, response);
		} catch(Exception ex) {
			response.getWriter().println(ex);
		}
		
	}

}
