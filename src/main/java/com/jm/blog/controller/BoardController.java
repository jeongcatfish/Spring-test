package com.jm.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.jm.blog.model.pUser;
import com.jm.blog.repository.UserRepository;
import com.jm.blog.service.BoardService;


@Controller
public class BoardController {

	@Autowired
	private BoardService boardService;
	
	@GetMapping({"","/"})
	public String index(Model model, @PageableDefault(size =4, sort="id",direction = Direction.DESC) Pageable pageable) {
		//index.jsp로 "boards"가 날라가서 쓸 수 있음 ex) <c:forEach var = "board" items=${boards}></c:forEach>
		model.addAttribute("boards", boardService.ListOfArticles(pageable));
		// WEB-INF/views/index.jsp
		return "index"; // viewResolver 작동 
	}
	
	/*
	 * @GetMapping("/index2") public String index2(Model model) {
	 * model.addAttribute("boards", boardService.ListOfArticles()); return "index2";
	 * }
	 */
	
	@GetMapping("/board/{id}")
	public String findById(@PathVariable int id, Model model) {
		model.addAttribute("board",boardService.detail(id));
		return "board/detail";
	}
	
	@GetMapping("/board/saveForm")
	public String saveForm() {
		return "board/saveForm";
	}
	@GetMapping("/summber")
	public String summberNote() {
		return "summber";
	}
	
}
