package com.acorn.domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieAvgScoreResultVO {

	
	private String movie_num;  //pk
	private double avg_score;	// 영화별 평점
	
	private String id;
	private int score;

}
