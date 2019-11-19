package com.acorn.persistence;

import java.util.List;

import com.acorn.domain.MemberReplyJoinResultVO;

public interface ReplyDAO {

	//댓글 리스트
	//영화별 댓글 전체 조회
	public abstract List<MemberReplyJoinResultVO> replyList(String movie_num) throws Exception;
	
	//삽입
	public abstract void replyCreate(MemberReplyJoinResultVO vo) throws Exception;

	//수정
	public abstract void replyUpdate(MemberReplyJoinResultVO vo) throws Exception;
	
	//삭제
	public abstract int replyDelete(String id) throws Exception;




}  //end interface
