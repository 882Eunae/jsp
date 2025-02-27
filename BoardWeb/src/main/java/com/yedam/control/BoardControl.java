package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DataSource;
import com.yedam.dao.BoardDAO;
import com.yedam.mapper.BoardMapper;
import com.yedam.vo.BoardVO;

public class BoardControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		SqlSession sqlSession=DataSource.getInstance().openSession(); 
		BoardMapper mapper=sqlSession.getMapper(BoardMapper.class); 
		
		String bno=req.getParameter("bno"); 
		BoardVO board=mapper.getBoard(Integer.parseInt(bno)); //문자열 "14" - > int 14 변경 
		mapper.updateCount(Integer.parseInt(bno)); //조회수 증가. 
		//상세화면  요청정보의 attribute 활용 
		req.setAttribute("board", board); // 
		req.getRequestDispatcher("board/board.tiles").forward(req, resp); 
		
	}

}
