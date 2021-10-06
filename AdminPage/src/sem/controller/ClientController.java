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

import sem.dao.CategoryDAO;
import sem.dao.HomeDAO;
import sem.entities.sem_book;
import sem.entities.sem_category;

@Controller
public class ClientController {
	// Home
		@RequestMapping(value = "/homeClient")
		public String HomeClient() {
			return "homeClient";
		}
		@Autowired
		private HomeDAO homeDAO;
		@Autowired
		private CategoryDAO categoryDAO;

		
		@InitBinder
		public void initBinder(WebDataBinder data) {
			SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
			s.setLenient(false);
			data.registerCustomEditor(Date.class, new CustomDateEditor(s, true));
		}
		
		/** Nhớ Declarce bean của nó ở file spring-config.xml **/
		
		@RequestMapping(value = "/listBookHome")
		public String listBookHome(Model model) {
			List<sem_book> list = homeDAO.getBookHome();
			model.addAttribute("list", list);
			
			return "homeClient";
		}
		
		@RequestMapping("/sidebarClient")
		public String sidebarClient(Model model) {
			List<sem_category> listc = categoryDAO.getCategories();
			model.addAttribute("listc", listc);
			
			return "sidebarClient";
		}
		
		@RequestMapping("/detailBookHome")
		public String detailBookHome(@RequestParam("id") Integer id, Model model) {
			sem_book bookById = homeDAO.getBookByIdHome(id);
			model.addAttribute("b", bookById);

			return "detailBook";
		}

	
}
