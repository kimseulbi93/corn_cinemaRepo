package com.acorn.persistence;

import java.util.List;

import com.acorn.domain.MemberBoardVO;
import com.acorn.model.PageDTO;

public interface MemberBoardDAO {
	 
	public List<MemberBoardVO> MemberBoardList(PageDTO pageDTO) throws Exception; //회원목록
                                      
	public int getMemberListCount(PageDTO pageDTO) throws Exception; //회원조회
	
	public MemberBoardVO selectMember(String id) throws Exception;
	
}
