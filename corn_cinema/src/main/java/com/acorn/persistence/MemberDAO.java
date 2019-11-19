package com.acorn.persistence;

import java.util.Map;

import com.acorn.domain.MemberVo;

public interface MemberDAO {

	
   public abstract void insertMember(MemberVo vo) throws Exception;

   public abstract void updateProfile(MemberVo vo) throws Exception;
   
   public abstract int deleteProfile(MemberVo vo) throws Exception;

   public abstract int idCheck(String user_id) throws Exception ;

   public abstract int emailCheck(String user_email) throws Exception;

   public abstract int reset_Password(MemberVo vo) throws Exception;
   
   public abstract void connection_time(MemberVo vo) throws Exception;
   
   public abstract void disconnected_time(MemberVo vo) throws Exception;
	
}
