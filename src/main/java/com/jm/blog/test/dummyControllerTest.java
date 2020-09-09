package com.jm.blog.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jm.blog.model.RoleType;
import com.jm.blog.model.pUser;
import com.jm.blog.repository.UserRepository;

@RestController
public class dummyControllerTest {

	@Autowired //의존성 주입(DI)
	private UserRepository userRepository;
	//http://localhost:8005/blog/dummy/join
	//http/
	@PostMapping("/dummy/join")
	public String join(pUser user) {
		System.out.println("id : " +user.getId());
		System.out.println("role : " +user.getRole());
		System.out.println("createTime : " +user.getCreatedTime());
		System.out.println("username : " +user.getUsername());
		System.out.println("password : " +user.getPassword());
		System.out.println("email : " +user.getEmail());
		user.setRole(RoleType.USER);
		userRepository.save(user);
		return "회원가입 완료";
	}
}
