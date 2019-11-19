package com.acorn.domain;

import java.sql.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class MemberBoardVO {
	//아이디
	private String id;
	//이름
	private String name;
	//이메일
	private String email;
	//가입날짜
	private String regdate;
	//수정날짜 
	private String updatedate;
	//회원 connection 시간
	private String connection_time;
	//회원 disconnected 시간
	private String disconnected_time;
}



