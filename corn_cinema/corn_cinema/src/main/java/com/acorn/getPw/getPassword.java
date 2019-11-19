package com.acorn.getPw;


import java.util.UUID;


public class getPassword {
	
	
	 public static String newPw() {
	    	
		   
	        String uuid = UUID.randomUUID().toString().replaceAll("-", ""); // -를 제거해 주었다.
	        uuid = uuid.substring(0,6); //uuid를 앞에서부터 6자리 잘라줌.
	        System.out.println(uuid);
			  return uuid;
	      
	    }
 }