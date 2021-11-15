package sem.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import sem.dao.CategoryAndBookDAO;
import sem.dao.CategoryDAO;
import sem.dao.ImageDAO;
import sem.entities.sem_book;
import sem.entities.sem_category;
import sem.entities.sem_category_book;
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
		@Autowired
		private CategoryAndBookDAO categoryAndBookDAO;
		
		@InitBinder
		public void initBinder(WebDataBinder data) {
			SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
			s.setLenient(false);
			data.registerCustomEditor(Date.class, new CustomDateEditor(s, true));
		}
		
		@RequestMapping(value = "/product")
		public String Product(Model model, Integer offset, Integer maxResults) {
			List<sem_book> list = bookDao.getBooks(offset, maxResults); 
			List<sem_category> listc = categoryDAO.getCategories();
			model.addAttribute("offset", offset);
			model.addAttribute("total",bookDao.getTotal());
			model.addAttribute("listc", listc);
			model.addAttribute("list", list);
			return "product";
		}
		@RequestMapping(value = "/productByCate")
		public String Product(@RequestParam("id")Integer cateId,Model model, Integer offset, Integer maxResults) {
			//List<sem_book> list = bookDao.getBooks(offset, maxResults); có phải bookDAO đâu
			List<sem_category_book> list = categoryAndBookDAO.getListBycategory(cateId,offset,maxResults);
			List<sem_category> listc = categoryDAO.getCategories();
			model.addAttribute("offset", offset);
			model.addAttribute("total", categoryAndBookDAO.getTotal(cateId));
			List<sem_book> listBook = new ArrayList<sem_book>();
			for (sem_category_book sem_category_book : list) {
				listBook.add(sem_category_book.getBook());
			}
			model.addAttribute("listc", listc);
			model.addAttribute("list", listBook);
			return "product";
		}
		
		@RequestMapping("/detailBookProduct")
			public String detailBookProduct(@RequestParam("id") Integer id, Model model) {
			sem_book bookById = bookDao.getBookById(id);
			model.addAttribute("b", bookById);

			return "detailBook";
		}

	
}
