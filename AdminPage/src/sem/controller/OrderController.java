package sem.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import sem.dao.CategoryDAO;
import sem.dao.OrderDAO;
import sem.entities.sem_cart_book;
import sem.entities.sem_category;
import sem.entities.sem_customer;
import sem.entities.sem_order;

@Controller
public class OrderController {
	@Autowired
	private OrderDAO orderDAO;
	@Autowired
	private CategoryDAO categoryDAO;

	@RequestMapping(value = "pre-order", method = RequestMethod.GET)
	public String preOrder(HttpSession session, Model model) {
		List<sem_category> listc = categoryDAO.getCategories();
		model.addAttribute("listc", listc);
		sem_order o = new sem_order();
		// Khai báo session có tên là client
		Object objectCust = session.getAttribute("client");
		Object objectCart = session.getAttribute("cart");
		// Kiểm tra nếu người dùng chưa đăng nhập
		if (objectCust == null) {
			return "loginClient";
		} else {
			// Kiểm tra giỏ hàng có hàng hay chưa
			if (objectCart == null) {// Nếu giỏ hàng trống thì chả về trang home
				return "homeClient";
			} else {
				model.addAttribute("o", o);
				return "pre-order";
			}
		}
	}

	@RequestMapping(value = "pre-order", method = RequestMethod.POST)
	public String preOrder(@ModelAttribute("o") sem_order o, Model model, HttpServletRequest request,
			HttpSession session) {
		// Khởi tạo các giá trị tương ứng với bảng sem_order
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String phonenumbers = request.getParameter("phonenumbers");
		// Khởi tạo đối tượng bắt lỗi và validate form
		String errName = "";
		String errAddress = "";
		String errPhonenumbers = "";
		// Kiểm tra trống
		if (name.isEmpty())
			errName = "Tên không được để chống";
		if (address.isEmpty())
			errAddress = "Địa chỉ không được để chống";
		if (phonenumbers.isEmpty())
			errPhonenumbers = "Điện thoại không được để chống";
		// Thông báo lỗi
		request.setAttribute("errName", errName);
		request.setAttribute("errAddress", errAddress);
		request.setAttribute("errPhonenumbers", errPhonenumbers);
		// Nếu người dùng không mắc lỗi nào
		if ("".equals(errName) && "".equals(errAddress) && "".equals(errPhonenumbers)) {
			// Gọi tới phương thức insertCustomer
			boolean bl = orderDAO.insertOrder(o);
			if (bl) { // Nếu thành công
				return "redirect:/homeClient";
			} else { // Nếu thất bại
				model.addAttribute("o", o);
				return "pre-order";
			}
		} else {
			return "pre-order";
		}
		// 
	}
}
