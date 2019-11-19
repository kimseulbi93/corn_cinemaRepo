package com.acorn.service;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import com.acorn.domain.MemberReplyJoinResultVO;
import com.acorn.persistence.MovieAvgScoreResultDAO;
import com.acorn.persistence.ReplyDAO;

import lombok.extern.log4j.Log4j;

@Log4j
@Service
public class ReplyServiceImpl implements ReplyService {

	
	@Inject
	ReplyDAO dao;
	
	@Inject
	MovieAvgScoreResultDAO avgscoredao;
	
	@Inject
	SqlSession sqlSession;
	
	//댓글정보 서비스
	
	@Override
	public List<MemberReplyJoinResultVO> replyList(String movie_num) throws Exception {
		
	
//		avgscoredao.replyScoreList(movie_num);
		
	      
		return dao.replyList(movie_num);
	}  //replyList

	@Override
	public void replyCreate(MemberReplyJoinResultVO vo) throws Exception {

		 dao.replyCreate(vo);

	}  //replyCreate

	@Override
	public void replyUpdate(MemberReplyJoinResultVO vo) throws Exception {
		
		dao.replyUpdate(vo);

	}  //replyUpdate

	@Override
	public int replyDelete(String id) throws Exception {
		 return dao.replyDelete(id);
	}  //replyDelete

}
