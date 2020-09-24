package com.jm.blog.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jm.blog.dto.ResponseDto;
import com.jm.blog.model.Board;
import com.jm.blog.model.RoleType;
import com.jm.blog.model.pUser;
import com.jm.blog.service.BoardService;
import com.jm.blog.service.UserService;

@RestController
public class BoardApiController {

	@Autowired
	private BoardService boardService;
	
	
	@PostMapping("/api/board")
	public ResponseDto<Integer> save(@RequestBody Board board) {
		boardService.write(board);
		return new ResponseDto<Integer>(HttpStatus.OK,1);
	}
	

	@PutMapping("/put")
	public ResponseDto<Integer> update(@PathVariable int id, @RequestBody Board board){
		boardService.reviseList(id, board);
		return new ResponseDto<Integer>(HttpStatus.OK,1);
	}
}
