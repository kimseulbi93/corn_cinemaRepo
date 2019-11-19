package com.acorn.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Value
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingDTO {
	
	private String movieNum;
	private String infoCity;
	private String infoDist;
	private String startTime;
	

}
