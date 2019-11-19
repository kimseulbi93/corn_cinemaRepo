package com.acorn.domain;

import java.util.ArrayList;
import java.util.List;


public class SeatInfo {

	
	List<SeatVO2> list = new ArrayList<>();
	
	public void setList(List<SeatVO2> list) {
		this.list = list;
	}

	public void addSeatVO2(SeatVO2 vo) {
		list.add(vo);
	}

	@Override
	public String toString() {
		return list.toString();
	}

	public List<SeatVO2> getList() {
		return list;
	}
	
}
