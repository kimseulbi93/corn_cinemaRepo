package com.acorn.service;

import java.util.List;

import com.acorn.domain.MypageVO;
import com.acorn.model.LoginDTO;

public interface MypageService {
   
   public abstract List<MypageVO> getReservation(LoginDTO dto) throws Exception;
   
   
   public abstract List<MypageVO> getReservationOk(LoginDTO dto) throws Exception;
   
   public abstract List<MypageVO> getReservationNOk(LoginDTO dto) throws Exception;
   
   public void remove(LoginDTO dto) throws Exception;
}//end class