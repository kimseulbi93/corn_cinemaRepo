package com.acorn.domain;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberReplyJoinResultVO {

	private String id;  //작성자 id pk
	private String password;  //회원 비밀번호
	private String name;  //이름 
	private String email;  //이메일
	

	private String movie_num;  //영화 번호 pk
	private String comment;  //한줄평
	
	private int score;  //별점 
	private double avgscore;  //별점평균 
	
	private String regdate;  //등록 날짜
	private String updatedate;  //수정 날짜

}
