package com.acorn.project;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.acorn.domain.MovieViewJoinResultVO;
import com.acorn.persistence.MemberBoardDAO;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		     locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"}
		     )


public class boardServiceTest {

	@Inject
	private MemberBoardDAO dao;
	
	
	@Test
	public void testMD() throws Exception{
		System.out.println("- dao: "+dao);
	}
	

}
