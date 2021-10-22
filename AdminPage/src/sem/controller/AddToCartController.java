package sem.controller;

import java.awt.print.Book;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sun.xml.bind.v2.model.core.ID;

import sem.dao.BookDAO;
import sem.dao.impl.BookDAOimpl;
import sem.entities.sem_book;
import sem.entities.sem_cart;
import sem.entities.sem_cart_book;

@Controller
public class AddToCartController {

	@Autowired
	private BookDAO bookDao;

	@RequestMapping(value = "/add-to-cart")
	public String addToCart(HttpSession session, HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException 
	{
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
		}
		// Trả về trang cart-list.jsp
		return "cart-list";
	}
}