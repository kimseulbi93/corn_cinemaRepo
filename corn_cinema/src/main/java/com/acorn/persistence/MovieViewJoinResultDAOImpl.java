package com.acorn.persistence;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.acorn.domain.MovieVO;
import com.acorn.domain.MovieViewJoinResultVO;
import com.acorn.domain.ViewVO;

@Repository
public class MovieViewJoinResultDAOImpl implements MovieViewJoinResultDAO {

	@Inject
	private SqlSession sqlSession;
	private static final String namespace="com.acorn.mapper.MovieViewJoinMapper";
	
	
	
	//최신 개봉작 목록
	@Override
	public List<MovieViewJoinResultVO> newMovieList() throws Exception {
		
		List<MovieViewJoinResultVO> list = sqlSession.selectList(namespace + ".newMovieList");
		
		MovieVO movieVO = new MovieVO();
		List<ViewVO> movieViewList = new ArrayList<>();
		
	
		String movie_num = null;  //pk
		String title = null; //영화 제목
		String opening_day = null;	//영화 개봉일

		String film_rate = null;	//관람등급
		String running_time = null;	//상영시간
		double avg_score = 0.0;	// 영화별 평점
		
		String view_path = null;
		String view_name_key = null;  // 파일 암호키
		String view_name = null;
		
		int recordNum = 0;
		
		for(MovieViewJoinResultVO vo : list) {
			++recordNum;
			
			if(recordNum == 1) {
				movieVO.setMovie_num(movie_num);
				movieVO.setTitle(title);
				movieVO.setOpening_day(opening_day);
				movieVO.setFilm_rate(film_rate);
				movieVO.setRunning_time(running_time);
				movieVO.setAvg_score(avg_score);
			}
			
			ViewVO viewVO = new ViewVO();
			viewVO.setMovie_num(movie_num);
			viewVO.setView_path(view_path);
			viewVO.setView_name(view_name);
			viewVO.setView_name_key(view_name_key);
			
			movieViewList.add(viewVO);
		}
		
		movieVO.setList(movieViewList);
		
		return list;
	}  //movieList

	//박스오피스 영화 목록
	  @Override
	   public List<MovieViewJoinResultVO> boxMovieList() throws Exception {
	      
	      List<MovieViewJoinResultVO> list = sqlSession.selectList(namespace + ".boxMovieList");
	      
	      MovieVO movieVO = new MovieVO();
	      List<ViewVO> movieViewList = new ArrayList<>();
	      
	   
	      String movie_num = null;  //pk
	      String title = null; //영화 제목
	      String opening_day = null;   //영화 개봉일
	      String film_rate = null;   //관람등급
	      String running_time = null;   //상영시간
	      double avg_score = 0.0;   // 영화별 평점
	      
	      String view_path = null;
	  	  String view_name_key = null;  // 파일 암호키
		  String view_name = null;

	      int recordNum = 0;
	     
	      for(MovieViewJoinResultVO vo : list) {
	         ++recordNum;
	         
	         if(recordNum == 1) {
	            movieVO.setMovie_num(movie_num);
	            movieVO.setTitle(title);
	            movieVO.setOpening_day(opening_day);
	            movieVO.setFilm_rate(film_rate);
	            movieVO.setRunning_time(running_time);
	            movieVO.setAvg_score(avg_score);
	         }
	         
	         ViewVO viewVO = new ViewVO();
	         viewVO.setMovie_num(movie_num);
	         viewVO.setView_path(view_path);
			 viewVO.setView_name(view_name);
			 viewVO.setView_name_key(view_name_key);
	         
	         movieViewList.add(viewVO);
	      }
	      
	      movieVO.setList(movieViewList);
	      
	      return list;
	   }  //boxMovieList

	@Override
	public MovieViewJoinResultVO movieRead(String movie_num) throws Exception{
		
		return sqlSession.selectOne(namespace + ".movieRead", movie_num);
		 
	} //movieRead
	
	
	
	
}
