package com.yedam.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yedam.vo.BoardVO;

/*
 * 추가,수정,삭제,조회 
 * Create,Read,Update,Delete 
 */
public class BoardDAO extends DAO {
	
	//글조회수 증가 
	public void updateCount(int boardNo) {
		String sql="update tbl_board"
				+ " set    view_cnt = view_cnt + 1"
				+ " where board_no = ?"; 
		try {
			psmt=getConnect().prepareStatement(sql); 
			psmt.setInt(1, boardNo);
			psmt.executeUpdate(); //쿼리실행
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	
	//상세조회. 글번호 => 전체 정보 반환 
	public BoardVO getBoard(int boardNo) {
		String sql="select board_no"
				+"        ,title"
				+"        ,content"
				+"        ,writer"
				+"        ,write_date"
				+"        ,view_cnt"
				+"  from tbl_board"
				+"  where board_no = ?"; 
		try {
			psmt=getConnect().prepareStatement(sql);
			psmt.setInt(1, boardNo);
			rs=psmt.executeQuery(); 
			//조회결과 존재하면... 
			if(rs.next()) {
				BoardVO board=new BoardVO(); 
				board.setBoardNo(rs.getInt("board_no"));
				board.setTitle(rs.getString("title"));
				board.setContent(rs.getString("content"));
				board.setWriter(rs.getString("writer"));
				board.setWriteDate(rs.getDate("write_date"));
				board.setViewCnt(rs.getInt("view_cnt"));
				//결과반환 
				return board; 
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null; //조회결과 없음 
	}//end of getBoard 
	
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
	String sql="insert into tbl_board (board_no, title, content, writer) "
			+"  values(board_seq.nextval,?,?,?)";
	try {
		psmt=getConnect().prepareStatement(sql);
		psmt.setString(1, board.getTitle());
		psmt.setString(2, board.getContent());
		psmt.setString(3, board.getWriter());
		
		int r=psmt.executeUpdate(); //insetr 
		if(r==1) {
			return true; //정상등록. 
		}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
	return false; //비정상 처리 
}




//수정 
	public boolean updateBoard(BoardVO board) {
		String sql="update tbl_board "
				+ "set title = ?"
				+ "    ,content = ? "
				+ "where board_no = ?"; 
	
		try {
			psmt=getConnect().prepareStatement(sql); 
			psmt.setString(1, board.getTitle());
			psmt.setString(2, board.getContent());
			psmt.setInt(3, board.getBoardNo());
			
		int r=psmt.executeUpdate(); //쿼리실행
			if(r>0)
				return true; //정상수정. 
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false; 
	}
	
	//삭제 
	public boolean deleteBoard(int boardNo) {
		
		
		return false; 
	}
	
	
}
