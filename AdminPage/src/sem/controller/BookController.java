package sem.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import sem.dao.BookDAO;
import sem.dao.PublisherDAO;
import sem.entities.sem_book;
import sem.entities.sem_publisher;

@Controller
public class BookController {
	@Autowired
	private BookDAO bookDao;
	@Autowired
	private PublisherDAO pubDao;
	
	@InitBinder
	public void initBinder(WebDataBinder data) {
		SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
		s.setLenient(false);
		data.registerCustomEditor(Date.class, new CustomDateEditor(s, true));
	}
	
	/** Nhớ Declarce bean của nó ở file spring-config.xml **/
	
	@RequestMapping(value = "/listBooks")
	public String listBooks(Model model) {
		List<sem_book> list = bookDao.getBooks();
		model.addAttribute("list", list);
		
		
		return "listBooks";
	}

	@RequestMapping("/initInsertBook")
	public String initInsertBook(Model model) {
		sem_book b = new sem_book();
		model.addAttribute("b", b);

		List<sem_publisher> pub = pubDao.getPublishers();
		model.addAttribute("listp", pub);

		return "insertBook";
	}

	@RequestMapping("/insertBook")
	public String insertBook(@ModelAttribute("b") sem_book b, Model model) {
		boolean bl = bookDao.insertBook(b);
		if (bl) {
			return "redirect:/listBooks";
		} else {
			model.addAttribute("err", "Insert Failed !");
			model.addAttribute("b", b);

			List<sem_publisher> pub = pubDao.getPublishers();
			model.addAttribute("listp", pub);
			return "insertBook";
		}
	}

	@RequestMapping("/initUpdateBook")
	public String initUpdate(@RequestParam("id") Integer id, Model model) {
		sem_book bookById = bookDao.getBookById(id);
		model.addAttribute("b", bookById);

		List<sem_publisher> pub = pubDao.getPublishers();
		model.addAttribute("listp", pub);
		return "updateBook";
	}

	@RequestMapping("/updateBook")
	public String updateBook(@ModelAttribute("b") sem_book b, Model model) {
		boolean bl = bookDao.updateBook(b);
		if (bl) {
			return "redirect:/listBooks";

		} else {
			model.addAttribute("err", "Update Failed !");
			model.addAttribute("b", b);

			List<sem_publisher> pub = pubDao.getPublishers();
			model.addAttribute("listp", pub);
			return "updateBook";
		}
	}


<<<<<<< HEAD
//	@RequestMapping("/deleteBook")
//	public String deleteBook(@RequestParam("id") Integer id, Model model,Integer offset, Integer maxResult) {
//		boolean bl = bookDao.deleteBook(id);
//		if (bl) {
//			model.addAttribute("success", "Delete success !");
//		}else {
//			model.addAttribute("err", "Delete failed !");
//		}
//		List<sem_book> list = bookDao.getBooks(offset == null ?0:offset,maxResult==null?15:maxResult);
//		model.addAttribute("list", list);
//		return "listBooks";
//	}
=======
		return "detailBook";
	}

	@RequestMapping("/deleteBook")
	public String deleteBook(@RequestParam("id") Integer id, Model model) {
		boolean bl = bookDao.deleteBook(id);
		if (bl) {
			model.addAttribute("success", "Delete success !");
		}else {
			model.addAttribute("err", "Delete failed !");
		}
		List<sem_book> list = bookDao.getBooks();
		model.addAttribute("list", list);
		return "listBooks";
	}
>>>>>>> 8f961c7a1fc5e59629075750d4ea884e0f7a5c9c
}
