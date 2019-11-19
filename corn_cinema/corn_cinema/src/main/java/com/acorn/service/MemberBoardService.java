package com.acorn.service;

import java.util.List;

import com.acorn.domain.MemberBoardVO;
import com.acorn.model.PageDTO;

public interface MemberBoardService {
	
	public List<MemberBoardVO> MemberBoardList(PageDTO pageDTO) throws Exception;
	
	public int getMemberListCount(PageDTO pageDTO) throws Exception;
	
	public MemberBoardVO selectMember(String id) throws Exception;
}
