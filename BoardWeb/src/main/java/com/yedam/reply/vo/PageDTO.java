package com.yedam.reply.vo;

import lombok.Data;

public class PageDTO { //댓글 페이지 쪽수?
	
	//필드 선언
	private int currPage;
	private int totalCnt;
	private boolean prev, next; //이전페이지가 있/없?
	private int startPage, lastPage;
	
	//생성자 : 전체 건수와 현재 페이지 2개를 매개값으로 받음
	public PageDTO(int page, int totalCnt) {
		this.currPage = page;
		this.totalCnt = totalCnt;
		
		//이전 페이지 여부, 첫페이지, 마지막페이지, 이후페이지 여부
		//전체 건수가 70건이면 14페이지
		int realLast = (int) Math.ceil(totalCnt / 5.0); //마지막페이지
		this.lastPage = (int) Math.ceil(page/5.0) * 5; //5개씩 보여줄거니까
		this.startPage = this.lastPage - 4;
		this.lastPage = this.lastPage > realLast ? realLast : this.lastPage;
		this.prev = this.startPage > 1;
		this.next = this.lastPage < realLast;
	}
	

	@Override
	public String toString() {
		return "PageDTO [currPage=" + currPage + ", totalCnt=" + totalCnt + ", prev=" + prev + ", next=" + next
				+ ", startPage=" + startPage + ", lastPage=" + lastPage + "]";
	}

}
