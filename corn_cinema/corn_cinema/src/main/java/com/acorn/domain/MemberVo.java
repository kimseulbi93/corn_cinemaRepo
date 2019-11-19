package com.acorn.domain;

import java.sql.Date;
import java.util.List;


import lombok.Data;

@Data
public class MemberVo {

	private String id;
	private String password;
	private String name;
	private String email;
	private Date regdate;
	private Date updatedate;
	private Date connection_time;
	private Date disconnected_time;

	private List<ReplyVO> replyvo;
	
	public List<ReplyVO> setReplyList(List<ReplyVO> replyvo){ 
		return this.replyvo = replyvo; 
	}
	
	
	
	public void addReplyvo(ReplyVO vo) {
		replyvo.add(vo);
	}
	
	
}


