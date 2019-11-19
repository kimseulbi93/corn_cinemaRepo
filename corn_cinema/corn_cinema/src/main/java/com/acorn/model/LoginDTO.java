package com.acorn.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data


public class LoginDTO {

	private String id;
	private String password;
	private String reservation_num;
	
}
