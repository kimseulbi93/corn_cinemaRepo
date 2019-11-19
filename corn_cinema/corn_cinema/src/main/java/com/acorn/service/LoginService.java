package com.acorn.service;

import com.acorn.domain.MemberVo;
import com.acorn.model.LoginDTO;

public interface LoginService {

	public abstract MemberVo checkLogin(LoginDTO dto) throws Exception;
	
}
