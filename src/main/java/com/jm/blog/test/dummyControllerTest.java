package com.jm.blog.test;

import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jm.blog.model.RoleType;
import com.jm.blog.model.pUser;
import com.jm.blog.repository.UserRepository;

//데이터를 리턴해주는 컨트롤러
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
		return "회원가입 완료!";
	}
	
	// http://localhost:8001/blog/dummy/user/3
	@GetMapping(  "/dummy/user/{id}")
	public pUser detail(@PathVariable int id) {
		
		pUser user = userRepository.findById(id).orElseThrow(new Supplier<IllegalArgumentException>() {
			@Override
			public IllegalArgumentException get() {  
				// TODO Auto-generated method stub
				return new IllegalArgumentException("해당 유저 없음  id  : " +id);
			}
		});
		// 요청 : 웹 브라우져
		// user 객체 = 자바오브젝트
		// 변환 (웹 브라우져가 이해할 수 있게) -> json
		// 스프링부트는 MessageConverter라는 애가 응답시에 자동으로 작동
		//만약 자바오브젝트를 리턴하게 되면 MessageConverter가 "Jackon"  라이브러리를 호출해서
		// user 오브젝트를 json으로 변환해서 브라우져에게 던져줌
		return user;
	}
}
