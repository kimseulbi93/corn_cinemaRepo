package com.acorn.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieScreeningDTO {

	private String movie_num;
	private String title;
	private Date opening_day;
	private String film_rate;
	private String running_time;
	private double avg_score;
	
	//현재 상영작 표시를 위한 DTO 작성
	
}
