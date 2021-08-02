package sem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import sem.dao.AuthorDAO;
import sem.entities.sem_author;

@Controller
public class AuthorController {
	@Autowired
	private AuthorDAO authorDao;

	@RequestMapping(value = { "/listAuthors", "/" })
	public String listAuthors(Model model,Integer offset, Integer maxResult) {
		List<sem_author> list = authorDao.getAuthors(offset == null ?0:offset,maxResult==null?15:maxResult);
		model.addAttribute("list", list);

		return "listBook";
	}

	@RequestMapping("/initInsertAuthor")
	public String initInsertAuthor(Model model) {
		sem_author a = new sem_author();
		model.addAttribute("a", a);

		return "insertAccount";
	}

	@RequestMapping("/insertAuthor")
	public String insertBook(@ModelAttribute("a") sem_author a, Model model) {
		boolean bl = authorDao.insertAuthor(a);
		if (bl) {
			return "redirect:/listAuthors";
		} else {
			model.addAttribute("err", "Insert Failed !");
			model.addAttribute("a", a);

			return "insertAuthor";
		}
	}

	@RequestMapping("/initUpdate")
	public String initUpdate(@RequestParam("id") Integer id, Model model) {
		sem_author authorById = authorDao.getAuthorById(id);
		model.addAttribute("a", authorById);

		return "updateAuthor";
	}

	@RequestMapping("/updateAuthor")
	public String updateAuthor(@ModelAttribute("a") sem_author a, Model model) {
		boolean bl = authorDao.updateAuthor(a);
		if (bl) {
			return "redirect:/listAuthors";

		} else {
			model.addAttribute("err", "Update Failed !");
			model.addAttribute("a", a);

			return "updateAccount";
		}
	}

	@RequestMapping("/detailAuthor")
	public String detailAuthor(@RequestParam("id") Integer id, Model model) {
		sem_author authorById = authorDao.getAuthorById(id);
		model.addAttribute("a", authorById);

		return "detailAuthor";
	}

	@RequestMapping("/deleteAuthor")
	public String deleteAuthor(@RequestParam("id") Integer id, Model model,Integer offset, Integer maxResult) {
		boolean bl = authorDao.deleteAuthor(id);
		if (bl) {
			model.addAttribute("success", "Delete success !");
		} else {
			model.addAttribute("err", "Delete failed !");
		}
		List<sem_author> list = authorDao.getAuthors(offset == null ?0:offset,maxResult==null?15:maxResult);
		model.addAttribute("list", list);
		return "listAuthor";
	}
}
