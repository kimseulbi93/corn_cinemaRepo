package com.acorn.domain;

import java.sql.Date;
import java.util.List;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ViewVO {

	private String movie_num;  //FK
	private String view_path;  //파일 경로
	private String view_name_key;  // 파일 암호키
	private String view_name;   //실제 파일 명
	 
	private Date view_registration_time; //등록 시간
	private Date view_modification_time;  //수정 시간
	
}
