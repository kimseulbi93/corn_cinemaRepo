package com.acorn.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class FindDTO {
	
	private String id;
    private String name;
	private String email;
	private String password;
}
