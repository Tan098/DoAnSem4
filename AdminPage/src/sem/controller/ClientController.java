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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import sem.dao.BookDAO;
import sem.dao.CategoryDAO;
import sem.dao.HomeDAO;
import sem.entities.sem_book;
import sem.entities.sem_category;

@Controller
public class ClientController {
	// Home
		
		@Autowired
		private HomeDAO homeDAO;
		@Autowired
		private BookDAO bookDao;
		@Autowired
		private CategoryDAO categoryDAO;

		@RequestMapping(value = "/homeClient")
		public String HomeClient(Model model) {
			List<sem_book> list = bookDao.getBooks();
			List<sem_category> listc = categoryDAO.getCategories();
			model.addAttribute("listc", listc);
			model.addAttribute("list", list);
			
			return "homeClient";
		}
		@InitBinder
		public void initBinder(WebDataBinder data) {
			SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
			s.setLenient(false);
			data.registerCustomEditor(Date.class, new CustomDateEditor(s, true));
		}
		
		
		
		
		@RequestMapping("/detailBookHome")
		public String detailBookHome(@RequestParam("id") Integer id, Model model) {
			sem_book bookById = homeDAO.getBookByIdHome(id);
			model.addAttribute("b", bookById);

			return "detailBook";
		}

	
}
