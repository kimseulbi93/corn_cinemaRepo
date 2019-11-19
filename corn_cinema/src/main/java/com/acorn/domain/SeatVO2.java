package com.acorn.domain;

public class SeatVO2 {
	private String seat_num;
	private String status;

	public String getSeat_num() {
		return seat_num;
	}

	public void setSeat_num(String seat_num) {
		this.seat_num = seat_num;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public SeatVO2(String seat_num, String status) {
		this.seat_num = seat_num;
		this.status = status;
	}

	@Override
	public String toString() {
		return "{\"seat_num\" :" + "\"" + seat_num + "\"" + ", \"status\" :" + "\"" + status + "\"" + "}";
//		return "{seat_num=" + seat_num + ", status=" + status + "}";
//		return "seat_num=" + seat_num + ", status=" + status ;
	}
}
