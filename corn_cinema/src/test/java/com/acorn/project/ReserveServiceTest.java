package com.acorn.project;

import java.util.List;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.acorn.domain.BookingDTO;
import com.acorn.service.ScreeningService;

import lombok.extern.log4j.Log4j;

@Log4j
@RunWith(SpringRunner.class)
@ContextConfiguration(
      //와일드카드 아닌 이 설정파일 하나로만!
      locations= {"file:src/main/webapp/WEB-INF/spring/root-context.xml"}
)
public class ReserveServiceTest {

   @Inject//@AutoWired
   private ScreeningService service;
   
   @Before
   public void setup() {
      log.info("ScreeningService::setup() invoked"); 
   }
   
   @Test
   public void testcities() throws Exception{
      BookingDTO dto = new BookingDTO("001","서울","강동","\'2019-09-27 10:40:00\'");
      log.info("ScreeningService::TestService() invoked");
      log.info("\t+service: "+service);
      List<String> str = service.getCities(dto);
      log.info("- str : " + str);
      
      int count =0;
         for(String a: str) {
            count++;
            log.info(count +" "+a);
         }//for
   }
   
   
    @Test
      public void testdist() throws Exception {
         log.info("ScreeningService :: testdist invoked.");
         log.info("\t+service: "+service);
         
         BookingDTO dto = new BookingDTO("001","서울","강동","\'2019-09-27 10:40:00\'");
         log.info("dto : " + dto);
         
         List<String> str = service.getDistricts(dto);
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
         log.info("dao : " + service);
         
         BookingDTO dto = new BookingDTO("001","서울","강동","\'2019-09-29 12:40:00\'");
//         BookingDTO dto = new BookingDTO("001","서울","강동","2019-09-29 10:40:00");
         log.info("dto : " + dto);
         
         List<String> str = service.getDates(dto);
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
         log.info("service : " + service);
         
         BookingDTO dto = new BookingDTO("001","서울","강동","\'2019-09-27\'");
//         BookingDTO dto = new BookingDTO("001","서울","강동","2019-09-29");
         log.info("dto : " + dto);
         
         List<String> str = service.getTimes(dto);
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
         log.info("service : " + service);
         
         BookingDTO dto = new BookingDTO("001","서울","강동","\'2019-09-27 10:40:00\'");
//         BookingDTO dto = new BookingDTO("001","서울","강동","2019-09-27");
         log.info("dto : " + dto);
         
         List<String> str = service.getSeats(dto);
         log.info("- str : " + str);
         
         int count =0;
         for(String str1: str) {
            count++;
            log.info(count +" "+str1);
         }//for
         
      }//testdist
  
   
}//end class