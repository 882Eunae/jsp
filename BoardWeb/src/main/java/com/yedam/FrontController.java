package com.yedam;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.control.AddBoardControl;
import com.yedam.control.AddFormControl;
import com.yedam.control.BoardControl;
import com.yedam.control.BoardListControl;
import com.yedam.control.Control;
import com.yedam.control.LoginControl;
import com.yedam.control.LogoutControl;
import com.yedam.control.MainControl;

import com.yedam.control.ModifyBoardControl;
import com.yedam.control.ModifyControl;
import com.yedam.control.RemoveBoardControl;

/*
 * MVC에서 control 역할 
 * url 요청 -> 서블릿. 
 */
@WebServlet("*.do")
public class FrontController extends HttpServlet {
	Map<String, Control> map;

	public FrontController() {
		map = new HashMap<>(); // map 필드의 초기화
	}

	@Override
	public void init() throws ServletException {
		map.put("/main.do", new MainControl());
		map.put("/boardList.do", new BoardListControl());
		map.put("/addBoard.do", new AddBoardControl()); // 등록처리
		map.put("/addForm.do", new AddFormControl()); // 등록화면...
		map.put("/board.do", new BoardControl());
		map.put("/modifyForm.do", new ModifyControl()); // 수정화면 화면만
		map.put("/modifyBoard.do", new ModifyBoardControl());
		// 삭제화면,삭제처리
		map.put("/removeBoard.do", new RemoveBoardControl());

		map.put("/loginForm.do", new LoginControl()); // 로그인 화면
		map.put("/login.do", new LoginControl()); // 로그인처리
		map.put("/logout.do", new LogoutControl()); // 로그인처리
		
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// System.out.println("front control");
		// http://localhost:8080/BoardWeb/addStudent.do => url

		String uri = req.getRequestURI();// /BoardWeb/addStudent.do => uri
		String context = req.getContextPath(); // "/BoardWeb"
		String page = uri.substring(context.length());

		System.out.println(page);
		// map 에서 키를 입렧하면 val 반환
		Control control = map.get(page); // control 객체를 받아옴 boardListControl객체를 받아옴
		control.exec(req, resp); // 글목록 콘솔에 뜸

	}

}
