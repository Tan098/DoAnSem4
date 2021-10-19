package sem.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import sem.dao.BookDAO;
import sem.dao.impl.BookDAOimpl;
import sem.entities.sem_book;
import sem.entities.sem_cart_book;

@WebServlet(urlPatterns = "/add-to-cart") // ?bookid=?
public class AddToCartController extends HttpServlet {

	@Autowired
	private BookDAO book;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String bookid = req.getParameter("bookid");
		sem_book b = book.getBookById(Integer.parseInt(bookid));

		HttpSession session = req.getSession();
		Object obj = session.getAttribute("cart");// luu tam vao session
		if (obj == null) {// tao moi
			// Tao mot hang
			sem_cart_book cartbook = new sem_cart_book();
			cartbook.setBook(b);
			cartbook.setQuantity(1);
			cartbook.setPrice(b.getPrice());
			// gio hang co nhieu mat hang
			Map<String, sem_cart_book> map = new HashMap<>();
			map.put(bookid, cartbook);// them mat hang vao ds

			session.setAttribute("cart", map);// luu tam vao session
		} else {
			Map<String, sem_cart_book> map = (Map<String, sem_cart_book>) obj;

			sem_cart_book cartbook = map.get(bookid);

			if (cartbook == null) {
				cartbook = new sem_cart_book();
				cartbook.setBook(b);
				cartbook.setQuantity(1);
				cartbook.setPrice(b.getPrice());

				map.put(bookid, cartbook);
			} else {

				cartbook.setQuantity(cartbook.getQuantity() + 1);
			}

			session.setAttribute("cart", map);// luu tam vao session
		}

		resp.sendRedirect(req.getContextPath() + "/cart");
	}
}
