package com.jm.blog.config.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.jm.blog.model.pUser;
import com.jm.blog.repository.UserRepository;

@Service
public class PrincipalDetailService implements UserDetailsService{

	@Autowired
	private UserRepository userRepository;
	
	//스프링이 로그인 요청을 가로챌 떄, username, password 가로챔
	//password 부분 처리는 알아서 함.
	//username이 DB에만 있는지 확인만 하면 됨.
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		pUser principal = userRepository.findByUsername(username)
				.orElseThrow(()->{
					return new UsernameNotFoundException("none : " +username);
				});
		return new PrincipalDetail(principal); // 시큐리티 세션에 유저정보가 저장이 됨.
	}
}
