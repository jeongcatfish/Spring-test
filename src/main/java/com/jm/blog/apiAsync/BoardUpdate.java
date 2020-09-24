package com.jm.blog.apiAsync;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.jm.blog.model.Board;

@Controller
public class BoardUpdate {

	@PostMapping("/addUserUri")
	public String addUserUri(@RequestBody Board board,Model model) {
		model.addAttribute("val1",board.getTitle());
		model.addAttribute("val2",board.getContent());
		return "addUser";
	}
}
