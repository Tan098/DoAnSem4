package sem.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import sem.dao.AuthorAndBookDAO;
import sem.dao.AuthorDAO;
import sem.dao.CategoryAndBookDAO;
import sem.dao.CategoryDAO;
import sem.dao.CustomerDAO;
import sem.dao.ImageDAO;
import sem.dao.OrderDAO;
import sem.dao.PublisherDAO;
import sem.entities.sem_author;
import sem.entities.sem_author_book;
import sem.entities.sem_author_book_pk;
import sem.entities.sem_book;
import sem.entities.sem_category;
import sem.entities.sem_category_book;
import sem.entities.sem_category_book_pk;
import sem.entities.sem_customer;
import sem.entities.sem_image;
import sem.entities.sem_publisher;

@Controller
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
	@Autowired
	private AuthorDAO authorDao;
	@Autowired
	private CategoryAndBookDAO categoryAndBookDAO;
	@Autowired
	private AuthorAndBookDAO authorAndBookDAO;

	private Integer pageIndex, pageSize;

	@InitBinder
	public void initBinder(WebDataBinder data) {
		SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
		s.setLenient(false);
		data.registerCustomEditor(Date.class, new CustomDateEditor(s, true));
	}

	// Home
	@RequestMapping(value = "/home")
	public String HomePage(HttpSession session) {
		Object object = session.getAttribute("admin");
		if (object != null) {
			return "home";
		} else {
			return "loginAdmin";
		}

	}
	// End

	// Catergory
	@RequestMapping(value = "/listCategories")
	public String listCategories(Model model, HttpSession session) {
		Object object = session.getAttribute("admin");
		if (object != null) {
			List<sem_category> list = categoryDAO.getCategories();
			model.addAttribute("list", list);
			return "listCategories";
		} else {
			return "loginAdmin";
		}

	}

	@RequestMapping(value = "/initInsertCategory")
	public String initInsertCategory(Model model, HttpSession session) {
		Object object = session.getAttribute("admin");
		if (object != null) {
			sem_category c = new sem_category();
			model.addAttribute("c", c);
			return "insertCategory";
		} else {
			return "loginAdmin";
		}

	}

	@RequestMapping(value = "/insertCategory")
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

	@RequestMapping(value = "/initUpdateCategory")
	public String initUpdateCategory(@RequestParam("id") Integer id, Model model, HttpSession session) {
		Object object = session.getAttribute("admin");
		if (object != null) {
			sem_category categoryById = categoryDAO.getCategoryById(id);
			model.addAttribute("c", categoryById);
			return "updateCategory";
		} else {
			return "loginAdmin";
		}
	}

	@RequestMapping(value = "/updateCategory")
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

	@RequestMapping(value = "/detailCategory")
	public String detailCategory(@RequestParam("id") Integer id, Model model, HttpSession session) {
		Object object = session.getAttribute("admin");
		if (object != null) {
			sem_category categoryById = categoryDAO.getCategoryById(id);
			model.addAttribute("c", categoryById);
			return "detailCategory";
		} else {
			return "loginAdmin";
		}
	}
	// End

	// Customer
	@RequestMapping(value = "/listCustomers")
	public String listCustomers(Model model, HttpSession session) {
		Object object = session.getAttribute("admin");
		if (object != null) {
			List<sem_customer> list = customerDAO.getCustomers();
			model.addAttribute("list", list);
			return "listCustomers";
		} else {
			return "loginAdmin";
		}
	}

	@RequestMapping(value = "/initUpdateCustomer")
	public String initUpdateCustomer(@RequestParam("id") Integer id, Model model, HttpSession session) {
		Object object = session.getAttribute("admin");
		if (object != null) {
			sem_customer customerById = customerDAO.getCustomerById(id);
			model.addAttribute("c", customerById);
			return "updateCustomer";
		} else {
			return "loginAdmin";
		}
	}

	@RequestMapping(value = "/updateCustomer")
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

	@RequestMapping(value = "/detailCustomer")
	public String detailCustomer(@RequestParam("id") Integer id, Model model, HttpSession session) {
		Object object = session.getAttribute("admin");
		if (object != null) {
			sem_customer customerById = customerDAO.getCustomerById(id);
			model.addAttribute("c", customerById);
			return "detailCustomer";
		} else {
			return "loginAdmin";
		}
	}
	// End

	// Image
	@RequestMapping(value = "/listImages")
	public String listImages(Model model, HttpSession session) {
		Object object = session.getAttribute("admin");
		if (object != null) {
			List<sem_image> list = imageDAO.getImages();
			model.addAttribute("list", list);
			return "listImages";
		} else {
			return "loginAdmin";
		}
	}

	@RequestMapping(value = "/initInsertImage")
	public String initInsertImage(@RequestParam("book") Integer book, Model model, HttpSession session) {
		Object object = session.getAttribute("admin");
		if (object != null) {
			sem_image i = new sem_image();
			sem_book b = new sem_book(book);
			i.setBook(b);
			model.addAttribute("i", i);
			return "insertImage";
		} else {
			return "loginAdmin";
		}
	}

	@RequestMapping(value = "/insertImage")
	public String insertImage(@ModelAttribute("i") sem_image i, @RequestParam("pathImage") MultipartFile multipartFile,
			HttpServletRequest request, Model model) throws IOException {
		String path = request.getServletContext().getRealPath("resources/images");
		File f = new File(path);
		File nameFile = new File(f.getAbsoluteFile() + "/" + multipartFile.getOriginalFilename());
		byte[] dataIamge = multipartFile.getBytes();
		if (!nameFile.exists()) {
			Files.write(nameFile.toPath(), dataIamge, StandardOpenOption.CREATE);
		}
		i.setPath(multipartFile.getOriginalFilename());
		boolean bl = imageDAO.insertImage(i);
		if (bl) {
			return "redirect:/listBooks";
		} else {
			model.addAttribute("err", "Insert Failed !");
			model.addAttribute("i", i);
			return "insertImage";
		}
	}

	@RequestMapping(value = "/deleteImage")
	public String deleteImage(@RequestParam("id") Integer id, Integer book, Model model, HttpSession session) {
		Object object = session.getAttribute("admin");
		if (object != null) {
			boolean bl = imageDAO.deleteImage(id);
			if (bl) {
				model.addAttribute("success", "Delete success !");
			} else {
				model.addAttribute("err", "Delete failed !");
			}
			List<sem_image> list = imageDAO.getImages();
			model.addAttribute("list", list);
			return "deleteImage";
		} else {
			return "loginAdmin";
		}
	}
	// End

	// Author
	@RequestMapping(value = "/listAuthors")
	public String listAuthors(Model model, Integer offset, Integer maxResult, HttpSession session) {
		Object object = session.getAttribute("admin");
		if (object != null) {
			List<sem_author> list = authorDao.getAuthors();
			model.addAttribute("list", list);
			return "listAuthors";
		} else {
			return "loginAdmin";
		}
	}

	@RequestMapping(value = "/initInsertAuthor")
	public String initInsertAuthor(Model model, HttpSession session) {
		Object object = session.getAttribute("admin");
		if (object != null) {
			sem_author a = new sem_author();
			model.addAttribute("a", a);
			return "insertAccount";
		} else {
			return "loginAdmin";
		}
	}

	@RequestMapping(value = "/insertAuthor")
	public String insertAuthor(@ModelAttribute("a") sem_author a, Model model) {
		boolean bl = authorDao.insertAuthor(a);
		if (bl) {
			return "redirect:/listAuthors";
		} else {
			model.addAttribute("err", "Insert Failed !");
			model.addAttribute("a", a);

			return "insertAuthor";
		}
	}

	@RequestMapping(value = "/initUpdateAuthor")
	public String initUpdate(@RequestParam("id") Integer id, Model model, HttpSession session) {
		Object object = session.getAttribute("admin");
		if (object != null) {
			sem_author authorById = authorDao.getAuthorById(id);
			model.addAttribute("a", authorById);
			return "updateAuthor";
		} else {
			return "loginAdmin";
		}
	}

	@RequestMapping(value = "/updateAuthor")
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

	@RequestMapping(value = "/detailAuthor")
	public String detailAuthor(@RequestParam("id") Integer id, Model model, HttpSession session) {
		Object object = session.getAttribute("admin");
		if (object != null) {
			sem_author authorById = authorDao.getAuthorById(id);
			model.addAttribute("a", authorById);
			return "detailAuthor";
		} else {
			return "loginAdmin";
		}
	}

	@RequestMapping(value = "/deleteAuthor")
	public String deleteAuthor(@RequestParam("id") Integer id, Model model, HttpSession session) {
		Object object = session.getAttribute("admin");
		if (object != null) {
			boolean bl = authorDao.deleteAuthor(id);
			if (bl) {
				model.addAttribute("success", "Delete success !");
			} else {
				model.addAttribute("err", "Delete failed !");
			}
			List<sem_author> list = authorDao.getAuthors();
			model.addAttribute("list", list);
			return "listAuthors";
		} else {
			return "loginAdmin";
		}
	}
	// End

	// Publisher
	@RequestMapping(value = "/listPublishers")
	public String listPublishers(Model model, HttpSession session) {
		Object object = session.getAttribute("admin");
		if (object != null) {
			List<sem_publisher> list = publisherDAO.getPublishers();
			model.addAttribute("list", list);
			return "listPublishers";
		} else {
			return "loginAdmin";
		}
	}

	@RequestMapping(value = "/initInsertPublisher")
	public String initInsertPublisher(Model model, HttpSession session) {
		Object object = session.getAttribute("admin");
		if (object != null) {
			sem_publisher p = new sem_publisher();
			model.addAttribute("p", p);
			return "insertPublisher";
		} else {
			return "loginAdmin";
		}
	}

	@RequestMapping(value = "/insertPublisher")
	public String insertPublisher(@ModelAttribute("p") sem_publisher p, Model model) {
		boolean bl = publisherDAO.insertPublisher(p);
		if (bl) {
			return "redirect:/listPublishers";
		} else {
			model.addAttribute("err", "Insert Failed !");
			model.addAttribute("p", p);

			return "insertPublisher";
		}
	}

	@RequestMapping(value = "/initUpdatePublisher")
	public String initUpdatePublisher(@RequestParam("id") Integer id, Model model, HttpSession session) {
		Object object = session.getAttribute("admin");
		if (object != null) {
			sem_publisher publisherById = publisherDAO.getPublisherById(id);
			model.addAttribute("p", publisherById);
			return "updatePublisher";
		} else {
			return "loginAdmin";
		}
	}

	@RequestMapping("/updatePublisher")
	public String updatePublisher(@ModelAttribute("p") sem_publisher p, Model model) {
		boolean bl = publisherDAO.updatePublisher(p);
		if (bl) {
			return "redirect:/listPublishers";

		} else {
			model.addAttribute("err", "Update Failed !");
			model.addAttribute("p", p);

			return "updatePublisher";
		}
	}

	@RequestMapping(value = "/detailPublisher")
	public String detailPublisher(@RequestParam("id") Integer id, Model model, HttpSession session) {
		Object object = session.getAttribute("admin");
		if (object != null) {
			sem_publisher publisherById = publisherDAO.getPublisherById(id);
			model.addAttribute("p", publisherById);
			return "detailPublisher";
		} else {
			return "loginAdmin";
		}
	}
	// End

	// CategoryBook
	@RequestMapping(value = "/listCategoryBooks")
	public String listCategoryBooks(Model model, HttpSession session) {
		Object object = session.getAttribute("admin");
		if (object != null) {
			List<sem_category_book> list = categoryAndBookDAO.getList();
			model.addAttribute("list", list);
			return "listCategoryBooks";
		} else {
			return "loginAdmin";
		}
	}

	@RequestMapping("/initInsertCategoryBook")
	public String initInsertCategoryBook(@RequestParam("book") Integer book, Model model, HttpSession session) {
		Object object = session.getAttribute("admin");
		if (object != null) {
			sem_category_book cb = new sem_category_book();
			sem_book b = new sem_book(book);
			cb.setBook(b);
			model.addAttribute("cb", cb);
			List<sem_category> cate = categoryDAO.getCategories();
			model.addAttribute("listc", cate);
			return "insertCategoryBook";
		} else {
			return "loginAdmin";
		}
	}

	@RequestMapping(value = "/insertCategoryBook")
	public String insertCategoryBook(@ModelAttribute("cb") sem_category_book cb, HttpServletRequest request,
			Model model, HttpSession session) throws IOException {
		sem_category_book_pk objPK = new sem_category_book_pk();
		objPK.setBook(cb.getBook().getId());
		objPK.setCategory(cb.getCategory().getId());
		cb.setCategory_book_pk(objPK);
		boolean bl = categoryAndBookDAO.insertCategoryBook(cb);
		if (bl) {
			return "redirect:/listBooks";
		} else {
			model.addAttribute("err", "Insert Failed !");
			model.addAttribute("cb", cb);

			List<sem_category> cate = categoryDAO.getCategories();
			model.addAttribute("listc", cate);
			return "insertCategoryBook";
		}
	}

	@RequestMapping(value = "/deleteCategoryBook")
	public String deleteCategoryBook(@RequestParam("alias") String alias, Model model, HttpSession session) {
		Object object = session.getAttribute("admin");
		if (object != null) {
			boolean bl = categoryAndBookDAO.deleteCategoryBook(alias);
			if (bl) {
				model.addAttribute("success", "Delete success !");
			} else {
				model.addAttribute("err", "Delete failed !");
			}
			List<sem_category_book> list = categoryAndBookDAO.getList();
			model.addAttribute("list", list);
			return "listCategoryBooks";
		} else {
			return "loginAdmin";
		}
	}
	// End

	// AuthorBook
	@RequestMapping(value = "/listAuthorBooks")
	public String listAuthorBooks(Model model, HttpSession session) {
		Object object = session.getAttribute("admin");
		if (object != null) {
			List<sem_author_book> list = authorAndBookDAO.getList();
			model.addAttribute("list", list);
			return "listAuthorBooks";
		} else {
			return "loginAdmin";
		}
	}

	@RequestMapping(value = "/initInsertAuthorBook")
	public String initInsertAuthorBook(@RequestParam("book") Integer book, Model model, HttpSession session) {
		Object object = session.getAttribute("admin");
		if (object != null) {
			sem_author_book ab = new sem_author_book();
			sem_book b = new sem_book(book);
			ab.setBook(b);
			model.addAttribute("ab", ab);
			List<sem_author> au = authorDao.getAuthors();
			model.addAttribute("lista", au);
			return "insertAuthorBook";
		} else {
			return "loginAdmin";
		}
	}

	@RequestMapping(value = "/insertAuthorBook")
	public String insertAuthorBook(@ModelAttribute("ab") sem_author_book ab, HttpServletRequest request, Model model)
			throws IOException {
		sem_author_book_pk objPK = new sem_author_book_pk();
		objPK.setBook(ab.getBook().getId());
		objPK.setAuthor(ab.getAuthor().getId());
		ab.setAuthor_book_pk(objPK);
		boolean bl = authorAndBookDAO.insertAuthorBook(ab);
		if (bl) {
			return "redirect:/listBooks";
		} else {
			model.addAttribute("err", "Insert Failed !");
			model.addAttribute("ab", ab);

			List<sem_author> au = authorDao.getAuthors();
			model.addAttribute("lista", au);
			return "insertAuthorBook";
		}
	}

	@RequestMapping(value = "/deleteAuthorBook")
	public String deleteAuthorBook(@RequestParam("alias") String alias, Model model, HttpSession session) {
		Object object = session.getAttribute("admin");
		if (object != null) {
			boolean bl = authorAndBookDAO.deleteAuthorBook(alias);
			if (bl) {
				model.addAttribute("success", "Delete success !");
			} else {
				model.addAttribute("err", "Delete failed !");
			}
			List<sem_author_book> list = authorAndBookDAO.getList();
			model.addAttribute("list", list);
			return "listAuthorBooks";
		} else {
			return "loginAdmin";
		}
	}
	// End
}
