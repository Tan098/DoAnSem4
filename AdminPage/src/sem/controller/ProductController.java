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
import sem.dao.ImageDAO;
import sem.entities.sem_book;
import sem.entities.sem_category;
import sem.entities.sem_image;

@Controller
public class ProductController {
	// Home
		
		@Autowired
		private ImageDAO imageDAO;

		@Autowired
		private BookDAO bookDao;
		@Autowired
		private CategoryDAO categoryDAO;

		@InitBinder
		public void initBinder(WebDataBinder data) {
			SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
			s.setLenient(false);
			data.registerCustomEditor(Date.class, new CustomDateEditor(s, true));
		}
		
		@RequestMapping(value = "/product")
		public String Product(Model model) {
			List<sem_book> list = bookDao.getBooks();
			List<sem_category> listc = categoryDAO.getCategories();
			//List<sem_image> listi = imageDAO.getImages();
			model.addAttribute("listc", listc);
			//model.addAttribute("listi", listi);
			model.addAttribute("list", list);
			return "product";
		}
		
		
		@RequestMapping("/detailBookProduct")
			public String detailBookProduct(@RequestParam("id") Integer id, Model model) {
			sem_book bookById = bookDao.getBookById(id);
			model.addAttribute("b", bookById);

			return "detailBook";
		}

	
}
