package com.acorn.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.acorn.domain.Criteria;
import com.acorn.domain.MovieViewJoinResultVO;
import com.acorn.model.MnMovieFileDTO;
import com.acorn.model.MovieViewJoinResultDTO;

public interface MnMovieBoardService {

	//관리자 영화 리스트
	// 전체 리스트 
	public abstract List<MovieViewJoinResultVO> mnMovieListAll() throws Exception;
	
	//영화 상세 정보 
	public abstract MovieViewJoinResultVO mnMovieRead(String movie_num) throws Exception;

	//영화 등록
	public abstract void mnMovieRegist(MovieViewJoinResultDTO dto , MultipartFile[] files) throws Exception;

	
	//수정
	public abstract void mnMovieModify(MovieViewJoinResultDTO dto , MultipartFile[] files) throws Exception;
	

	//페이징 처리
	public abstract List<MovieViewJoinResultVO>  mnMovieListCriteria(Criteria cri) throws Exception;
	
	public abstract int mnMovielistCountCriteria(Criteria cri) throws Exception;
	
	//페이징 처리
	
	
}  //end interface
