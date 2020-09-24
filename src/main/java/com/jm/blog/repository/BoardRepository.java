package com.jm.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jm.blog.model.Board;
import com.jm.blog.model.pUser;

//DAO
// 자동으로 bean등록이 된다.
// @Repository //생략 가능하다.
public interface BoardRepository extends JpaRepository<Board, Integer>{

}
