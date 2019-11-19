package com.acorn.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor



public class MemberDTO {

	private String id;
	private String password;
	private String name;
	private String email;

	
	
}
