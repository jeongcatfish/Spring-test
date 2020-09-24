package com.jm.blog.model;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Board {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false,length = 100)
	private String title;
	
	@Lob // 대용량 데이터
	private String content; //html태그가 섞여서 디자인 됨.

	private int count; // 조회수
	
//	@ManyToOne // Many = Board, One = User 
//	@JoinColumn(name ="userId")
//	private pUser userId; //DB는 오브젝트를 저장할 수 없다. FK(foreign key), 자바, 오브젝트 저장할 수 있다.
	
	@OneToMany(mappedBy = "board", fetch = FetchType.EAGER) // mappedBy 연관관계의 주인이 아니다(난 FK키 아님) DB에 컬룸을 만들지 마세요.
	private List<Reply> reply; //하나의 게시글을 여러개의 리플을 달 수 있다.
	
	@CreationTimestamp
	private Timestamp createDate;
}
