package com.acorn.domain;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ScreeningVO {
		 
	private int screening_num;
	private int cinema_num;
	private String movie_num;
	private Timestamp movie_start_time;
	private Timestamp movie_end_time;
	private int reserved_seat_num;
	private int is_screening;
	
}
