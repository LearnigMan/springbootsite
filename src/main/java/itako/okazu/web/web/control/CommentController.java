package itako.okazu.web.web.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import itako.okazu.web.entity.Comment;
import itako.okazu.web.service.CommentService;
import itako.okazu.web.web.form.CommnetForm;

@Controller
@RequestMapping("comment") // APIのパス指定
public class CommentController {

	@Autowired
	CommentService commentService;

	@ModelAttribute("commnetForm")
	CommnetForm setUpform() {
		return new CommnetForm();
	}

	@GetMapping(path = "/list")
	String photoForm(Model model) {
		List<Comment> comment = commentService.findAll();
		model.addAttribute("comments", comment);
		return "comment/list";
	}

	@PostMapping(path = "/create")
	String create(@ModelAttribute("commnetForm") CommnetForm form, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "";
		}
		Comment commnet = new Comment();
		// TODO Idをセットしなくても作成できるようにする。[DOMA2018] エンティティ[Lead]のIDプロパティの生成に失敗しました。
		// BeanUtils.copyProperties(form, lead);
		commnet.id = 0;
		commnet.nickName = form.getNickName();
		commnet.comment = form.getComment();

		commentService.create(commnet);

		return "redirect:/comment/list";
	}

}
