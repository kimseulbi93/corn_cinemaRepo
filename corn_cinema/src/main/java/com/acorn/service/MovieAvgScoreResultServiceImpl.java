package com.acorn.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.acorn.domain.MovieAvgScoreResultVO;
import com.acorn.persistence.MovieAvgScoreResultDAO;

import lombok.extern.log4j.Log4j;

@Log4j
@Service
public class MovieAvgScoreResultServiceImpl implements MovieAvgScoreResultService {

	@Inject
	MovieAvgScoreResultDAO dao;
	
	//평점 출력
	@Override
	public void replyScoreUpdate(MovieAvgScoreResultVO vo) throws Exception {
		
		dao.replyScoreUpdate(vo);
	}

	@Override
	public MovieAvgScoreResultVO replyScoreSelect(String movie_num) throws Exception {
		
		return dao.replyScoreSelect(movie_num);
	}

}
