package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.dao.BoardDAO;
import com.yedam.vo.BoardVO;

public class BoardControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		
		String bno=req.getParameter("bno"); 
		BoardDAO bdao=new BoardDAO(); 
		BoardVO board=bdao.getBoard(Integer.parseInt(bno)); //문자열 "14" - > int 14 변경 
		bdao.updateCount(Integer.parseInt(bno)); //조회수 증가. 
		//상세화면  요청정보의 attribute 활용 
		req.setAttribute("board", board); // 
		req.getRequestDispatcher("board/board.tiles").forward(req, resp); 
		
	}

}
