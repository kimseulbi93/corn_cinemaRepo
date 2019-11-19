package com.acorn.persistence;

import java.util.List;

import com.acorn.domain.MypageDTO;
import com.acorn.domain.MypageVO;
import com.acorn.model.LoginDTO;


public interface MypageDAO {
	
	   public abstract List<MypageVO> selectReservation(LoginDTO dto) throws Exception;
	   

	   
	   public abstract List<MypageVO> selectReservationOk(LoginDTO dto) throws Exception;
	   
	   public abstract List<MypageVO> selectReservationNOk(LoginDTO dto) throws Exception;
	   
	   public void delete(LoginDTO dto) throws Exception;
}
