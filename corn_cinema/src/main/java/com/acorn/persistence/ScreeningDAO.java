package com.acorn.persistence;

import java.util.List;

import com.acorn.domain.BookingDTO;
import com.acorn.domain.MypageVO;
import com.acorn.domain.ReservationVO;

public interface ScreeningDAO {
	
	
	//tbl_screening
	public abstract List<String> selectCities(BookingDTO dto) throws Exception;
	
	public abstract List<String> selectDistricts(BookingDTO dto) throws Exception;//복수형으로
	
	public abstract List<String> selectDates(BookingDTO dto) throws Exception;
	
	public abstract List<String> selectTimes(BookingDTO dto) throws Exception;
	
	public abstract List<String> selectSeats(BookingDTO dto) throws Exception;
	
	public abstract List<String> selectTotalSeats(BookingDTO dto) throws Exception;
	
	public abstract void InsertReservation(ReservationVO dto) throws Exception;
	
	public abstract String selectScreeningNum(BookingDTO dto) throws Exception;
	
	//Mypage안에 예약내역
	public abstract List<String> selectReservationNum(MypageVO vo) throws Exception;
	
	public abstract List<String> selectTitle(MypageVO vo) throws Exception;
	
	public abstract List<String> selectDistricts(MypageVO vo) throws Exception;
	
	public abstract List<String> selectTimes(MypageVO vo) throws Exception;
	
	public abstract List<String> selectReservationDate(MypageVO vo) throws Exception;
}
