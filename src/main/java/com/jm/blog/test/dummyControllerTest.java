package com.jm.blog.test;

import java.util.List;
import java.util.function.Supplier;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jm.blog.model.RoleType;
import com.jm.blog.model.pUser;
import com.jm.blog.repository.UserRepository;

import net.bytebuddy.asm.Advice.OffsetMapping.Sort;

//데이터를 리턴해주는 컨트롤러
@RestController
public class dummyControllerTest {

	@Autowired //의존성 주입(DI)
	private UserRepository userRepository;
	
	//http://localhost:8005/blog/dummy/join
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
	@GetMapping( "/dummy/user/{id}")
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
		return user ;
	}
	
	@GetMapping("/dummy/users")
	public List<pUser> list(){
		return userRepository.findAll();
	}
	
	//한 페이지에 2건의 데이터 받기
//	@GetMapping("/dummy/user")
//	public Page<pUser> pageList(@PageableDefault(size = 2, sort = "id", direction = Sort.))
	
	//save함수는 id를 전달하지 않으면 insert를 해주고
	//save함수는 id를 전달하면 해당 id에 대한 데이터가 있으면 update를 해주고
	//save함수는 id를 전달하면 해당 id에 대한 데이터가 없으면 insert를 해준다.
	
	@Transactional //함수 종료시에 자동 commit이 됨
	@PutMapping("/dummy/user/{id}")
	public pUser updateUser(@PathVariable int id, @RequestBody pUser requrestUser) { // json 데이터를 요청 => Java Object(MessageConverter의 Jackson라이브러리가 변환함)로 변환해서 받아줌.
		System.out.println("id : " +id);
		System.out.println("password : " +requrestUser.getPassword());
		System.out.println("email : " +requrestUser.getEmail());
		
		pUser user = userRepository.findById(id).orElseThrow(()->{
			return new IllegalArgumentException("수정 실패");
		});
		user.setPassword(requrestUser.getPassword());
		user.setEmail(requrestUser.getEmail());
		
		//userRepository.save(user);
		
		//더티체킹
		return user;
	}
	
	@DeleteMapping("dummy/user/{id}")
	public String delete(@PathVariable int id) {
		
		try {
			userRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			// TODO: handle exception
			return "삭제에 실패하였습니다. 해당 id DB에 없습니다";
		}
		return "삭제되었습니다 id : " +id;
	}
}
