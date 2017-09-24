package itako.okazu.web.web.control;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PhotoController {

	@GetMapping(path = "/photo")
	String photoForm(Model model) {
		int maxPhoto = 13;
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < maxPhoto; i++) {
			list.add(i);
		}
		Collections.shuffle(list);
		model.addAttribute("photolists", list);
		return "photo/list";
	}
}
