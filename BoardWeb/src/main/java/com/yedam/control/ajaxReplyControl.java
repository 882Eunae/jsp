package com.yedam.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yedam.common.DataSource;
import com.yedam.mapper.ReplyMapper;
import com.yedam.vo.ReplyVO;

public class ajaxReplyControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		
		// 누구의 댓글을 가져올건지 데이터 가져오기
		//ajax
		resp.setContentType("text/json;charset=utf-8");
		
		String who=req.getParameter("who");
		
		System.out.println("ajaxreplycontrol실행중....");
		
		SqlSession sqlSession = DataSource.getInstance().openSession();
		ReplyMapper mapper = sqlSession.getMapper(ReplyMapper.class);

		List<ReplyVO> ajaxReply = mapper.ajaxReply(who);

		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json = gson.toJson(ajaxReply);

		System.out.println(json);
		resp.getWriter().print(json);

	}

}
