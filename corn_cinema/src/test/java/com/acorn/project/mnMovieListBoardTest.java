package com.acorn.project;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.acorn.domain.Criteria;
import com.acorn.domain.MovieViewJoinResultVO;
import com.acorn.persistence.MnMovieBoardDAO;

import lombok.extern.log4j.Log4j;

@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		     locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class mnMovieListBoardTest {

		
	@Autowired 
	private MnMovieBoardDAO dao;
	 
//	@Test
//	public void testListPage() throws Exception {
//		int page = 3;
//		
//		 List<MovieViewJoinResultVO> list = dao.mnMovieListPage(page);
//		 
//		 
//		 for(MovieViewJoinResultVO vo : list){
//			 log.info(vo.getMovie_num()+":"+vo.getTitle());
//		 }
//		 
//	}
//	
	@Test
	public void testListCriteria()throws Exception  {
		Criteria cri = new Criteria();
		
		cri.setPage(2);
		cri.setPerPageNum(20);
		
		List<MovieViewJoinResultVO> list = dao.mnMovieListCriteria(cri);
		
		for(MovieViewJoinResultVO vo : list){
			 log.info(vo.getMovie_num()+":"+vo.getTitle());
		 }
		
		
	}

}

