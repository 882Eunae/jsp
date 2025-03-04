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
import com.yedam.control.AddDataControl;
import com.yedam.control.AddFormControl;
import com.yedam.control.AddMemberControl;
import com.yedam.control.AddReplyControl;
import com.yedam.control.AjaxControl;
import com.yedam.control.ApiControl;
import com.yedam.control.BoardControl;
import com.yedam.control.BoardListControl;
import com.yedam.control.CalDataControl;
import com.yedam.control.ChartControl;
import com.yedam.control.ChartData;
import com.yedam.control.Control;
import com.yedam.control.DataControl;
import com.yedam.control.DataTableControl;
import com.yedam.control.DeleteCalControl;
import com.yedam.control.FullControl;
import com.yedam.control.InsertControl;
import com.yedam.control.LoginControl;
import com.yedam.control.LogoutControl;
import com.yedam.control.MainControl;
import com.yedam.control.MemberListControl;
import com.yedam.control.ModifyBoardControl;
import com.yedam.control.ModifyControl;
import com.yedam.control.RemoveBoardControl;
import com.yedam.control.RemoveMemberControl;
import com.yedam.control.RemoveReplyControl;
import com.yedam.control.ReplyCount;
import com.yedam.control.ReplyListControl;
import com.yedam.control.TestControl;
import com.yedam.control.ajaxReplyControl;
import com.yedam.control.listreviewControl;
import com.yedam.control.managerControl;
import com.yedam.control.mapControl;
import com.yedam.control.practiceControl;
import com.yedam.control.reviewBoardControl;

/*
 * MVC에서 control 역할 
 * url 요청 -> 서블릿. 
 */
//@WebServlet("*.do")
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
		map.put("/login.do", new LoginControl()); // db 데이터 로그인처리
		map.put("/logout.do", new LogoutControl()); // 로그인처리
		
		map.put("/memberList.do", new MemberListControl()); //회원목록. 
		map.put("/testAjax.do", new AjaxControl());
		map.put("/testData.do", new DataControl());
		//회원삭제 
		map.put("/removeMember.do", new RemoveMemberControl()); 
		map.put("/addMember.do", new AddMemberControl()); 
		map.put("/addData.do", new AddDataControl()); 
		
		//댓글관련
		map.put("/replyList.do", new ReplyListControl());
		map.put("/addReply.do", new AddReplyControl());
		map.put("/removeReply.do", new RemoveReplyControl());
		map.put("/getReplyCnt.do", new ReplyCount());
		//관리자 댓글관리 페이지 이동 
		map.put("/manage.do", new managerControl());
		map.put("/ajaxReply.do", new ajaxReplyControl()); 	//관리자페이지에서 댓글 목록 가져오기 	
		//차트관련
		map.put("/chart.do", new ChartControl());
		map.put("/chartData.do", new ChartData());
		//datatable 관련
		map.put("/datatable.do",new DataTableControl()); 
		//full
		map.put("/full.do", new FullControl());
		map.put("/calData.do", new CalDataControl()); //달력 데이터 
		map.put("/insertEvent.do", new InsertControl());
		map.put("/deleteCalendar.do", new DeleteCalControl()); 
		
		map.put("/api.do", new ApiControl()); 
		
		map.put("/test.do", new TestControl());
		
		//연습... 
		map.put("/practice.do", new practiceControl()); 
		map.put("/listreview.do", new listreviewControl()); 
		map.put("/reviewBoard.do", new reviewBoardControl()); 
		//지도
		map.put("/map.do", new mapControl()); 
		
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// System.out.println("front control");
		// http://localhost:8080/BoardWeb/addStudent.do => url

		String uri = req.getRequestURI();// /BoardWeb/addStudent.do => uri
		String context = req.getContextPath(); // "/BoardWeb"
		String page = uri.substring(context.length()); 

		System.out.println(page); // 글목록 콘솔에 뜸
	
		
		// map 에서 키를 입렧하면 val 반환
		Control control = map.get(page); // control 객체를 받아옴 boardListControl객체를 받아옴
		control.exec(req, resp); 
		
	}
}
