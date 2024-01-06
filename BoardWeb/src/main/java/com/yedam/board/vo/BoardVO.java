package com.yedam.board.vo;

import java.util.Date;

import lombok.Data;

@Data
public class BoardVO { //value를 담기 위한 object. sql 칼럼이랑 일치하게..
	private int boardNo;
	private String title;
	private String content;
	private String writer;
	private Date writeDate;
	private int clickCnt;
	private String image;
}
