package com.acorn.domain;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReplyVO {

	private String id;
	private String movie_num;
	private String comment;
	private int score;
	private double avgscore;
	
	private String regdate;
	private String updatedate;

}
