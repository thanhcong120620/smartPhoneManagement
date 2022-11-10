package Test;

import DAO.DaoCart;
import DAO.DaoOrders;
import model.Orders;
import model.cart;

public class test {
	public static void main(String[] args) {
//		DaoProducts dp = new DaoProducts();
//		Products list = DaoProducts.getInstance().selectByConditionOB("product_name='iPhone 13'");
//		System.out.println(list.toString());
		
		DaoCart dc = new DaoCart();
//		Orders cart = new Orders("od0", "phone", "dt", "", "", "cus1");
		String set = "total = 113.3";
		String condition = "product_name='dt'";
		int list2 = dc.getInstance().deleteCondition(condition);
		System.out.println(list2);
	}
}
