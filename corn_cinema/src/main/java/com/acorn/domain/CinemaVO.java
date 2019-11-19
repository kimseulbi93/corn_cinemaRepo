package com.acorn.domain;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CinemaVO {
	
	private int cinema_num;
	private String local_info_city;
	private String local_info_dist;
	private String total_seat;	

}
