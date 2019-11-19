package com.acorn.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.acorn.domain.MemberVo;
import com.acorn.persistence.FindDAO;

import lombok.extern.log4j.Log4j;

@Log4j
@Service


public class FindServiceImpl implements FindService {

	@Inject
	private FindDAO dao;
	
	@Override
	public String findId(MemberVo vo) throws Exception {

         log.info("findId invoked");
         log.info("FindServiceImpl vo:" + vo );
         
		 return dao.findId(vo);
	} //findId

	@Override
	public String findPw(MemberVo vo) throws Exception {
		
		log.info("findPw invoked");
		log.info( "vo : " + vo);
		
		return dao.findPw(vo);
	} //findPw
	
	
	@Override
	public void updatePw(MemberVo vo) throws Exception {

		log.info("findId invoked");
		log.info("findServiceImpl vo:"+ vo);
		
		dao.updatePw(vo);
	} //updatePw

	
	
}
