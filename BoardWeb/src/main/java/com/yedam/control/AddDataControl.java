package com.yedam.control;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yedam.dao.MemberDAO;
import com.yedam.vo.MemberVO;

public class AddDataControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		//전달값 받아오기
		String id=req.getParameter("mid");
		String pw=req.getParameter("mpw");
		String name=req.getParameter("mname");
		
		System.out.println("ajax 잘넘어갔는지확인"+id+pw+name); //testAjax 파일에서 파라미터를 받아오지 못함 

		//dao 
		MemberDAO mdao=new MemberDAO(); 
		MemberVO mvo=new MemberVO();
		//객체생성
		mvo.setMemberId(id);
		mvo.setPasswd(pw);
		mvo.setMemberName(name);
		//등록하기
		boolean run=mdao.insertMember(mvo); 
		
	Map<String,Object> result=new HashMap<>(); 
		if(run) {
			result.put("retCode", "ok"); 
			result.put("retVal", mvo); 
		}else {
			result.put("retCode", "NG");
		}
		//자바 스크립트 fetch 함수로 전달 
		Gson gson=new GsonBuilder().create();
		String json=gson.toJson(result);
		resp.getWriter().print(json);
		
	}

}
