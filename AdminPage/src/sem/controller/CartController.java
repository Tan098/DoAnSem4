package sem.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import sem.dao.BookDAO;
import sem.dao.CartDAO;
import sem.dao.CategoryDAO;
import sem.entities.sem_book;
import sem.entities.sem_cart;
import sem.entities.sem_cart_book;
import sem.entities.sem_category;

@Controller
public class CartController {
	@Autowired
	private BookDAO bookDao;
	@Autowired
	private CategoryDAO categoryDAO;

	@RequestMapping(value = "/addtocart")
	public String addToCart(HttpSession session, HttpServletRequest request, HttpServletResponse response, Model model) {
		List<sem_category> listc = categoryDAO.getCategories();
		model.addAttribute("listc", listc);
		// Khai báo id
		int id;
		// Lấy id của quyến sách
		String bookId = request.getParameter("bookId");
		// Ép kiểu cho id
		id = Integer.parseInt(bookId);
		// Lấy giả trị của quyển sách theo id
		sem_book book = bookDao.getBookById(id);
		// Lưu tạm vào session có tên là cart
		Object object = session.getAttribute("cart");
		// Kiểm tra nếu đối tượng ở trong session này chưa tồn tại
		if (object == null) { // Tạo mới giỏ hàng
			// Tạo mặt hàng đưa vào giỏ hàng
			sem_cart_book cart_book = new sem_cart_book();
			// Lấy từng giá trị để đưa vào mặt hàng
			cart_book.setBook(book);
			cart_book.setPrice(book.getPrice());
			cart_book.setQuantity(1);
			// Nếu giỏ hàng có nhiều mặt hàng
			Map<Integer, sem_cart_book> map = new HashMap<>();
			// Đưa mặt hàng đó vào danh sách
			map.put(id, cart_book);
			// Lưu danh sách này vào session
			session.setAttribute("cart", map);
			session.setAttribute("customerCartTotalPrice", totalPrice(map));
		} else {
			// Lấy danh sách đã đưa vào session trước đó
			Map<Integer, sem_cart_book> map = (HashMap<Integer, sem_cart_book>) object;
			// Lấy mặt hàng từ trong danh sách
			sem_cart_book cart_book = map.get(id);
			// Nếu mặt hàng đó chưa có trong giỏ
			if (cart_book == null) {
				// Khởi tạo đối tượng để thêm vào danh sách
				cart_book = new sem_cart_book();
				// Lấy từng giá trị để đưa vào mặt hàng, đấy em chạy đi.
				cart_book.setBook(book);
				cart_book.setPrice(book.getPrice());
				cart_book.setQuantity(1);
				// Đưa mặt hàng đó vào danh sách
				map.put(id, cart_book);
			} else {
				// Tăng thêm một đơn vị cho mặt hàng
				cart_book.setQuantity(cart_book.getQuantity() + 1);
			}
			// Lưu danh sách này vào session
			session.setAttribute("cart", map);
			session.setAttribute("customerCartTotalPrice", totalPrice(map));
		}
		// Trả về trang cart-list.jsp
		return "cart-list";
	}

	@RequestMapping(value = "/cart")
	public String cartList(Model model) {
		List<sem_category> listc = categoryDAO.getCategories();
		model.addAttribute("listc", listc);
		return "cart-list";
	}

	@RequestMapping(value = "/deletefromcart")
	public String deleteFormCart(HttpSession session, HttpServletRequest request, HttpServletResponse response) {
		// Khởi tạo id kiểu int
		int id;
		// Khởi tạo key để lấy gió trị của sản phẩm trong bản ghi
		String key = request.getParameter("key");
		// Ép kiểu cho id
		id = Integer.parseInt(key);
		// Lưu tạm vào session có tên là cart
		Object object = session.getAttribute("cart");
		// Nếu như session cart tồn tại
		if (object != null) {
			// Lấy danh sách đã đưa vào session trước đó
			Map<Integer, sem_cart_book> map = (HashMap<Integer, sem_cart_book>) object;
			// Lấy mặt hàng từ trong danh sách
			sem_cart_book cart_book = map.get(id);
			// Lấy sô lượng của sản phẩm trong danh sách
			int quantity = cart_book.getQuantity();
			// Nếu sản phẩm có số lượng lớn hơn 1
			if (quantity > 1) {
				// Giảm số lượng sản phẩm đi 1 đơn vị
				cart_book.setQuantity(cart_book.getQuantity() - 1);
			} else {
				// Xóa sản phẩm trong danh sách tại vị trí có value bằng id
				map.remove(id);
			}
			// Cập nhật lại vào session
			session.setAttribute("cart", map);
		}
		// Chuyển về giỏ hàng
		return "cart-list";
	}

	public double totalPrice(Map<Integer, sem_cart_book> map) {
		int count = 0;
		for (Map.Entry<Integer, sem_cart_book> list : map.entrySet()) {
			// Tính tổng giá đơn hàng
			count += list.getValue().getBook().getPrice() * list.getValue().getQuantity();
		}
		return count;
	}
}
