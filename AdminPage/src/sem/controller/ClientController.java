package sem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ClientController {
	// Home
		@RequestMapping(value = "/homeClient")
		public String HomeClient() {
			return "homeClient";
		}
}
