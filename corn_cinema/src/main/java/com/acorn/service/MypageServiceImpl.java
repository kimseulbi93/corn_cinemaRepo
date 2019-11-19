package com.acorn.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.acorn.domain.MypageVO;
import com.acorn.model.LoginDTO;
import com.acorn.persistence.MypageDAO;

import lombok.extern.log4j.Log4j;
@Log4j
@Service
public class MypageServiceImpl implements MypageService {
   
   @Inject
   MypageDAO dao;
   
   @Override
   public List<MypageVO> getReservation(LoginDTO dto) throws Exception {
      log.info("MypageServiceImpl::getReservation invoked.");
      return dao.selectReservation(dto);
   }//getReservation   

@Override
public void remove(LoginDTO dto) throws Exception {
	dao.delete(dto);
}

@Override
public List<MypageVO> getReservationOk(LoginDTO dto) throws Exception {
	return dao.selectReservationOk(dto);
}

@Override
public List<MypageVO> getReservationNOk(LoginDTO dto) throws Exception {
	return dao.selectReservationNOk(dto);
}

}//end class