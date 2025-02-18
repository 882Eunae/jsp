package com.yedam.serv;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.dao.StudentDAO;
import com.yedam.vo.Student;
@WebServlet("/addStuServlet")
public class AddStudentServlet extends HttpServlet {

	//param의 값을 활용 -> db 입력 
	//처리성공 /처리실패 메시지 
	protected void service(HttpServletRequest req,HttpServletResponse resp) throws IOException {
		req.setCharacterEncoding("utf-8"); //요청정보의 한글처리 
		resp.setContentType("text/html;charset=utf-8");
		//get방식요청 
		String sno=req.getParameter("std_no"); 
		String sname=req.getParameter("std_name"); 
		String tel=req.getParameter("tel_no"); 
		String addr=req.getParameter("std_addr");
		
		//db등록 
		StudentDAO sdao=new StudentDAO(); 
		boolean result=sdao.addStudent(new Student(sno,sname,tel,addr));
		
		if(result) {
			resp.getWriter().print("학생처리성공"); 
			
		}
		else {
			resp.getWriter().print("학생처리 실패"); 
		}
		
	}
	
	
	
	
	
	
}
