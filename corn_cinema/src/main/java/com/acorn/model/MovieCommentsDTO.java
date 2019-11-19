package com.acorn.model;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieCommentsDTO {
	
	private String id;
	private String movie_num;
	private String name;
	private String comment;
	private double score;
	private Date updatedate;
	
}  //MovieCommentsDTO
