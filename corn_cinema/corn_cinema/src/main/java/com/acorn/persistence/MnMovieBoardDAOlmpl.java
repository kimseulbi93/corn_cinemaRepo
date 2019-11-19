package com.acorn.persistence;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.acorn.domain.Criteria;
import com.acorn.domain.MovieVO;
import com.acorn.domain.MovieViewJoinResultVO;
import com.acorn.domain.ViewVO;
import com.acorn.model.MnMovieFileDTO;
import com.acorn.model.MovieViewJoinResultDTO;

import lombok.extern.log4j.Log4j;
@Log4j
@Repository
public class MnMovieBoardDAOlmpl implements MnMovieBoardDAO {

	
	@Inject
	private SqlSession sqlSession;
	private static final String namespace="com.acorn.mapper.MnMovieBoardMapper";
	
	@Override
	public List<MovieViewJoinResultVO> mnMovieListAll() throws Exception {
		
		List<MovieViewJoinResultVO> list = sqlSession.selectList(namespace + ".mnMovieListAll");
		
		MovieVO movieVO = new MovieVO();
		List<ViewVO> movieViewList = new ArrayList<>();
		
	
		String movie_num = null;  //pk
		String title = null; //영화 제목
		String opening_day = null;	//영화 개봉일
		String closing_day = null; 
		Date registration_time = null; 
		Date modification_time = null;
		String film_rate = null;	//관람등급
		String running_time = null;	//상영시간
		double avg_score = 0.0;	// 영화별 평점
		String view_path = null;
		
		int recordNum = 0;
		
		for(MovieViewJoinResultVO vo : list) {
			++recordNum;
			
			if(recordNum == 1) {
				movieVO.setMovie_num(movie_num);
				movieVO.setTitle(title);
				movieVO.setOpening_day(opening_day);
				movieVO.setClosing_day(closing_day);
				movieVO.setRegistration_time(registration_time);
				movieVO.setModification_time(modification_time);
				movieVO.setFilm_rate(film_rate);
				movieVO.setRunning_time(running_time);
				movieVO.setAvg_score(avg_score);
			}
			
			ViewVO viewVO = new ViewVO();
			viewVO.setMovie_num(movie_num);
			viewVO.setView_path(view_path);
			
			movieViewList.add(viewVO);
		}
		
		movieVO.setList(movieViewList);
		
		return list;
	}  //movieList

	
	/* 영화 상세 정보 */
	@Override
	public MovieViewJoinResultVO mnMovieRead(String movie_num) throws Exception {
		
		return sqlSession.selectOne(namespace + ".mnMovieDetail", movie_num);
	}
	
	
	
	
	/* 영화 등록 */
	@Override
	public void mnMovieRegist(MovieViewJoinResultDTO dto) throws Exception {
		sqlSession.insert(namespace + ".mnMovieCreate", dto);
		
	}
	
	/* 영화 등록 -파일 첨부*/
	@Override
	public void mnFileRegist(MnMovieFileDTO dto) throws Exception {
		sqlSession.insert(namespace + ".mnMovieFileInsert", dto); 
		
	}
	
	/* 영화 수정 -파일 첨부*/
	@Override
	public void mnFileUpdate(MnMovieFileDTO dto) throws Exception {
		sqlSession.update(namespace + ".mnMovieFileUpdate", dto);
	}

	// 관리자 페이지 수정 
	
	@Override
	public void mnMovieModify(MovieViewJoinResultDTO dto) throws Exception {
		
		log.info("updateProfile invoked");
		System.out.println(dto.toString());
		
	    sqlSession.update(namespace+".mnMovieUpdate", dto);
		
	}
	
	@Override
	public boolean checkExisted(String movie_num) throws Exception {
		
		log.info("check file is existed in table");
		log.info("movie_num: " + movie_num);
		
		int num = sqlSession.selectOne(namespace + ".mnMovieFileCount", movie_num);
		
		System.out.println("========================================================");
		System.out.println("num: " + num);
		System.out.println("========================================================");
		
		if (num == 1) {
			return true;
		}
		
		return false;
	}
	
	/* -- 페이징 처리 */
	@Override
	public List<MovieViewJoinResultVO> mnMovieListPage(int page) throws Exception {
		if(page <= 0 ) {
			page = 1;
		} 
		page = (page -1) * 10;
		return sqlSession.selectList(namespace + ".mnMovieListPage", page);
	} //
	
	@Override
	public List<MovieViewJoinResultVO> mnMovieListCriteria(Criteria cri) throws Exception {
		
		return sqlSession.selectList(namespace + ".mnMovieListCriteria",  cri);
	}
	

	@Override
	public int countPaging(Criteria cri) throws Exception {
		
		return sqlSession.selectOne(namespace + ".mnMovieListCountPaging",cri);
	}  //countPaging 목록 데이터 총 개수 계산


	



	/* -- 페이징 처리 */
	

	



}
