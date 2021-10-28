package sem.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import sem.dao.CartDAO;
import sem.entities.sem_cart;
import sem.entities.sem_customer;

@Controller
public class OrderController {
	@Autowired
	private CartDAO cartDao;
	
	@RequestMapping("/order")
	public String s_Order(HttpSession session, HttpServletRequest request, HttpServletResponse response,
			ModelMap model)
	{
		sem_customer customer = (sem_customer) session.getAttribute("current_customer");
		sem_cart cart = (sem_cart) session.getAttribute("cart");
		// Nếu người dùng đã đăng nhập và giỏ hàng đã có hàng
		if(customer != null && cart != null) {
			// Lấy người dùng hiện tại
			cart.setCustomer(customer.getId());
			// Lưu giỏ hàng vào database
			cartDao.insertCart(cart);
		}
		// Xóa toàn bộ sản phẩm khỏi giỏ
		session.removeAttribute("cart");
		return "pre-order";
	}
}
