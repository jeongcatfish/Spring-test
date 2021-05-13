package com.jm.blog.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jm.blog.model.RoleType;
import com.jm.blog.model.pUser;
import com.jm.blog.repository.UserRepository;

@Service // 스프링이 컴포넌트 스캔을 통해서 Bean에 등록을 해줌. Ioc 를 해준다. -> 메모리에 대신 띄어준다?
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Transactional
	public void join(pUser user) {
		try {
			String rawPassword = user.getPassword(); 
			String encPassword = encoder.encode(rawPassword);
			user.setRole(RoleType.USER);
			user.setPassword(encPassword);
			userRepository.save(user);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("UserService 회원가입 Func : " + e.getMessage());
		}
	}

//	@Transactional(readOnly = true) // SELECT 할 때 트랜잭션 시작, 서비스 종료시에 트랜잭션 종료(정합성)
//	public pUser login(pUser user) {
//		return userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
//	}
	
	@Transactional
	public void AddUser(pUser user) {
		userRepository.save(user);
	}

	// 유저 추가

	// 한 명의 회원정보 가져오기
	public pUser getUser(int id) {
		pUser user = userRepository.findById(id).orElseThrow(() -> {
			return new IllegalArgumentException("fail to get user");
		});
		return user;
	}

	// 모든 회원정보 가져오기
	public List<pUser> getUsers() {
		List<pUser> users = userRepository.findAll();
		return users;
	}

	// 회원정보 수정
	@Transactional
	public void reviseUser(int id, pUser reuser) {
		pUser user = userRepository.findById(id).orElseThrow(() -> {
			return new IllegalArgumentException("fail");
		});

		if (reuser.getUsername() == null)
			;
		else
			user.setUsername(reuser.getUsername());
		if (reuser.getPassword() == null)
			;
		else
			user.setPassword(reuser.getPassword());
		if (reuser.getUsername() == null)
			;
		else
			user.setEmail(reuser.getEmail());
	}

	// 회원정보 삭제
	public void deleteById(int id) {
		userRepository.deleteById(id);
	}
}
