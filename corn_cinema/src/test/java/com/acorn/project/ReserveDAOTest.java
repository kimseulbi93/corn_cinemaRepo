package com.acorn.project;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.acorn.domain.BookingDTO;
import com.acorn.persistence.ScreeningDAO;

import lombok.extern.log4j.Log4j;


@Log4j
@RunWith(SpringRunner.class)
@ContextConfiguration(
		locations= {"file:src/main/webapp/WEB-INF/spring/root-context.xml"}
		)
public class ReserveDAOTest {
	
	@Inject
	private ScreeningDAO dao;
	
	
	@Test
	public void testcities() throws Exception {
		log.info("ReserveDAOTest :: testcities invoked.");
		log.info("dao : " +dao);
		
		BookingDTO dto = new BookingDTO("001","서울","강동","\'2019-09-27 10:40:00\'");
		log.info("dto : " + dto);
		
		List<String> str = dao.selectCities(dto);
		log.info("- str : " + str);
		
		int count =0;
		for(String str1: str) {
			count++;
			log.info(count +" "+str1);
		}//for
		
	}//testScreeningDAO
	
	@Test
	public void testdist() throws Exception {
		log.info("ReserveDAOTest :: testdist invoked.");
		log.info("dao : " +dao);
		
		BookingDTO dto = new BookingDTO("001","서울","강동","\'2019-09-27 10:40:00\'");
		log.info("dto : " + dto);
		
		List<String> str = dao.selectDistricts(dto);
		log.info("- str : " + str);
		
		int count =0;
		for(String str1: str) {
			count++;
			log.info(count +" "+str1);
		}//for
		
	}//testdist
	
	@Test
	public void testDate() throws Exception {
		log.info("ReserveDAOTest :: testDate invoked.");
		log.info("dao : " + dao);
		
//		BookingDTO dto = new BookingDTO("001","서울","강동","\'2019-09-27 10:40:00\'");
		BookingDTO dto = new BookingDTO("001","서울","강동","2019-09-27 10:40:00");
		log.info("dto : " + dto);
		
		List<String> str = dao.selectDates(dto);
		log.info("- str : " + str);
		
		int count =0;
		for(String str1: str) {
			count++;
			log.info(count +" "+str1);
		}//for
		
	}//testdist
	
	@Test
	public void testTime() throws Exception {
		log.info("ReserveDAOTest :: testTime invoked.");
		log.info("dao : " + dao);
		
//		BookingDTO dto = new BookingDTO("001","서울","강동","\'2019-09-27\'");
		BookingDTO dto = new BookingDTO("001","서울","강동","2019-09-27");
		log.info("dto : " + dto);
		
		List<String> str = dao.selectTimes(dto);
		log.info("- str : " + str);
		
		int count =0;
		for(String str1: str) {
			count++;
			log.info(count +" "+str1);
		}//for
		
	}//testdist
	
	@Test
	public void testSeats() throws Exception {
		log.info("ReserveDAOTest :: testTime invoked.");
		log.info("dao : " + dao);
		
		BookingDTO dto = new BookingDTO("001","서울","강동","\'2019-09-27 10:40:00\'");
//		BookingDTO dto = new BookingDTO("001","서울","강동","2019-09-27");
		log.info("dto : " + dto);
		
		List<String> str = dao.selectSeats(dto);
		log.info("- str : " + str);
		
		int count =0;
		for(String str1: str) {
			count++;
			log.info(count +" "+str1);
		}//for
		
	}//testdist
	
	

}//endClass
