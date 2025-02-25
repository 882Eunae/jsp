package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.dao.MemberDAO;
import com.yedam.vo.MemberVO;

public class AddMemberControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		
		// param(아이디,비밀번호,이름)
		String id = req.getParameter("mid");
		String pw = req.getParameter("mpw");
		String name = req.getParameter("mname");

		MemberDAO mdao = new MemberDAO(); // 추가메소드 (boolean insertMember(MemberVO member)).
		MemberVO member = new MemberVO();
	    member.setMemberId(id);
	    member.setPasswd(pw);
	    member.setMemberName(name);
	   
		boolean isOk=mdao.insertMember(member); 
		
		
//		String json="[";
//		json+="{\"memberId\":\""+member.getMemberId()
//		+"\", \"passwd\":\""+member.getPasswd()
//		+"\", \"memberName\":\""+member.getMemberName()
//		+	"\", \"responsibility\":\""+member.getResponsibility()
//		+"\"}";
//		
//		json+="]";
//		//json형태 출력 
//		resp.getWriter().print(json);
		
		if(isOk) {
			//{"retCode":"OK"}	
			resp.getWriter().print("{\"retCode\":\"OK\"}");	
			}else {//{"retCode":"NG"}	
				resp.getWriter().print("{\"retCode\":\"NG\"}");	
			}
		
		
		
		

	}

}
