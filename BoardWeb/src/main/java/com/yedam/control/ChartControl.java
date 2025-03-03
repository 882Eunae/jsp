package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ChartControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
	//	req.getRequestDispatcher("chart/chart.tiles").forward(req, resp);
		System.out.println("컨트롤에 접근하였습니다");
		req.getRequestDispatcher("board/testForm.tiles").forward(req, resp); 
		
	}

}
