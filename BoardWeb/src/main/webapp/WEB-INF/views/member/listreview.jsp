<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h3>listreview</h3>


<tbody>
	<c:forEach var="review" items="${rlist }">
		<tr>
			<td><c:out value="${review.review_no }"></c:out></td>
			<td>
			  <a href="reviewBoard.do?rno=${review.review_no }"> 
			     <c:out	value="${review.title }"></c:out></a>
			</td>
			<td><c:out value="${review.content }"></c:out></td>
		</tr>
	</c:forEach>
</tbody>

