package com.acorn.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acorn.domain.MovieViewJoinResultVO;
import com.acorn.persistence.MovieAvgScoreResultDAO;
import com.acorn.persistence.MovieViewJoinResultDAO;

import lombok.extern.log4j.Log4j;


@Log4j
@Service
public class MovieViewJoinResultServiceImpl 
	implements MovieViewJoinResultService {

	@Autowired
	MovieViewJoinResultDAO dao;
	

	
	//최신 개봉작 영화 목록
	@Override
	public List<MovieViewJoinResultVO> newMovieList() throws Exception {
		
	
		return dao.newMovieList();
		
	}  //newMovieList
	
	
	//박스오피스 영화 목록
   @Override
   public List<MovieViewJoinResultVO> boxMovieList() throws Exception {
      
	   
      return dao.boxMovieList();
      
   }  //  boxMovieList
	
	 @Override 
	 public MovieViewJoinResultVO movieRead(String movie_num) throws Exception{
	  
		 
		  return dao.movieRead(movie_num);
	}  //movieRead
	 

}  //end class
