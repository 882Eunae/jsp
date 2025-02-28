package com.yedam.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.yedam.common.SearchVO;
import com.yedam.vo.BoardVO;
import com.yedam.vo.ReplyVO;

public interface ReplyMapper {
	
	public int replyCount(int boardNo); //
	public List<ReplyVO> replyList(@Param("boardNo") int boardNo,@Param("page") int page);
	public List<ReplyVO> replyListAll(int boardNo);
	public ReplyVO selectReply(int replyNo); //

	public int insertReply(ReplyVO reply); //
	public int deleteReply(int replyNo); //
	
	public List<Map<String,Object>> fullData(); //조회
	public int insertEvent(@Param("title") String title,
			@Param("start") String start,
			@Param("end") String end); 
}
