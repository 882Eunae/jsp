package com.yedam.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.yedam.common.SearchVO;
import com.yedam.vo.BoardVO;
import com.yedam.vo.ReplyVO;
import com.yedam.vo.ReviewVO;

public interface ReplyMapper {

	public int replyCount(int boardNo); //

	public List<ReplyVO> replyList(@Param("boardNo") int boardNo, @Param("page") int page);

	public List<ReplyVO> replyListAll(int boardNo);

	public ReplyVO selectReply(int replyNo); //

	public int insertReply(ReplyVO reply); //

	public int deleteReply(int replyNo); //

	public List<Map<String, Object>> fullData(); // 조회

	public int insertEvent(@Param("title") String title, @Param("start") String start, @Param("end") String end);

	public int deleteCalendar(@Param("title") String title, @Param("start") String start, @Param("end") String end);

	// 관리자 페이지 댓글조회
	public List<ReplyVO> ajaxReply(String who);
	//테스트 연습중... 게시판 글 목록 
	public List<ReviewVO> reviewList(); 
	public ReviewVO reviewBoard(int rno); 
	
	
	
}
