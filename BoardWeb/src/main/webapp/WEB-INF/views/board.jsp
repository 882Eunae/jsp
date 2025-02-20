<%@page import="com.yedam.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="includes/header.jsp"></jsp:include>

<%
BoardVO board=(BoardVO)request.getAttribute("board"); 
String msg=(String) request.getAttribute("msg"); 
String logId=(String) session.getAttribute("loginId"); 
%>
<h3>상세화면(board.jsp])
</h3>
<form action="modifyForm.do">
<input type="hidden" name="bno" value="<%=board.getBoardNo() %>">
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
<th>내용</th>
<td colspan="3"><%=board.getTitle()%></td>
</tr>


<tr>
<th>작성자</th>
<td><%=board.getWriter() %></td>
</tr>
<tr>
<td colspan="3" align="center">
<button class="btn btn-warning" type="submit">수정</button>
<button class="btn btn-danger" type="button">삭제</button>

</td>

<tr>
<%if(msg !=null){ %>
<td><span style="color:red;"><%=msg%></span></td>
<%} %>
</tr>
</table>
</form>
<script>
let logid="<%=logId%>";
  //삭제버튼에 클릭 이벤트 등록.
  
 document.querySelector('button.btn-danger').addEventListener('click',function(e){
	 let writer=document.querySelector('table.table>tbody>tr:nth-of-type(4)>td').innerHTML; 
	 let bno=document.querySelector('input[name="bno"]').value;
	 if(writer==logid)
	 location.href="removeBoard.do?bno="+bno;
	 else
		 alert("권한을 확인하세요"); 
	 
	
	 location.href="removeBoard.do?bno="+bno; 
	 
 });
</script>

<jsp:include page="includes/footer.jsp"></jsp:include>