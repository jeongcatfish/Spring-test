package com.jm.blog.test;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.Delegate;

//사용자가 요청 -> 응답(HTML 파일)
//@Controller

//사용자가 요청 -> 응답(Data)
@RestController
public class HttpControllerTest {

	@GetMapping("/http/get")
	public String getTest(Member m) {
		return "get test : "+ m.getId() +" username : "+m.getUsername()+" passwrod : " +m.getPassword()+" email : " +m.getEmail();
	}
	@PutMapping("/http/put")
	public String putTest(@RequestBody Member m) {
		return "put test : "+ m.getId() +" username : "+m.getUsername()+" passwrod : " +m.getPassword()+" email : " +m.getEmail();
	}
	@PostMapping("/http/post")
	public String postTest(@RequestBody Member m) { //Message Converter(Spring Boot)
		return "postf test : "+ m.getId() +" username : "+m.getUsername()+" passwrod : " +m.getPassword()+" email : " +m.getEmail();
	}
	@DeleteMapping("/http/delete")
	public String deleteTest() {
		return "get test";
	}
}
