package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.dao.BoardDAO;
import com.yedam.vo.BoardVO;

public class AddBoardControl implements Control {

	@Override
	public void exec(HttpServletRequest req,HttpServletResponse resp)
			 throws IOException, ServletException{
		//3개 파라미터 활용 db 저장 . 목록으로 이동 
		String title=req.getParameter("title"); 
		String content=req.getParameter("content"); 
		String writer=req.getParameter("writer"); 
		
		//매개값으로 활용 
		BoardVO bvo=new BoardVO(); 
		bvo.setTitle(title);
		bvo.setContent(content);
		bvo.setWriter(writer);
		
		
		BoardDAO bdao=new BoardDAO(); 
	if(	bdao.insertBoard(bvo)) {
		resp.sendRedirect("boardList.do");
	} else {
		System.out.println("실패.");
	}
		
		

	}

}
