package sem.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.*;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import sem.entities.*;

@Controller
public class LoginController {
	@RequestMapping(value = {"/loginAdmin", "/"},method=RequestMethod.GET)
	public String Login(ModelMap mm) {
		mm.put("acc", new sem_account());
		return "loginAdmin";
	}
	
	@RequestMapping(value = "/loginAdmin",method=RequestMethod.POST)
	public String Login(@ModelAttribute(value = "acc") sem_account acc,  ModelMap mm ,HttpSession session) {
		if (acc.getUsername().equals("admin") && acc.getPassword().equals("12345")) {
			session.setAttribute("username", acc.getUsername());
			return "home";
		}else {
			mm.put("message","Tài khoản hoặc mật khẩu không đúng!<br>");
			return "loginAdmin";
		}
		
	}
}
