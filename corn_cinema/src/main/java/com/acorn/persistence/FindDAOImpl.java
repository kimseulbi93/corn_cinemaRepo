package com.acorn.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.acorn.domain.MemberVo;
import com.acorn.model.FindDTO;

import lombok.extern.log4j.Log4j;

@Log4j
@Repository


public class FindDAOImpl implements FindDAO {

	@Inject
	private SqlSession sqlSession;
	
	private static final String namespace = "com.acorn.mapper.FindMapper";

	
	@Override
	public String findId(MemberVo vo) throws Exception {
		
		log.info("findId invoked");
		log.info( "vo : " + vo);
		
		return sqlSession.selectOne(namespace+".findId", vo);
	} //findId

	
	@Override
	public String findPw(MemberVo vo) throws Exception {
		
		log.info("findPw invoked");
		log.info( "vo : " + vo);
		
		return sqlSession.selectOne(namespace+".findPw", vo);
	} //findPw
	
	
	@Override
	public void updatePw(MemberVo vo) throws Exception {
    
		log.info("updatePw invoked");
        log.info("vo "+ vo); 
        
	   sqlSession.update(namespace+".updatePw", vo);
	} //updatePw

	
} //end class


