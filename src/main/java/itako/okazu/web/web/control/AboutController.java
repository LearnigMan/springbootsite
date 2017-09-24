package itako.okazu.web.web.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AboutController {

	@GetMapping(path = "/about")
	String aboutForm(Model model) {
		return "about/index";
	}
}
