package com.yedam.vo;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@ToString
public class BoardVO { //tbl_board 
	private int boardNo; //board_no 
	//title.... view_cnt 
	private String title; 
	private String content; 
	private String writer; 
	private Date writeDate; 
	private int viewCnt;
	private String img; 
	
}
