package com.jm.blog.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
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
}
