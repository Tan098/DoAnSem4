package sem.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import sem.dao.AccountDAO;
import sem.entities.sem_account;

@Controller
public class AccountController {
	@Autowired
	private AccountDAO accountDAO;

	@RequestMapping(value = "/listAccounts")
	public String listAccounts(Model model) {
		List<sem_account> list = accountDAO.getAccounts();
		model.addAttribute("list", list);

		return "listAccounts";
	}

	@RequestMapping("/initRegisterAccount")
	public String initRegisterAccount(Model model) {
		sem_account a = new sem_account();
		model.addAttribute("a", a);

		return "insertAccount";
	}

	@RequestMapping("/registerAccount")
	public String registerAccount(@ModelAttribute("a") sem_account a, Model model) {
		boolean bl = accountDAO.registerAccount(a);
		if (bl) {
			return "redirect:/loginAdmin";
		} else {
			model.addAttribute("err", "Register Failed !");
			model.addAttribute("a", a);

			return "registerAccount";
		}
	}

	@RequestMapping(value = "/changePassAdmin", method = RequestMethod.GET)
	public String changePassAdmin(@RequestParam("username") String username, Model model, HttpSession session) {
		Object object = session.getAttribute("admin");
		if (object != null) {
			sem_account accountById = accountDAO.getAccountById(username);
			model.addAttribute("a", accountById);

			return "changePassAdmin";			
		} else {
			return "loginAdmin";
		}
	}

	@RequestMapping(value = "/changePassAdmin", method = RequestMethod.POST)
	public String changePassAdmin(@ModelAttribute("a") sem_account a, Model model) {
		boolean bl = accountDAO.updateAccount(a);
		if (bl) {
			return "redirect:/loginAdmin";

		} else {
			model.addAttribute("err", "Update Failed !");
			model.addAttribute("a", a);

			return "changePassAdmin";
		}
	}
}
