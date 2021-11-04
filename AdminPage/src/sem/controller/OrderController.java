package sem.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import sem.dao.CategoryDAO;
import sem.dao.OrderDAO;
import sem.entities.sem_category;
import sem.entities.sem_order;

@Controller
public class OrderController {
	@Autowired
	private OrderDAO orderDAO;
	@Autowired
	private CategoryDAO categoryDAO;

	@RequestMapping("/order")
	public String order(HttpSession session, HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		List<sem_category> listc = categoryDAO.getCategories();
		model.addAttribute("listc", listc);
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
				return "pre-order";
			}
		}
	}

	@RequestMapping("/pre-order")
	public String preOrder(@ModelAttribute("c") sem_order c, HttpSession session, HttpServletRequest request,
			HttpServletResponse response, Model model) {
		// Khởi tạo các giá trị tương ứng với bảng sem_order
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String phonenumbers = request.getParameter("phonenumbers");
		// Khởi tạo đối tượng bắt lỗi và validate form
		String errorName = "";
		String errorAddress = "";
		String errorPhonenumbers = "";
		// Kiểm tra trống
		if (name.isEmpty())
			errorName = "Tên không được để chống";
		if (address.isEmpty())
			errorAddress = "Địa chỉ không được để chống";
		if (phonenumbers.isEmpty())
			errorPhonenumbers = "Điện thoại không được để chống";
		// Thông báo lỗi
		request.setAttribute("errorName", errorName);
		request.setAttribute("errorAddress", errorAddress);
		request.setAttribute("errorPhonenumbers", errorPhonenumbers);
		// Nếu người dùng không mắc lỗi nào
		if ("".equals(errorName) && "".equals(errorAddress) && "".equals(errorPhonenumbers)) {
			// Gọi tới phương thức insertOrder
			boolean bl = orderDAO.insertOrder(c);
			if (bl) { // Nếu thành công
				return "redirect:/orderSuccess";
			} else { // Nếu thất bại
				model.addAttribute("c", c);
				return "pre-order";
			}
		} else {
			return "pre-order";
		}
	}
}
