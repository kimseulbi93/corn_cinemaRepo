/*package com.acorn.project;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.acorn.domain.MemberVo;
import com.acorn.model.LoginDTO;
import com.acorn.persistence.LoginDAO;

import lombok.extern.log4j.Log4j;

@Log4j
@RunWith(SpringRunner.class)
@ContextConfiguration(
		locations= {"file:src/main/webapp/WEB-INF/spring/root-context.xml"}
		)

public class LoginDAOTest {

	 @Inject
	 private LoginDAO dao;
	 
	
	 @Before
	 public void setup() {
		 log.info("setup() invoked"); 
	 }
	
	  @Test
	  public void testMD() throws Exception{
		   log.info("testMD()");
		   log.info("dao:" + dao);
		
		 * LoginDTO dto = new LoginDTO("asdasd","123123");
		 
		   log.info("dto :" + dto);
		   
		   MemberVo vo = dao.login(dto);
		   
		   if(vo!=null) {   //로그인 성공
	    	   log.info("\t Found user: " + vo);
	       }else {
	    	   log.info("\t + No user Found.");
	       }
		   
	  }*/
	 
	 
	 
/*
 * }//end class
 */