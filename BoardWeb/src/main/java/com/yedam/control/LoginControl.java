package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.yedam.common.DataSource;
import com.yedam.dao.MemberDAO;
import com.yedam.mapper.BoardMapper;
import com.yedam.vo.MemberVO;

public class LoginControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		// 요청방식 (get/post)
		if (req.getMethod().equals("GET")) {
			// 1.로그인 화면. jsp파일
			req.getRequestDispatcher("/WEB-INF/views/member/login.jsp").forward(req, resp);

		} else if (req.getMethod().equals("POST")) {
			// 2.로그인기능
			String id = req.getParameter("uname"); // jsp파일에서 input태그에ㅔ서 받아옴
			String pw = req.getParameter("psw");		
			// 로그인체크
			SqlSession sqlSession=DataSource.getInstance().openSession(); 
			BoardMapper mapper=sqlSession.getMapper(BoardMapper.class); 
			
			//MemberDAO mdao = new MemberDAO();
			MemberVO mvo = mapper.login(id, pw); //맴버객체 반환 
			
			if (mvo != null) {
				System.out.println("환영합니다" + mvo.getMemberName());
				// 세션 객체에 로그인 아이디를 저장
				HttpSession session = req.getSession();
				session.setAttribute("loginId", id); // attribute활용 ->mvo의 id파라미터를 loginId에 받음
				//일반사용자 or 관리자 
				if(mvo.getResponsibility().equals("Admin")) {
					//성공적으로 하면 목록화면으로 감 
					resp.sendRedirect("memberList.do");
				}
				else { 
				resp.sendRedirect("boardList.do");
				}
			} else {
				System.out.println("id,pw 확인");
			}

		}

	}

}
