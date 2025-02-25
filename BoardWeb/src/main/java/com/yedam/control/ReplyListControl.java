package com.yedam.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yedam.dao.ReplyDAO;
import com.yedam.vo.ReplyVO;

public class ReplyListControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		resp.setContentType("text/json;charset=utf-8"); //json문자열을  만들어줌
		//원본글 번호
		String bno=req.getParameter("bno"); 
		//dao활용
		ReplyDAO rdao=new ReplyDAO(); 
		List<ReplyVO> list=rdao.replyList(Integer.parseInt(bno)); 
		Gson gson=new GsonBuilder().setPrettyPrinting().create(); //gson 활용 
		String json=gson.toJson(list); //자바객체 -> json 문자열 
		
		System.out.println(json); //콘솔 
		resp.getWriter().print(json); //웹브라우저 
		

	}

}
