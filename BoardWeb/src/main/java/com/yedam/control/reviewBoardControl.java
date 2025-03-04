package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DataSource;
import com.yedam.mapper.ReplyMapper;
import com.yedam.vo.ReviewVO;

public class reviewBoardControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

		SqlSession sqlSession=DataSource.getInstance().openSession(); 
		ReplyMapper mapper=sqlSession.getMapper(ReplyMapper.class); 
		
		String rno=req.getParameter("rno"); 
		ReviewVO review=mapper.reviewBoard(Integer.parseInt(rno)); 
		
		req.setAttribute("reviewInfo", review);
		
		req.getRequestDispatcher("admin/reviewBoard.tiles").forward(req, resp); 
		
	}

}
