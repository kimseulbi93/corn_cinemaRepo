package com.acorn.project;

import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import lombok.extern.log4j.Log4j;
 

@Log4j

public class ramdomtest {
    @Test
    public void newPw() {
    	
   
	        String uuid = UUID.randomUUID().toString().replaceAll("-", ""); // -를 제거해 주었다.
	        uuid = uuid.substring(0,6); //uuid를 앞에서부터 10자리 잘라줌.
	        System.out.println(uuid);
	      
	    }
	  }

    