package com.acorn.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MypageVO {


   private String reservation_num; 
   private String movie_start_time;
   private String title;
   private String local_info_dist;
   private String reservation_date;
   private String seat_location;
}// end class
