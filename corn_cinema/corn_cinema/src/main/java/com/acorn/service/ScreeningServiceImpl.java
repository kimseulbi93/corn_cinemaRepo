package com.acorn.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.acorn.domain.BookingDTO;
import com.acorn.domain.ReservationVO;
import com.acorn.persistence.ScreeningDAO;

import lombok.extern.log4j.Log4j;

@Log4j
@Service
public class ScreeningServiceImpl implements ScreeningService {

	@Inject
	ScreeningDAO dao;

	@Override
	public List<String> getCities(BookingDTO dto) throws Exception {
		
		return dao.selectCities(dto);
	}

	@Override
	public List<String> getDistricts(BookingDTO dto) throws Exception {
		return dao.selectDistricts(dto);
	}

	@Override
	public List<String> getDates(BookingDTO dto) throws Exception {
		return dao.selectDates(dto);
	}

	@Override
	public List<String> getTimes(BookingDTO dto) throws Exception {
		return dao.selectTimes(dto);
	}

	@Override
	public List<String> getSeats(BookingDTO dto) throws Exception {
		return dao.selectSeats(dto);
	}

	@Override
	public List<String> getTotalSeats(BookingDTO dto) throws Exception {
		// TODO Auto-generated method stub
		return dao.selectTotalSeats(dto);
	}
	
	@Override
	   public void InsertReservation(ReservationVO dto) throws Exception {
	      dao.InsertReservation(dto);
	   }
	
	@Override
	   public String getScreeningNum(BookingDTO dto) throws Exception {
	      log.info("ScreeningServiceImpl::getScreeningNum invoked");
	      return dao.selectScreeningNum(dto);
	   }
}














