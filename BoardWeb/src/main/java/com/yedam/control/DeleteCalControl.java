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

public class DeleteCalControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

		resp.setContentType("text/json;charset=utf-8");

		String title = req.getParameter("title");
		String end = req.getParameter("end");
		String start = req.getParameter("start");

		SqlSession sqlSession = DataSource.getInstance().openSession();
		ReplyMapper mapper = sqlSession.getMapper(ReplyMapper.class);

		int delete = mapper.deleteCalendar(title,start,end);
		Map<String, String> result = new HashMap<>();

		if (delete > 0) { 
			result.put("retCode", "OK"); 
			sqlSession.commit(true);
		} else {
			result.put("retCode", "NG");
		}
		Gson gson = new GsonBuilder().create();
		String json = gson.toJson(result);
		resp.getWriter().print(json);

	}

}
