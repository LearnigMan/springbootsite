package itako.okazu.web.web.control;

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

}
