package com.acorn.persistence;

import com.acorn.domain.MemberVo;
import com.acorn.model.LoginDTO;

public interface LoginDAO {

	
	public abstract MemberVo login(LoginDTO dto) throws Exception;
	
}
