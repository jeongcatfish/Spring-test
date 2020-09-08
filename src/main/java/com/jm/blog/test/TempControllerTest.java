package com.jm.blog.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TempControllerTest {

	//http://localhost:8001/blog/temp/home
	@GetMapping("/temp/home")
	public String tempHome() {
		System.out.println("tempHome()");
		//파일리턴 기본경로 : src/main/resources/static
		return "/home.html";
	}
	
	@GetMapping("/temp/Img")
	public String tempImg() {
		return "/a.png";
	}
	@GetMapping("/temp/Jsp")
	public String tempJsp() {
		//prefix: /WEB-INF/views/
		//suffix: .jsp
		//fullname : /WEB-INF/views
		return "test";
	}
}
