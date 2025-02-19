package com.yedam.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yedam.vo.BoardVO;
import com.yedam.vo.Student;

/*
 * 추가,수정,삭제,조회 
 * Create,Read,Update,Delete 
 */
public class BoardDAO extends DAO {
//조회 
public List<BoardVO> selectBoard(){
	List<BoardVO> boardList=new ArrayList<>();
	String qry="select * from tbl_board "+
	"order by board_no"; 
	
	try {
		
		psmt=getConnect().prepareStatement(qry);
		rs=psmt.executeQuery(); 
		while(rs.next()) {
			BoardVO bd=new BoardVO();
			bd.setBoardNo(rs.getInt("board_no"));
			bd.setTitle(rs.getString("title"));
			bd.setContent(rs.getString("content"));
			bd.setViewCnt(rs.getInt("view_cnt"));
			bd.setWriteDate(rs.getDate("write_date"));
			bd.setWriter(rs.getString("writer"));
			
			boardList.add(bd); 
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return boardList; 
}
	
//추가 
public boolean insertBoard(BoardVO board) {
	String sql="insert into tbl_board "; 
				
	
	
	
	return false; 
}




//수정 
	public boolean updateBoard(BoardVO board) {
		
		return false; 
	}
	
	//삭제 
	public boolean deleteBoard(int boardNo) {
		
		
		return false; 
	}
	
	
}
