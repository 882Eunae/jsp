package com.yedam.control;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yedam.common.DataSource;
import com.yedam.mapper.ReplyMapper;

public class InsertControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		resp.setContentType("text/json;charset=utf-8");
		
		String title=req.getParameter("title"); 
		String start=req.getParameter("start"); 
		String end=req.getParameter("end"); 
		
		SqlSession sqlSession = DataSource.getInstance().openSession();
		ReplyMapper mapper = sqlSession.getMapper(ReplyMapper.class);
		
	int run=mapper.insertEvent(title, start, end); 
		Map<String,Object> result=new HashMap<>(); 
		
		if(run>0) {
			result.put("retCode", "OK"); 
			result.put("retVal", title); 
			sqlSession.commit(true);
		}else {
			result.put("retCode", "NG"); 
		}
		Gson gson=new GsonBuilder().create();
		String json=gson.toJson(result);
		resp.getWriter().print(json);
	}
}
