package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddFormControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		// 글등록화면 요청 재지정 
		req.getRequestDispatcher("/WEB-INF/views/addForm.jsp").forward(req, resp);
	}

}
