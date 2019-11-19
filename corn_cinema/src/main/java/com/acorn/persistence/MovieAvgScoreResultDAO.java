package com.acorn.persistence;

import java.util.List;

import com.acorn.domain.MemberReplyJoinResultVO;
import com.acorn.domain.MovieAvgScoreResultVO;
import com.acorn.domain.MovieViewJoinResultVO;

public interface MovieAvgScoreResultDAO {

	//총 평점 업데이트
	public abstract void replyScoreUpdate(MovieAvgScoreResultVO vo) throws Exception;

	//평점 출력
	public abstract MovieAvgScoreResultVO replyScoreSelect(String movie_num) throws Exception;
}
