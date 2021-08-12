package sem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomController {
	@RequestMapping(value = { "/home", "/" })
	public String HomePage() {
		return "home";
	}
}
