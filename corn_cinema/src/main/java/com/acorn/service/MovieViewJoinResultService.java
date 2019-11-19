package com.acorn.service;

import java.util.List;

import com.acorn.domain.MemberReplyJoinResultVO;
import com.acorn.domain.MovieViewJoinResultVO;
import com.acorn.model.MovieCommentsDTO;

public interface MovieViewJoinResultService {

	//최신 개봉작 영화 목록
	public abstract List<MovieViewJoinResultVO> newMovieList() throws Exception; 
	//movie 목록
	
	// 박스오피스 영화 목록 
	public abstract List<MovieViewJoinResultVO> boxMovieList() throws Exception; 
	
	public abstract MovieViewJoinResultVO movieRead(String movie_num) throws Exception;
	//movie detail 정보 가져오기
}  //end interface
