package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.dao.BoardDAO;
import com.yedam.vo.BoardVO;

public class ModifyBoardControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
//		// 수정화면 open 
//		String bno=req.getParameter("bno"); 
//		BoardDAO bdao=new BoardDAO(); 
//		BoardVO board=bdao.getBoard(Integer.parseInt(bno));  
//		req.setAttribute("board", board);
//		req.getRequestDispatcher("/WEB-INF/views/modifyBoard.jsp").forward(req, resp); 
		
		//BoardWeb/modifyBoard.do?bno=6&title=%EB%91%90%EB%B2%88%EC%A7%B8%EA%B8%80&content=%EC%88%98%EC%A0%95
		
		String bno=req.getParameter("bno"); 
		String title=req.getParameter("title"); 
		String content=req.getParameter("content"); 
		
		BoardVO board=new BoardVO(); 
		board.setBoardNo(Integer.parseInt(bno));
		board.setTitle(title);
		board.setContent(content);
		
		BoardDAO bdao=new BoardDAO(); 
		//수정하고 난후 
	if(	bdao.updateBoard(board)) 
	{
		resp.sendRedirect("boardList.do");
	}else {
		System.out.println("처리실패");
	}
		
		
	}

}
