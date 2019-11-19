package com.acorn.service;

import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.acorn.domain.MemberVo;

import com.acorn.persistence.MemberDAO;

import lombok.extern.log4j.Log4j;

@Log4j
@Service


public class MemberServiceImpl implements MemberService {

@Inject
private MemberDAO dao ;	
	
	@Override
	public void regist(MemberVo vo) throws Exception {
		
	       log.info("\t dao:" + dao ); 
	       log.info("\t+ vo:" + vo);
	     	       
	       dao.insertMember(vo);
		
	} //regist
	
	
	@Override
	public void modify(MemberVo vo) throws Exception {
		
        log.info("modify invoked");
        log.info("vo:"+ vo);
        
		dao.updateProfile(vo);
		
	} //modify


	@Override
	public int remove(MemberVo vo) throws Exception {
        
		 int userRemoveCount = dao.deleteProfile(vo);
         return userRemoveCount;
    	
	} //remove


	@Override
	public int DuplicateId(String user_id) throws Exception {
		
		log.info("DuplicateId");
		return dao.idCheck(user_id);
		
	} //DuplicateId


	@Override
	public int DuplicateEmail(String user_email) throws Exception {
		 
	    log.info("DuplicateEmail");
		return dao.emailCheck(user_email);
		
	} //DuplicateEmail


	@Override
	public int getNewPw(MemberVo vo) throws Exception {
		
		log.info("getNewPw");
        return  dao.reset_Password(vo);

	} //getNewPw


	@Override
	public void connection_time(MemberVo vo) throws Exception {
		
		log.info("connection_time");
	    dao.connection_time(vo);
		
	} //connection_time


	@Override
	public void disconnected_time(MemberVo vo) throws Exception {
	  
		log.info("disconnected_time");
		dao.disconnected_time(vo);
		
	}
	
	


} //end interface
