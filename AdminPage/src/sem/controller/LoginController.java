package sem.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import sem.dao.AccountDAO;
import sem.dao.impl.AccountDAOImpl;
import sem.entities.sem_account;

@Controller
public class LoginController {
	@Autowired
	private AccountDAO accountDAO;
	
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
}
