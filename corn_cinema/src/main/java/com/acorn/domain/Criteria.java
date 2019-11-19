package com.acorn.domain;

public class Criteria {

	private int page;
	private int perPageNum;
	
	public Criteria() {
		this.page = 1;
		this.perPageNum = 3;
	}
	
	public void setPage(int page) {
		if(page <= 0 ) {
			this.page = 1;
			return;
		}
		this.page = page;
	}  //setPage
	
	public void setPerPageNum(int perPageNum) {
		if(perPageNum <= 0 || perPageNum > 100) {
			this.perPageNum = 10;
			return;
		}
		this.perPageNum = perPageNum;
	}  //setprePageNum
	
	public int getPage() {
		return page;
	}  //getPage
	
	public int getPageStart() {
		return (this.page -1 ) * perPageNum;
	}  //getPageStart
	
	public int getPerPageNum() {
		return this.perPageNum;
	}// getPerPageNum
	
	@Override
	public String toString() {
		return "Criteria [page=" + page + "," + "perPageNum=" + perPageNum + "]";
	}  //toString
	
}  //end class
