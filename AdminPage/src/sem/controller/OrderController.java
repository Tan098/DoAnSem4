package sem.controller;

import java.sql.Timestamp;
import java.util.Date;
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

import sem.dao.CartAndBookDAO;
import sem.dao.CartDAO;
import sem.dao.CategoryDAO;
import sem.dao.OrderDAO;
import sem.entities.sem_cart;
import sem.entities.sem_cart_book;
import sem.entities.sem_category;
import sem.entities.sem_order;

@Controller
public class OrderController {
	@Autowired
	private OrderDAO orderDAO;
	@Autowired
	private CartAndBookDAO cartAndBookDAO;
	@Autowired
	private CategoryDAO categoryDAO;
	@Autowired
	private CartDAO cartDao;

	@RequestMapping(value = "pre-order", method = RequestMethod.GET)
	public String preOrder(HttpSession session, Model model) {
		List<sem_category> listc = categoryDAO.getCategories();
		model.addAttribute("listc", listc);
		sem_order order = new sem_order();
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
				model.addAttribute("order", order);
				return "pre-order";
			}
		}
	}

	@RequestMapping(value = "pre-order", method = RequestMethod.POST)
	public String preOrder(@ModelAttribute("order") sem_order order, Model model, ModelMap mm,
			HttpServletRequest request, HttpSession session) {
		int cusid = (int) session.getAttribute("cusid");
		// Tạo một giỏ hàng cho người dùng
		sem_cart cart = new sem_cart();
		cart.setCustomer(cusid);
		cart.setDatecreate(new Timestamp(new Date().getTime()));
		cartDao.insertCart(cart);
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
			order.setTimeorder(new Timestamp(new Date().getTime()));
			order.setStatus(false);
			// Gọi tới phương thức insertCustomer
			orderDAO.insertOrder(order);
			// Tiến hành lưu danh sách sản phẩm vào database
			// Gọi danh sách sản phẩm đã lưu trong session
			HashMap<Integer, sem_cart_book> cartItems = (HashMap<Integer, sem_cart_book>) session.getAttribute("cart");
			// Nếu như không có sản phẩm nào trong danh sách
			if (cartItems == null)
				cartItems = new HashMap<>();
			// Gọi vòng lặp for để duyệt toàn bộ sản phẩm có trong session
			for (Map.Entry<Integer, sem_cart_book> entry : cartItems.entrySet()) {
				// Gán tất cả các thành phần của sản phẩm vào
				sem_cart_book cart_book = new sem_cart_book();
				// Set từng giá trị vào các cột ánh xạ tới bảng.
				cart_book.setCart(cart);
				cart_book.setBook(entry.getValue().getBook());
				cart_book.setOrder(order);
				cart_book.setPrice(entry.getValue().getPrice());
				cart_book.setQuantity(entry.getValue().getQuantity());
				// Gọi tới hàm lưu sản phẩm
				cartAndBookDAO.insertItems(cart_book);
			}
			session.removeAttribute("cart");
			return "success";
		} else {
			return "pre-order";
		}
	}

	@RequestMapping(value = "success")
	public String success(Model model) {
		List<sem_category> listc = categoryDAO.getCategories();
		model.addAttribute("listc", listc);
		return "success";
	}
}
