package com.jm.blog.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jm.blog.model.pUser;
import com.jm.blog.repository.UserRepository;

@Service //스프링이 컴포넌트 스캔을 통해서 Bean에 등록을 해줌. Ioc 를 해준다. -> 메모리에 대신 띄어준다?
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Transactional
	public int 회원가입(pUser user) {
		try {
			userRepository.save(user);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("UserService 회원가입 Func : " + e.getMessage());
		}
		return -1;
	   }
}
