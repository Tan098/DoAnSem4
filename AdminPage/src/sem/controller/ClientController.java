package sem.controller;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import sem.dao.BookDAO;
import sem.dao.CategoryDAO;
import sem.dao.CustomerDAO;
import sem.dao.ImageDAO;
import sem.entities.sem_account;
import sem.entities.sem_book;
import sem.entities.sem_category;
import sem.entities.sem_customer;
import sem.entities.sem_image;

@Controller
public class ClientController {
	@Autowired
	private ImageDAO imageDAO;
	@Autowired
	private BookDAO bookDao;
	@Autowired
	private CategoryDAO categoryDAO;
	@Autowired
	private CustomerDAO customerDAO;

	@InitBinder
	public void initBinder(WebDataBinder data) {
		SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
		s.setLenient(false);
		data.registerCustomEditor(Date.class, new CustomDateEditor(s, true));
	}

	@RequestMapping(value = "/homeClient")
	public String HomeClient(Model model, Integer offset, Integer maxResults) {
		List<sem_book> list = bookDao.getBooks(offset, maxResults);
		List<sem_category> listc = categoryDAO.getCategories();
		model.addAttribute("listc", listc);
		model.addAttribute("list", list);

		return "homeClient";
	}

	@RequestMapping(value = "/detailBook")
	public String detailBook(@RequestParam("id") Integer id, Model model) {
		sem_book bookById = bookDao.getBookById(id);
		model.addAttribute("b", bookById);

		return "detailBook";
	}

	@RequestMapping("/searchBook")
	public String searchBook(HttpServletRequest request, Model model, String name) {
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		name = request.getParameter("name");
		if (name.length() == 0) {
			name = "%";
		}
		List<sem_category> listc = categoryDAO.getCategories();
		model.addAttribute("listc", listc);
		List<sem_book> list = bookDao.searchBook(name);
		model.addAttribute("list", list);
		model.addAttribute("name", name);
		return "product";
	}

	// Customer
	@RequestMapping(value = "/initRegisterCustomer")
	public String initRegisterCustomer(Model model) {
		sem_customer c = new sem_customer();
		List<sem_category> listc = categoryDAO.getCategories();
		model.addAttribute("listc", listc);
		model.addAttribute("c", c);
		return "registerCustomer";
	}

	@RequestMapping(value = "/registerCustomer")
	public String registerCustomer(@ModelAttribute("c") sem_customer c, Model model, HttpServletRequest request) {
		// Khởi tạo các giá trị tương ứng với bảng sem_customer
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String birthday = request.getParameter("birthday");
		String phonenumbers = request.getParameter("phonenumbers");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		// Khởi tạo đối tượng bắt lỗi và validate form
		String errorName = "";
		String errorAddress = "";
		String errorBirthday = "";
		String errorPhonenumbers = "";
		String errorUsername = "";
		String errorPassword = "";
		// Lấy danh sách khách hàng
		sem_customer customer = customerDAO.getCustomerByUsername(username);
		// Kiểm tra trống
		if (name.isEmpty())
			errorName = "Tên không được để chống";
		if (address.isEmpty())
			errorAddress = "Địa chỉ không được để chống";
		if (birthday.isEmpty())
			errorBirthday = "Ngày tháng năm sinh không được để chống";
		if (phonenumbers.isEmpty())
			errorPhonenumbers = "Điện thoại không được để chống";
		if (username.isEmpty()) {
			errorUsername = "Tên đăng nhập không được để chống";
		} else {
			// Kiểm tra nếu tên đăng nhập đã tồn tại
			if (customer != null)
				errorUsername = "Tên đăng nhập đã tồn tại";
		}
		if (password.isEmpty())
			errorPassword = "Mật khẩu không được để chống";
		// Thông báo lỗi
		request.setAttribute("errorName", errorName);
		request.setAttribute("errorAddress", errorAddress);
		request.setAttribute("errorBirthday", errorBirthday);
		request.setAttribute("errorPhonenumbers", errorPhonenumbers);
		request.setAttribute("errorUsername", errorUsername);
		request.setAttribute("errorPassword", errorPassword);
		// Nếu người dùng không mắc lỗi nào
		if ("".equals(errorName) && "".equals(errorAddress) && "".equals(errorBirthday) && "".equals(errorPhonenumbers)
				&& "".equals(errorUsername) && "".equals(errorPassword)) {
			// Gọi tới phương thức insertCustomer
			boolean bl = customerDAO.insertCustomer(c);
			if (bl) { // Nếu thành công
				return "redirect:/loginClient";
			} else { // Nếu thất bại
				model.addAttribute("c", c);
				return "registerCustomer";
			}
		} else {
			return "registerCustomer";
		}
	}

	@RequestMapping(value = "updateProfile", method = RequestMethod.GET)
	public String updateProfile(@RequestParam("id") Integer id, Model model) {
		List<sem_category> listc = categoryDAO.getCategories();
		model.addAttribute("listc", listc);
		sem_customer getCusId = customerDAO.getCustomerById(id);
		model.addAttribute("c", getCusId);
		return "updateProfile";
	}

	@RequestMapping(value = "updateProfile", method = RequestMethod.POST)
	public String updateProfile(@ModelAttribute("c") sem_customer c, HttpServletRequest request, Model model) {
		// Khởi tạo các giá trị tương ứng với bảng sem_customer
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String phonenumbers = request.getParameter("phonenumbers");
		String password = request.getParameter("password");
		// Khởi tạo đối tượng bắt lỗi và validate form
		String errorName = "";
		String errorAddress = "";
		String errorPhonenumbers = "";
		String errorPassword = "";
		// Kiểm tra trống
		if (name.isEmpty())
			errorName = "Tên không được để chống";
		if (address.isEmpty())
			errorAddress = "Địa chỉ không được để chống";
		if (phonenumbers.isEmpty())
			errorPhonenumbers = "Điện thoại không được để chống";
		if (password.isEmpty())
			errorPassword = "Mật khẩu không được để chống";
		// Thông báo lỗi
		request.setAttribute("errorName", errorName);
		request.setAttribute("errorAddress", errorAddress);
		request.setAttribute("errorPhonenumbers", errorPhonenumbers);
		request.setAttribute("errorPassword", errorPassword);
		// Nếu người dùng không mắc lỗi nào
		if ("".equals(errorName) && "".equals(errorAddress) && "".equals(errorPhonenumbers)
				&& "".equals(errorPassword)) {
			// Gọi tới phương thức updateCustomer
			boolean bl = customerDAO.updateCustomer(c);
			if (bl) { // Nếu thành công
				return "redirect:/homeClient";
			} else { // Nếu thất bại
				model.addAttribute("c", c);
				return "updateProfile";
			}
		} else {
			return "updateProfile";
		}
	}
}
