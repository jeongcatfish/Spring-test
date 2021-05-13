package com.jm.blog.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jm.blog.model.pUser;

//DAO
// 자동으로 bean등록이 된다.
// @Repository //생략 가능하다.
public interface UserRepository extends JpaRepository<pUser, Integer>{
	//JPA NAMING 쿼리 
	//SELECT * FROM user WHERE user = ?1 AND password = ?2
	pUser findByUsernameAndPassword(String username, String password);
	
//	@Query(value = "SELECT * FROM user WHERE user = ?1 AND password = ?2", nativeQuery = true)
//	pUser login(String username, String password);  
	Optional<pUser> findByUsername(String username);
	
}
