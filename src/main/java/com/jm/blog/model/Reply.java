package com.jm.blog.model;

import java.sql.Time;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Reply {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id; //시퀀스, auto_increment
	
	@Column(nullable = false, length = 200)
	private String content;
	
	@ManyToOne //여러개의 답변(Reply=Many)은 하나의 게시글(borad=One)에 존재할 수 있음
	@JoinColumn(name ="boardId")
	private Board board;
	
	@ManyToOne(fetch = FetchType.EAGER) // 여러개의 답변은 하나의 유저가 쓸 수 있다.
	@JoinColumn(name ="userId")
	private pUser user;
	
	@CreationTimestamp
	private Timestamp createDate;
}
