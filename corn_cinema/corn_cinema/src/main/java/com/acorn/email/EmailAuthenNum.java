package com.acorn.email;



import java.util.UUID;


public class EmailAuthenNum {
	
	
	 public static String AuthenNum() {
	    	
		   
	        String uuid = UUID.randomUUID().toString().replaceAll("-", ""); // -를 제거해 주었다.
	        uuid = uuid.substring(0,6); //uuid를 앞에서부터 6자리 잘라줌.
	        System.out.println(uuid);
			  return uuid;
	      
	    }
 }