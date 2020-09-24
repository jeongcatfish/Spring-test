package com.jm.blog.controller.api;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jm.blog.dto.ResponseDto;
import com.jm.blog.model.RoleType;
import com.jm.blog.model.pUser;
import com.jm.blog.service.UserService;

@RestController
public class UserApiController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/api/user")
	public ResponseDto<Integer> save(@RequestBody pUser user) {
		System.out.println("user save call");
		//실제로 DB에 insert하고 아래에 return.
		user.setRole(RoleType.USER);
		int reulst = userService.회원가입(user);
		return new ResponseDto<Integer>(HttpStatus.OK,reulst);
	}
	
	//TEST
	@GetMapping("/api/getUsers")
	public ResponseDto<List> getUsers() {
		List<pUser> list = userService.getUsers();
		return new ResponseDto<List>(HttpStatus.OK,list);
	}
	
	@PostMapping("/api/user/login")
	public ResponseDto<Integer> login(@RequestBody pUser user, HttpSession session){
		System.out.println("log in in in");
		pUser principal = userService.login(user);
		if(principal != null) {
			session.setAttribute("principal", principal);
			System.out.println("session connected session connected ");
		}
		else {
			System.out.println("session connect fail");
		}
			
		return new ResponseDto<Integer>(HttpStatus.OK,1);
	}
	
}
