package sem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import sem.dao.CartDAO;
import sem.entities.sem_cart;

@Controller
public class CartController {
	@Autowired
	private CartDAO cartDao;

	@RequestMapping(value = "/listCarts")
	public String listCarts(Integer offset, Integer maxResult,Model model) {
		List<sem_cart> list = cartDao.getCarts(offset == null ?0:offset,maxResult==null?15:maxResult);
		model.addAttribute("list", list);
		
		
		return "listCarts";
	}

	@RequestMapping("/initInsertCart")
	public String initInsertCart(Model model) {
		sem_cart c = new sem_cart();
		model.addAttribute("c", c);

		return "insertCart";
	}

	@RequestMapping("/insertCart")
	public String insertBook(@ModelAttribute("c") sem_cart c, Model model) {
		boolean bl = cartDao.insertCart(c);
		if (bl) {
			return "redirect:/listCarts";
		} else {
			model.addAttribute("err", "Insert Failed !");
			model.addAttribute("c", c);

			return "insertCart";
		}
	}

	@RequestMapping("/initUpdateCart")
	public String initUpdate(@RequestParam("id") Integer id, Model model) {
		sem_cart cartById = cartDao.getCartById(id);
		model.addAttribute("c", cartById);

		return "updateCart";
	}

	@RequestMapping("/updateCart")
	public String updateCart(@ModelAttribute("c") sem_cart c, Model model) {
		boolean bl = cartDao.updateCart(c);
		if (bl) {
			return "redirect:/listCarts";

		} else {
			model.addAttribute("err", "Update Failed !");
			model.addAttribute("c", c);

			return "updateCart";
		}
	}

	@RequestMapping("/detailCart")
	public String detailCart(@RequestParam("id") Integer id, Model model) {
		sem_cart cartById = cartDao.getCartById(id);
		model.addAttribute("c", cartById);

		return "detailCart";
	}

	@RequestMapping("/deleteCart")
	public String deleteCart(@RequestParam("id") Integer id, Model model,Integer offset, Integer maxResult) {
		boolean bl = cartDao.deleteCart(id);
		if (bl) {
			model.addAttribute("success", "Delete success !");
		}else {
			model.addAttribute("err", "Delete failed !");
		}
		List<sem_cart> list = cartDao.getCarts(offset == null ?0:offset,maxResult==null?15:maxResult);
		model.addAttribute("list", list);
		return "listCarts";
	}
}
