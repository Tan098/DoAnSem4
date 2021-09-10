package sem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
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

	@RequestMapping("/initUpdate")
	public String initUpdate(@RequestParam("id") Integer id, Model model) {
		sem_account accountById = accountDAO.getAccountById(id);
		model.addAttribute("a", accountById);

		return "updateAccount";
	}

	@RequestMapping("/updateAccount")
	public String updateAccount(@ModelAttribute("a") sem_account a, Model model) {
		boolean bl = accountDAO.updateAccount(a);
		if (bl) {
			return "redirect:/listAccounts";

		} else {
			model.addAttribute("err", "Update Failed !");
			model.addAttribute("a", a);

			return "updateAccount";
		}
	}

	@RequestMapping("/detailAccount")
	public String detailAccount(@RequestParam("id") Integer id, Model model) {
		sem_account accountById = accountDAO.getAccountById(id);
		model.addAttribute("a", accountById);

		return "detailAccount";
	}

	@RequestMapping("/deleteAccount")
	public String deleteAccount(@RequestParam("id") Integer id, Model model) {
		boolean bl = accountDAO.deleteAccount(id);
		if (bl) {
			model.addAttribute("success", "Delete success !");
		} else {
			model.addAttribute("err", "Delete failed !");
		}
		List<sem_account> list = accountDAO.getAccounts();
		model.addAttribute("list", list);
		return "listAccounts";
	}
}
