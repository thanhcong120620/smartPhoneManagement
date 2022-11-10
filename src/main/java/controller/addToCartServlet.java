package controller;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Context.DBConnection;
import DAO.DaoCart;
import DAO.DaoCustomer;
import DAO.DaoOrderDetails;
import DAO.DaoOrders;
import DAO.DaoProducts;
import model.Customer;
import model.OrderDetails;
import model.Orders;
import model.Products;
import model.cart;

/**
 * Servlet implementation class addToCartServlet
 */
@WebServlet("/addToCartServlet")
public class addToCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static String product_id;
	static String productname;
	static Double product_price;
	static String order_id;
	static String cus_id;
	static int quantity =1;
	static Double amount_product;
	static Double total;
	static String check;
	static Products products;
//	static Customer customer;
	static String cus_name, cus_phone, cus_mail, cus_address, order_discount, order_date;
	static int cus_age;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addToCartServlet() {
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
		// Lấy thông tin từ form khách hàng
		String action2 = request.getParameter("action2");
		
		System.out.println(action2);
		cus_name = request.getParameter("cus_name");
		cus_age = Integer.parseInt(request.getParameter("cus_age"));
		cus_phone = request.getParameter("cus_phone");
		cus_mail = request.getParameter("cus_mail");
		cus_address = request.getParameter("cus_address");
		order_discount = request.getParameter("order_discount");
		order_date = request.getParameter("order_date");
		
		
		
		if(action2.equals("dosubmit")) {
			addData();
			
			request.getRequestDispatcher("/home.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("/home.jsp").forward(request, response);
		}
		
		//Ngắt kết nối
		DBConnection.disConnection(con);

		
		} catch(NullPointerException e) {
			request.getRequestDispatcher("/home.jsp").forward(request, response);
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
		
		String action = request.getParameter("action");
		System.out.println(action);
		
		//Lưu thông tin sản phẩm 
		productname = request.getParameter("productname");
		System.out.println(productname);
		
		HttpSession session = request.getSession();
		String conditionPrN = "product_name = '"+productname+"'";
		
		
		//Truy vấn có điều kiện từ database và thêm vào arraylist
		products = DaoProducts.getInstance().selectByConditionOB(conditionPrN);

		product_id = products.getProduct_id();
		product_price = products.getProduct_price();
		String conditionODN = "product_id = '" + product_id +"'";
		OrderDetails order_detail = DaoOrderDetails.getInstance().selectByConditionOB(conditionODN);

		
		//Nếu có acction add cart -->	set up cart & chuyển đến cart page	
		if(action.equals("doaddtocart")) {
			
			setUpCart();
			
			session.setAttribute("productname", productname);
			session.setAttribute("quantity", quantity);
			session.setAttribute("product_price", product_price);
			session.setAttribute("amount_product", amount_product);
			session.setAttribute("total", total);
			
			request.getRequestDispatcher("/cart.jsp").forward(request, response);
			
			//Nếu có acction submit --> Lấy thông tin lưu vào data base

			
		}
		else {
			request.getRequestDispatcher("/home.jsp").forward(request, response);
		}
		
//----------------------------

		
		//Ngắt kết nối
		DBConnection.disConnection(con);

		
		
		} catch(NullPointerException e) {
			request.getRequestDispatcher("/home.jsp").forward(request, response);
		} catch(Exception ex) {
			response.getWriter().println(ex);
		}
	}
	
	public void addData() {
		addDataCart();
			addDataCustomer();
				addDataOrders();
					addDataOrdersDetail();
	}
	
	public void setUpCart() {
		if(product_id.equalsIgnoreCase(check)) {
			quantity = quantity +1;
//			check = product_id;
		} else {
			quantity = 1;
		}
		check = product_id;
		amount_product = product_price * quantity;
		total = amount_product;
	}
	
	public int addDataOrdersDetail() {
		
		OrderDetails order_detailMD = new OrderDetails(order_id, product_id, amount_product, product_price);
		int checkOrderDeatail = DaoOrderDetails.getInstance().insert(order_detailMD);
		System.out.println("OrderDeatail success: "+checkOrderDeatail);
		
		return checkOrderDeatail;
	}
	
	
	public int addDataOrders() {
		int STT = DaoOrders.getInstance().count() + 1;
		order_id = "od" + STT;
		String order_status ="done";
		System.out.println(order_id);
		
		Orders orders = new Orders(order_id, order_status, order_date, order_discount, cus_address, cus_id);
		int checkOrder = DaoOrders.getInstance().insert(orders);
		System.out.println("checkOrder success: "+checkOrder);
		return checkOrder;
	}
	
	
	public int addDataCustomer() {
		int STT = DaoCustomer.getInstance().count() + 1;
		cus_id = "cus" + STT;
		System.out.println(cus_id);
		
		Customer customer = new Customer(cus_id, cus_name, cus_phone, cus_mail, cus_address, cus_age);
		int checkCustomer = DaoCustomer.getInstance().insert(customer);
		System.out.println("checkCustomer success: "+checkCustomer);
		return checkCustomer;
	}
	
	public int addDataCart() {
		cart cart = new cart(cus_name, cus_phone, productname, product_price, quantity, amount_product, total);
		int checkCart = DaoCart.getInstance().insert(cart);
		System.out.println("checkCart success: "+checkCart);
		return checkCart;
	}

}
