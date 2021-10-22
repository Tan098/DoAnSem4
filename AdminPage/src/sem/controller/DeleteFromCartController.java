package sem.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import sem.entities.sem_book;
import sem.entities.sem_cart_book;

@Controller
public class DeleteFromCartController {

	@RequestMapping(value = "/delete-from-cart")
	protected void doGet(HttpSession session, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String key = request.getParameter("key");

		// gio hang co nhieu mat hang
		Object obj = session.getAttribute("cart");// luu tam vao session

		if (obj != null) {
			Map<String, sem_cart_book> map = (Map<String, sem_cart_book>) obj;
			map.remove(key);
			// update lai vao session
			session.setAttribute("cart", map);
		}
		// chuyen ve trang gio hang
		response.sendRedirect(request.getContextPath() + "/cart");
	}
}
