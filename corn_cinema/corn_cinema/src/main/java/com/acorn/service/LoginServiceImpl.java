package com.acorn.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.acorn.domain.MemberVo;
import com.acorn.model.LoginDTO;
import com.acorn.persistence.LoginDAO;

import lombok.extern.log4j.Log4j;

@Log4j
@Service


public class LoginServiceImpl implements LoginService{

	@Inject
	private LoginDAO dao;
	
	@Override
	public MemberVo checkLogin(LoginDTO dto) throws Exception {

     log.info("checkLogin invoked");
     log.info("dao: " + dao);
     
      MemberVo vo = dao.login(dto);
      
      if(vo!=null) {   //로그인 성공
          log.info("\t Found user: " + vo);
       }else {	    	
    	  log.info("\t + No user Found." + vo);
       } //if-else
      
       return vo;
	
	} // checkLogin

} // class
