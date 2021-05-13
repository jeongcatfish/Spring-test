package com.jm.blog.config.auth;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.jm.blog.model.pUser;


public class PrincipalDetail implements UserDetails{

	private pUser user;

	 public PrincipalDetail(pUser user) {
		// TODO Auto-generated constructor stub
		 this.user = user;
	}
	 
	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return user.getUsername();
	}

	// 계정이 만료되지 않았는지 리턴
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	// 계정이 정지되지 않았는지
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	//계정이 비밀번호가 만료되지 않았는지
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	// 계정이 활성화 되었는지
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	// 계정의 권한을 리턴
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		Collection<GrantedAuthority> collectors = new ArrayList<>();
//		collectors.add(new GrantedAuthority() {
//			
//			@Override
//			public String getAuthority() {
//				// TODO Auto-generated method stub
//				return "ROLE_"+user.getRole(); //ROLE_USER
//			}
//		});
		
		collectors.add(()->{return "ROLE_"+user.getRole();});
		return collectors;
	}
	
	
}
