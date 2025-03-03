package com.yedam.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yedam.common.SearchVO;
import com.yedam.vo.BoardVO;
import com.yedam.vo.MemberVO;

public interface BoardMapper {
	public int getTotalCount(SearchVO search);
	public int updateCount(int boardNo);
	public BoardVO getBoard(int boardNo);
	public List<BoardVO> selectBoard(SearchVO search);
	public int insertBoard(BoardVO board);
	public int updateBoard(BoardVO board);
	public int deleteBoard(int boardNo);
	public MemberVO login(@Param("id")String id ,@Param("pw") String pw ); 
}
