package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		HttpSession session=req.getSession(); //jsessionid 쿠키.
		session.invalidate(); //서버에 존재하는 세션삭제 
		
		resp.sendRedirect("main.do"); //로그인화면으로 다시 돌아감 
		
		
	}

}
