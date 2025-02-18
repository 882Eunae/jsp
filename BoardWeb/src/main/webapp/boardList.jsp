<%@page import="com.yedam.vo.BoardVO"%>
<%@page import="com.yedam.vo.Employee"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
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
	<table border="2">
	<%
	for (BoardVO bvo : list) {
	%>
	
	<tr>
	<td><%=bvo.getBoardNo() %></td>
	<td><%=bvo.getTitle() %></td>
	<td><%=bvo.getWriter() %></td>
	<td><%=bvo.getContent() %></td>
	</tr>
	<%
	}
	 %>
	</table>
</body>
</html>