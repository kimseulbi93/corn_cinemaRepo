package com.acorn.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.acorn.domain.MovieAvgScoreResultVO;

import lombok.extern.log4j.Log4j;
@Log4j
@Repository
public class MovieAvgScoreResultDAOImpl implements MovieAvgScoreResultDAO {

	
	@Inject
	private SqlSession sqlSession;
	private static final String namespace="com.acorn.mapper.MovieAvgScoreResultMapper";
	
	@Override
	public void replyScoreUpdate(MovieAvgScoreResultVO vo) throws Exception {
		
		 sqlSession.update(namespace + ".scoreUpdate", vo);
	
	}  //replyScoreList

	@Override
	public MovieAvgScoreResultVO replyScoreSelect(String movie_num) throws Exception {
		
		return sqlSession.selectOne(namespace + ".scoreSelect", movie_num);
	}

}
