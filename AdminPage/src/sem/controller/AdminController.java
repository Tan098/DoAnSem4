package sem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Administrator
 */
@Controller
@RequestMapping(value = "/admin/")
public class AdminController {
	@RequestMapping(value = "home")
    public String HomePage(){
        return "home";
    }
}
