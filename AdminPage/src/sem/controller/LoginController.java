package sem.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import sem.dao.AccountDAO;
import sem.dao.CategoryDAO;
import sem.dao.CustomerDAO;
import sem.dao.impl.AccountDAOImpl;
import sem.entities.sem_account;
import sem.entities.sem_category;
import sem.entities.sem_customer;
import sem.entities.sem_order;

@Controller
public class LoginController {
	@Autowired
	private AccountDAO accountDAO;
	@Autowired
	private CustomerDAO customerDAO;
	@Autowired
	private CategoryDAO categoryDAO;

	@RequestMapping(value = { "/loginAdmin", "/" }, method = RequestMethod.GET)
	public String loginAdmin(ModelMap mm) {
		mm.put("acc", new sem_account());
		return "loginAdmin";
	}

	@RequestMapping(value = "/loginAdmin", method = RequestMethod.POST)
	public String loginAdmin(HttpSession session, HttpServletRequest request, HttpServletResponse response) {
		// Lấy tài khoản và mật khẩu
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		// Báo lỗi
		String err = "";
		// Trả về đối tượng người dùng đã đăng nhập
		sem_account account = accountDAO.loginAccount(username, password);
		// Kiểm tra đăng nhập
		// Nếu tài khoàn tồn tại
		if (account != null) {
			session.setAttribute("username", account.getName());
			return "home";
		} else {
			err = "Tài khoản hoặc mật khẩu không đúng!";
			request.setAttribute("err", err);
			return "loginAdmin";
		}
	}

	// Login cho client
	@RequestMapping(value = "/loginClient", method = RequestMethod.GET)
	public String loginClient(ModelMap map, Model model) {
		List<sem_category> listc = categoryDAO.getCategories();
		model.addAttribute("listc", listc);
		map.put("cus", new sem_customer());
		return "loginClient";
	}

	@RequestMapping(value = "/loginClient", method = RequestMethod.POST)
	public String loginClient(HttpSession session, HttpServletRequest request, HttpServletResponse response,
			ModelMap map) {
		// Lấy tài khoản và mật khẩu
		String username = request.getParameter("user");
		String password = request.getParameter("pass");
		// Báo lỗi
		String err = "";
		// Trả về đối tượng người dùng đã đăng nhập
		sem_customer customer = customerDAO.g_LoginClient(username, password);
		// Khai báo session có tên là client
		Object object = session.getAttribute("client");
		// Nếu tài khoàn tồn tại
		if (customer != null) {
			// Lấy thông tin người dùng đẩy vào order
			sem_order order = new sem_order();
			// Thêm từng giá trị vào order
			order.setName(customer.getName());
			order.setAddress(customer.getAddress());
			order.setPhonenumbers(customer.getPhonenumbers());
			// Lưu vào session
			session.setAttribute("client", order);
			// Trả về trang home
			return "redirect:/homeClient";
		} else {
			// Trả về lỗi
			err = "Tài khoản hoặc mật khẩu không đúng!";
			request.setAttribute("err", err);
			return "loginClient";
		}
	}
}
