package com.jm.blog.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.jm.blog.model.Board;
import com.jm.blog.model.pUser;
import com.jm.blog.repository.BoardRepository;
import com.jm.blog.repository.UserRepository;

@Service // 스프링이 컴포넌트 스캔을 통해서 Bean에 등록을 해줌. Ioc 를 해준다. -> 메모리에 대신 띄어준다?
public class BoardService {

	@Autowired
	private BoardRepository boardRepository;

	@Transactional
	public void write(Board board) {
		board.setCount(0);
		boardRepository.save(board);
	}

	@Transactional
	public void reviseList(int id, Board reBoard) {
		Board board = boardRepository.findById(id).orElseThrow(() -> {
			return new IllegalArgumentException("fail");
		});
		board.setTitle(reBoard.getTitle());
		board.setContent(reBoard.getContent());
		// 해당 함수 종료시(Servicerk 종료될 때) 트랜잭션이 종료된다. 이때 더티체킹.
	}

	public Page<Board> ListOfArticles(Pageable pageable) {
		return boardRepository.findAll(pageable);
	}

	public Board detail(int id) {
		return boardRepository.findById(id).orElseThrow(() -> {
			return new IllegalArgumentException("fail to load");
		});
	}
}
