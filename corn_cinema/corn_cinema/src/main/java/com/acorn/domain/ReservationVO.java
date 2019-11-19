package com.acorn.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReservationVO {

   private String reservation_num;
   private String movie_num;
   private String id;
   private String screening_num;
   private String seat_location;
}// end class

