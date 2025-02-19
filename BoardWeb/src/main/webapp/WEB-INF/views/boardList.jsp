<%@page import="com.yedam.vo.BoardVO"%>
<%@page import="com.yedam.vo.Employee"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="includes/header.jsp"></jsp:include>
	<!-- html 주석문. -->
	<%
	String msg = "Hello"; 
	//boardList.do -> request -> boardList.jsp
	String result = (String) request.getAttribute("msg");
	List<BoardVO> list = (List<BoardVO>) request.getAttribute("list");
	%>
	<p>
		
		<%=result%></p>
	<h3>반복문</h3>
	<h2>게시글목록</h2>
	<table class="table table-striped" border="2">
	<thead>
	<th>글번호</th>
	<th>제목</th>
	<th>작성자</th>
	<th>작성일자</th>
	<th>내용</th>
	<th>조회수</th>
	
	
	</thead>
	
	<tbody>	<%
	for (BoardVO bvo : list) {
	%>
	
	<tr>
	<td><%=bvo.getBoardNo() %></td>
	<td><a href="board.do?bno=<%=bvo.getBoardNo() %>"><%=bvo.getTitle()%></a></td>
	<td><%=bvo.getWriter() %></td>
	<td><%=bvo.getWriteDate()%></td>
	<td><%=bvo.getContent() %></td>
	<td><%=bvo.getViewCnt() %></td>
	</tr>
	<%
	}
	 %></tbody>

	</table>
<jsp:include page="includes/footer.jsp"></jsp:include>