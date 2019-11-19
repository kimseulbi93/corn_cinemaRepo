package com.acorn.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;


import com.acorn.domain.MemberVo;
import com.acorn.model.LoginDTO;

import lombok.extern.log4j.Log4j;


@Repository
@Log4j


public class LoginDAOImpl 
        implements LoginDAO {
	
  @Inject
  private SqlSession sqlSession;
	
  private final String namespace="com.acorn.mapper.MemberMapper";

		
    @Override
    public MemberVo login(LoginDTO dto) 
    		throws Exception {

		log.info("MemberVo::login(dto) invoked"); 
		log.info("dto:" + dto);
		log.info("\t+ sqlSession: " + sqlSession );
		
		MemberVo vo = sqlSession.<MemberVo>selectOne(namespace+"."+"login", dto);
        log.info("vo:" + vo); 
        
        return vo;
        
	}

}
