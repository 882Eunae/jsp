package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DataSource;
import com.yedam.dao.BoardDAO;
import com.yedam.mapper.BoardMapper;

public class RemoveBoardControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		// ?bno=22 삭제할 파라미터를 받아옴 
		String bno=req.getParameter("bno"); 
		
//		BoardDAO bdao=new BoardDAO(); 
		
		SqlSession sqlSession=DataSource.getInstance().openSession(); 
		BoardMapper mapper=sqlSession.getMapper(BoardMapper.class); 
		
		if(mapper.deleteBoard(Integer.parseInt(bno))==1) {
			//삭제가 잘되면 목록으로 이동 
			resp.sendRedirect("boardList.do");
			
		}else {
			System.out.println("처리실패");
		}
		
		
	}

}
