package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yedam.dao.BoardDAO;
import com.yedam.vo.BoardVO;

public class ModifyControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		
		// 수정화면 open  화면 열어주는것 상세화면과 동일 
		String bno=req.getParameter("bno"); 
		
		BoardDAO bdao=new BoardDAO(); 
		BoardVO board=bdao.getBoard(Integer.parseInt(bno));  
		
		//세션 아이디 vs 글작성 아이디. 
		HttpSession session=req.getSession();
		String sessionId=(String) session.getAttribute("loginId"); 
		String writerId=board.getWriter();
		if(!sessionId.equals(writerId)) {
			req.setAttribute("msg", "권한을 확인하세요");
			req.setAttribute("board", board);
			req.getRequestDispatcher("/WEB-INF/views/board.jsp").forward(req, resp);
			
			return; //아래쪽으로 더이상 진행되면 안됨 종료
		}
		
		req.setAttribute("board", board);
		req.getRequestDispatcher("/WEB-INF/views/modifyBoard.jsp").forward(req, resp); 
		
		
		
	}

}
