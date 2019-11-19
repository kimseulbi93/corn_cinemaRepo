package com.acorn.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.acorn.domain.BookingDTO;
import com.acorn.domain.MypageVO;
import com.acorn.domain.ReservationVO;

import lombok.extern.log4j.Log4j;

@Log4j
@Repository
public class ScreeningDAOImpl 
	implements ScreeningDAO{
	
	@Inject
	private SqlSession sqlSession;
	private final String namespace = "com.acorn.mapper.Screening";
	
	
	@Override
	public List<String> selectCities(BookingDTO dto) {
		log.info("ScreeningDAOImpl :: selectCities(BookingDTO dto) invoked.");		
		return sqlSession.selectList(namespace + ".showcity", dto);	
	}//selectCities

	
	@Override
	public List<String> selectDistricts(BookingDTO dto) {
		log.info("ScreeningDAOImpl :: selectDistricts(BookingDTO dto) invoked.");		
		return sqlSession.selectList(namespace + ".showdist", dto);
	}//selectDistricts

	@Override
	public List<String> selectDates(BookingDTO dto) {
		log.info("ScreeningDAOImpl :: selectDates(BookingDTO dto) invoked.");		
		return sqlSession.selectList(namespace + ".showdate", dto);	
	}//selectDates

	@Override
	public List<String> selectTimes(BookingDTO dto) {
		log.info("ScreeningDAOImpl :: selectTimes(BookingDTO dto) invoked.");		
		return sqlSession.selectList(namespace + ".showtime", dto);		
	}//selectTimes

	@Override
	public List<String> selectSeats(BookingDTO dto) {
		log.info("ScreeningDAOImpl :: selectSeats(BookingDTO dto) invoked.");		
		return sqlSession.selectList(namespace + ".showseat", dto);		
	}//selectSeats


	@Override
	public List<String> selectTotalSeats(BookingDTO dto) throws Exception {
		log.info("ScreeningDAOImpl :: selectTotalSeats(BookingDTO dto) invoked.");		
		return sqlSession.selectList(namespace + ".showtotalseat", dto);	
	}


	@Override
	   public void InsertReservation(ReservationVO dto) throws Exception {
	      log.info("ScreeningDAOImpl :: InsertReservation(BookingDTO dto) invoked.");
	      sqlSession.insert(namespace + ".InsertReservation" , dto);      
	   }
	
	@Override
	   public String selectScreeningNum(BookingDTO dto) throws Exception {
	      log.info("ScreeningDAOImpl :: selectScreeningNum(BookingDTO dto) invoked.");      
	      return sqlSession.selectOne(namespace + ".selectScreeningnum", dto);
	   }


	@Override
	public List<String> selectReservationNum(MypageVO vo) throws Exception {
		return null;
	}


	@Override
	public List<String> selectTitle(MypageVO vo) throws Exception {
		return null;
	}


	@Override
	public List<String> selectDistricts(MypageVO vo) throws Exception {
		return null;
	}


	@Override
	public List<String> selectTimes(MypageVO vo) throws Exception {
		return null;
	}


	@Override
	public List<String> selectReservationDate(MypageVO vo) throws Exception {
		return null;
	}
	
	
	

	
}//endclass
