package com.acorn.persistence;

import com.acorn.domain.MemberVo;
import com.acorn.model.FindDTO;

public interface FindDAO {

	public abstract String findId(MemberVo vo) throws Exception;
	
	public abstract String findPw(MemberVo vo) throws Exception;
	
	public abstract void updatePw(MemberVo vo) throws Exception;
	
}


