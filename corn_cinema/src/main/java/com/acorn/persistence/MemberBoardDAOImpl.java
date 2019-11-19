package com.acorn.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.acorn.domain.MemberBoardVO;
import com.acorn.model.PageDTO;

@Repository
public class MemberBoardDAOImpl implements MemberBoardDAO{

	@Inject
	private SqlSession sqlSession;
	
    private static final String namespace="com.acorn.mapper.MemberMapper";
	
	public List<MemberBoardVO> MemberBoardList(PageDTO pageDTO){
		return sqlSession.selectList(namespace+".MemberBoardList",pageDTO);			
	}   
	
	@Override
	public int getMemberListCount(PageDTO pageDTO) {
		System.out.println("pageDTO:" + pageDTO);
		return sqlSession.selectOne(namespace+".getMemberListCount",pageDTO);
	}

	@Override
	public MemberBoardVO selectMember(String id) throws Exception {
		 System.out.println("selectMember invoked");
		 System.out.println("id::123" + id);
		 return sqlSession.selectOne(namespace+".MemberBoardOne" ,id);
	}
}
