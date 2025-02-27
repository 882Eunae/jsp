package com.yedam.control;

import java.io.IOException;
import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.map.HashedMap;
import org.apache.ibatis.session.SqlSession;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yedam.common.DataSource;
import com.yedam.dao.ReplyDAO;
import com.yedam.mapper.ReplyMapper;
import com.yedam.vo.ReplyVO;

public class AddReplyControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		resp.setContentType("text/json;charset=utf-8");
		
		//댓글내용 ,작성자 ,원본글번호 
		String reply=req.getParameter("reply");
		String replyer=req.getParameter("replyer");
		String bno=req.getParameter("bno");
		
		//매개값
		ReplyVO rvo=new ReplyVO(); 
		rvo.setBoardNo(Integer.parseInt(bno));
		rvo.setReply(reply);
		rvo.setReplyer(replyer);
		rvo.setReplyDate(new java.util.Date());
		
		//DB 반영 
//		ReplyDAO rdao=new ReplyDAO(); 
//		boolean run=rdao.insertReply(rvo); 
		
		SqlSession sqlSession=DataSource.getInstance().openSession();
		ReplyMapper mapper=sqlSession.getMapper(ReplyMapper.class); 
		boolean run=mapper.insertReply(rvo) ==1 ; 
		
		//결과값 
		Map<String,Object> result=new HashMap<>(); 
		
		if(run) {
			//{"retCode":"OK"}
//			resp.getWriter().print("{\"retCode\":\"OK\"}");
			result.put("retCode", "OK"); 
			result.put("retVal", rvo); 
			sqlSession.commit(true);
			
		} else {
//			resp.getWriter().print("{\"retCode\":\"NG\"}");
			result.put("retCode", "NG"); 	
		}
		Gson gson=new GsonBuilder().create();
		String json=gson.toJson(result);
		
		resp.getWriter().print(json);
	}
}
