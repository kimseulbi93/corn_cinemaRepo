package com.acorn.persistence;

import java.util.List;

import com.acorn.domain.Criteria;
import com.acorn.domain.MovieViewJoinResultVO;
import com.acorn.model.MnMovieFileDTO;
import com.acorn.model.MovieViewJoinResultDTO;

public interface MnMovieBoardDAO {

	//관리자 영화 리스트
	// 전체 리스트 
	public abstract List<MovieViewJoinResultVO> mnMovieListAll() throws Exception;
	
	//영화 상세 정보 
	public abstract MovieViewJoinResultVO mnMovieRead(String movie_num) throws Exception;


	//영화 등록 
	public abstract void mnMovieRegist(MovieViewJoinResultDTO dto) throws Exception;
	//영화 등록 - 파일 등록
	public abstract void mnFileRegist(MnMovieFileDTO dto) throws Exception;
	//영화 수정 - 파일 수정
	public abstract void mnFileUpdate(MnMovieFileDTO dto) throws Exception;
	
	//수정
	public abstract void mnMovieModify(MovieViewJoinResultDTO dto) throws Exception;
	// 기존에 테이블에 추가된 내용이 있는지 확인
	public abstract boolean checkExisted(String movie_num) throws Exception;
	
	
	//페이징 처리
	public abstract List<MovieViewJoinResultVO> mnMovieListPage(int page) throws Exception;
	
	public abstract List<MovieViewJoinResultVO>  mnMovieListCriteria(Criteria cri) throws Exception;
	
	public abstract int countPaging(Criteria cri) throws Exception;
	//페이징 처리
	




}  //end interface
