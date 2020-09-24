package com.jm.blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jm.blog.dto.ResponseDto;
import com.jm.blog.model.Board;
import com.jm.blog.model.pUser;
import com.jm.blog.repository.UserRepository;
import com.jm.blog.service.BoardService;
import com.jm.blog.service.UserService;
import com.jm.blog.test.Member;

@RestController
public class RestTestController {

	@Autowired
	private UserService userService;

	@Autowired
	private BoardService boardService;

	@GetMapping("/getUsers")
	public List<pUser> getAllusers() {
		return userService.getUsers();
	}

	@GetMapping("/geUser/{id}")
	public pUser getUser(@PathVariable int id) {
		return userService.getUser(id);
	}

	@GetMapping("/delete/user/{id}")
	public String deleteUserById(@PathVariable int id) {
		userService.deleteById(id);
		return "delete okay";
	}

	// MYSQL에 저장된 데이터 값 변경.
	@PostMapping("/reviseUser/{id}")
	public String reviseUser(@PathVariable int id, @RequestBody pUser user) {
		userService.reviseUser(id, user);
		return "ok";
	}

	// 유저 DB에 추가
	@PostMapping("addUser")
	public String addUser(@RequestBody pUser user) {
		userService.AddUser(user);
		return "add user";
	}

	@PostMapping("/addUserByUri")
	public String addUserByUri(@RequestBody Board board) {
		boardService.write(board);
		return "save okay";
	}
	
	@GetMapping("/api/addRows")
	public String save() {
		Board board= new Board();
		board.setTitle("ADD");
		board.setContent("content adeed");
		boardService.write(board);
		return "api addRows works";
	}
}