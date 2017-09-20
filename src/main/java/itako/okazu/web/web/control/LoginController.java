package itako.okazu.web.web.control;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import itako.okazu.web.entity.Quiz;
import itako.okazu.web.service.QuizService;

@Controller
public class LoginController {

	@Autowired
	QuizService quizService;

	@GetMapping(path = "loginForm")
	String loginForm(Model model) {
		int max = quizService.findMax();
		Random r = new Random();
		int random = r.nextInt(max);

		Optional<Quiz> quiz = quizService.findById(random);
		model.addAttribute("quizNo", random);
		model.addAttribute("quiz", quiz.get());
		return "loginForm";
	}

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
