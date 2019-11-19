package com.acorn.project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		     locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"}
		     )

public class sss{
   
	 @Inject
	 private DataSource ds;
	  
	
	
	 @Before
	 public void before() {
		log.info("before test");
		
	}
	
	
	@Test
	public void test() throws Exception {
      log.info("test");
      log.info(" ds: " + ds );
      
      try(Connection con = ds.getConnection()){
        
    		String sql = "SELECT now()";
    	  PreparedStatement pstmt = con.prepareStatement(sql);
    	  ResultSet rs = pstmt.executeQuery();
    

			while(rs.next()) {

				System.out.println("--now:  "+rs.getString("now()"));

			}
			
    	  
	} catch(Exception  e) {
		e.printStackTrace();
}
	
	}
	
	
	  @After public void after() {
		  log.info("after"); 
		  }
	 
	
}
 
