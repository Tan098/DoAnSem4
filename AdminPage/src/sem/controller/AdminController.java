package sem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import sem.dao.CategoryDAO;
import sem.dao.CustomerDAO;
import sem.dao.ImageDAO;
import sem.dao.OrderDAO;
import sem.dao.PublisherDAO;
import sem.entities.sem_account;
import sem.entities.sem_category;
import sem.entities.sem_customer;
import sem.entities.sem_image;

@Controller
@RequestMapping(value = "Admin")
public class AdminController {
	@Autowired
	private CategoryDAO categoryDAO;
	@Autowired
	private CustomerDAO customerDAO;
	@Autowired
	private ImageDAO imageDAO;
	@Autowired
	private OrderDAO orderDAO;
	@Autowired
	private PublisherDAO publisherDAO;

	private Integer pageIndex, pageSize;
	

	// Catergory
	@RequestMapping(value ="/listCategories" )
	public String listCategories(Model model) {
		List<sem_category> list = categoryDAO.getCategories(pageSize == null ? 0 : pageSize,
				pageIndex == null ? 15 : pageIndex);
		model.addAttribute("list", list);

		return "listCategories";
	}

	@RequestMapping("/initInsertCategory")
	public String initInsertCategory(Model model) {
		sem_category c = new sem_category();
		model.addAttribute("c", c);

		return "insertCategory";
	}

	@RequestMapping("/insertCategory")
	public String insertCategory(@ModelAttribute("c") sem_category c, Model model) {
		boolean bl = categoryDAO.insertCategory(c);
		if (bl) {
			return "redirect:/listCategories";
		} else {
			model.addAttribute("err", "Insert Failed !");
			model.addAttribute("c", c);

			return "insertCategory";
		}
	}

	@RequestMapping("/initUpdateCategory")
	public String initUpdateCategory(@RequestParam("id") Integer id, Model model) {
		sem_category categoryById = categoryDAO.getCategoryById(id);
		model.addAttribute("c", categoryById);

		return "updateCategory";
	}

	@RequestMapping("/updateCategory")
	public String updateCategory(@ModelAttribute("c") sem_category c, Model model) {
		boolean bl = categoryDAO.updateCategory(c);
		if (bl) {
			return "redirect:/listCategories";

		} else {
			model.addAttribute("err", "Update Failed !");
			model.addAttribute("c", c);

			return "updateCategory";
		}
	}

	@RequestMapping("/detailCategory")
	public String detailCategory(@RequestParam("id") Integer id, Model model) {
		sem_category categoryById = categoryDAO.getCategoryById(id);
		model.addAttribute("c", categoryById);

		return "detailCategory";
	}
	// End

	// Customer
	@RequestMapping(value = "/listCustomers")
	public String listCustomers(Model model) {
		List<sem_customer> list = customerDAO.getCustomers(pageSize == null ? 0 : pageSize,
				pageIndex == null ? 15 : pageIndex);
		model.addAttribute("list", list);

		return "listCustomers";
	}

	@RequestMapping("/initInsertCustomer")
	public String initInsertCustomer(Model model) {
		sem_customer c = new sem_customer();
		model.addAttribute("c", c);

		return "insertCustomer";
	}

	@RequestMapping("/insertCustomer")
	public String insertCustomer(@ModelAttribute("c") sem_customer c, Model model) {
		boolean bl = customerDAO.insertCustomer(c);
		if (bl) {
			return "redirect:/listCustomers";
		} else {
			model.addAttribute("err", "Insert Failed !");
			model.addAttribute("c", c);

			return "insertCustomer";
		}
	}

	@RequestMapping("/initUpdateCustomer")
	public String initUpdateCustomer(@RequestParam("id") Integer id, Model model) {
		sem_customer customerById = customerDAO.getCustomerById(id);
		model.addAttribute("c", customerById);

		return "updateCustomer";
	}

	@RequestMapping("/updateCustomer")
	public String updateCustomer(@ModelAttribute("c") sem_customer c, Model model) {
		boolean bl = customerDAO.updateCustomer(c);
		if (bl) {
			return "redirect:/listCustomers";

		} else {
			model.addAttribute("err", "Update Failed !");
			model.addAttribute("c", c);

			return "updateCustomer";
		}
	}

	@RequestMapping("/detailCustomer")
	public String detailCustomer(@RequestParam("id") Integer id, Model model) {
		sem_customer customerById = customerDAO.getCustomerById(id);
		model.addAttribute("c", customerById);

		return "detailCustomer";
	}

	@RequestMapping("/deleteCustomer")
	public String deleteCustomer(@RequestParam("id") Integer id, Model model) {
		boolean bl = customerDAO.deleteCustomer(id);
		if (bl) {
			model.addAttribute("success", "Delete success !");
		} else {
			model.addAttribute("err", "Delete failed !");
		}
		List<sem_customer> list = customerDAO.getCustomers(pageSize == null ? 0 : pageSize,
				pageIndex == null ? 15 : pageIndex);
		model.addAttribute("list", list);
		return "listCustomers";
	}
	// End

	// Image
	@RequestMapping(value = "/listImages")
	public String listImages(Model model) {
		List<sem_image> list = imageDAO.getImages(pageSize == null ? 0 : pageSize,
				pageIndex == null ? 15 : pageIndex);
		model.addAttribute("list", list);

		return "listImages";
	}

	@RequestMapping("/initInsertImage")
	public String initInsertImage(Model model) {
		sem_image i = new sem_image();
		model.addAttribute("i", i);

		return "insertImage";
	}

	@RequestMapping("/insertImage")
	public String insertImage(@ModelAttribute("i") sem_image i, Model model) {
		boolean bl = imageDAO.insertImage(i);
		if (bl) {
			return "redirect:/listImages";
		} else {
			model.addAttribute("err", "Insert Failed !");
			model.addAttribute("i", i);

			return "insertImage";
		}
	}

	@RequestMapping("/initUpdateImage")
	public String initUpdateImage(@RequestParam("id") Integer id, Model model) {
		sem_image iamgeById = imageDAO.getImageById(id);
		model.addAttribute("i", iamgeById);

		return "updateImage";
	}

	@RequestMapping("/updateImage")
	public String updateImage(@ModelAttribute("i") sem_image i, Model model) {
		boolean bl = imageDAO.updateImage(i);
		if (bl) {
			return "redirect:/listImages";

		} else {
			model.addAttribute("err", "Update Failed !");
			model.addAttribute("i", i);

			return "updateImage";
		}
	}

	@RequestMapping("/deleteImage")
	public String deleteImage(@RequestParam("id") Integer id, Model model) {
		boolean bl = imageDAO.deleteImage(id);
		if (bl) {
			model.addAttribute("success", "Delete success !");
		} else {
			model.addAttribute("err", "Delete failed !");
		}
		List<sem_image> list = imageDAO.getImages(pageSize == null ? 0 : pageSize,
				pageIndex == null ? 15 : pageIndex);
		model.addAttribute("list", list);
		return "deleteImage";
	}
	// End
}
