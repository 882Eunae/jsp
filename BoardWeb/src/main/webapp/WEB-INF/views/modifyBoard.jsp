<%@page import="com.yedam.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="includes/header.jsp"></jsp:include>

<h3>상세화면(board.jsp])</h3>
<%
BoardVO board=(BoardVO)request.getAttribute("board"); 
%>
<table class="table"> 
<tr>
<th>글번호</th><td><%=board.getBoardNo() %></td>
<th>조회수</th><td><%=board.getViewCnt() %></td>
</tr>
<tr>
<th>내용</th>
<td colspan="3"><%=board.getContent() %></td>
</tr>
<tr>
<th>작성자</th>
<td><%=board.getWriter() %></td>
</tr>






</table>


<jsp:include page="includes/footer.jsp"></jsp:include>