package com.acorn.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.acorn.domain.MemberBoardVO;
import com.acorn.model.PageDTO;
import com.acorn.persistence.MemberBoardDAO;

@Service
public class MemberBoardServiceImpl implements MemberBoardService{
	
	@Inject
	private MemberBoardDAO dao;
	
	@Override
	public List<MemberBoardVO> MemberBoardList(PageDTO pageDTO) throws Exception{
		return dao.MemberBoardList(pageDTO);
	}
	
	@Override
	public int getMemberListCount(PageDTO pageDTO) throws Exception {
		return dao.getMemberListCount(pageDTO);
	}

	@Override
	public MemberBoardVO selectMember(String id) throws Exception {
		return dao.selectMember(id);
	}
}
