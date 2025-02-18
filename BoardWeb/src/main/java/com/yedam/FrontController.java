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
import com.yedam.control.BoardListControl;
import com.yedam.control.Control;

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
//		map.put("url", "servlet"); //addStudent.do AddstudentServlet
		map.put("/boardList.do", new BoardListControl());
		map.put("/addBoard.do", new AddBoardControl());

	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// System.out.println("front control");
		// http://localhost:8080/BoardWeb/addStudent.do => url
		// /BoardWeb/addStudent.do => uri

		String uri = req.getRequestURI();
		String context = req.getContextPath(); // "/BoardWeb"
		String page = uri.substring(context.length());

		System.out.println(page);
		// map 에서 키를 입렧하면 val 반환
		Control control = map.get(page); // control 객체를 받아옴
		control.exec(req, resp); // 글목록 콘솔에 뜸

	}

}
