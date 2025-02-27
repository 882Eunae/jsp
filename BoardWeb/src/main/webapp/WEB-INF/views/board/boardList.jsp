<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!-- html 주석문. -->




<h2>게시글목록</h2>
<form action="boardList.do">
	<div class="center">
		<div class="row">
			<div class="col-sm-4">
				<select class="form-control" name="searchCondition">
					<option value="">선택하세요</option>
					<option value="T" ${searchCondition =="T" ? "selected":"" }>제목</option>
					<option value="W"${searchCondition =="W" ? "selected":"" }>작성자</option>
					<option value="TW"${searchCondition =="TW" ? "selected":"" }>제목&작성자</option>
				</select>
			</div>
			<div class="col-sm-5">
				<input type="text" class="form-control" name="keyword" value="${keyword }" >
			</div>
			<div class="col-sm-2">
				<input class="btn-btn-button" type="submit" value="조회" class="form-control">
			</div>
		</div>
	</div>
</form>
<table class="table table-striped" border="2">
	<thead>
		<th>글번호</th>
		<th>제목</th>
		<th>작성자</th>
		<th>작성일자</th>
		<th>내용</th>
		<th>조회수</th>
	</thead>
	<tbody>
		<c:forEach var="board" items="${list }">
			<tr>
				<td>
					<c:out value="${board.boardNo }"></c:out>
				</td>
				<td><a href="board.do?bno=${board.boardNo }">
						<c:out value="${board.title }"></c:out>
					</a></td>
				<td>
					<c:out value="${board.writer }"></c:out>
				</td>
				<td>
					<c:out value="${board.writeDate }"></c:out>
				</td>
				<td>
					<c:out value="${board.content }"></c:out>
				</td>
				<td>
					<c:out value="${board.viewCnt }"></c:out>
				</td>
			</tr>
		</c:forEach>

	</tbody>

</table>
<nav aria-label="...">
	<ul class="pagination">
		<!-- paging시작 -->
		<!-- 이전페이지 여부 -->
		<c:choose>
			<c:when test="${paging.prev }">
				<li class="page-item">
					<a class="page-link" href="boardList.do?page=${paging.getStartPage()-1 }&searchCondition=${searchCondition}&keyword=${keyword}">Previous</a>
				</li>
			</c:when>
			<c:otherwise>
				<li class="page-item disabled">
					<span class="page-link">Previous</span>
				</li>
			</c:otherwise>
		</c:choose>



		<!-- 페이지의 START~end 반복 -->


		<c:forEach var="p" begin="${paging.startPage }" end="${paging.endPage }">
			<c:choose>
				<c:when test="${p==paging.currentPage }">
					<li class="page-item active " aria-current="page">
						<span class="page-link">
							<c:out value="${p }"></c:out>
						</span>
					</li>
				</c:when>


				<c:otherwise>

					<a class="page-link" href="boardList.do?page=${p }&searchCondition=${searchCondition}&keyword=${keyword}">${p }</a>
					<li class="page-item " aria-current="page">

					</li>
				</c:otherwise>
			</c:choose>
		</c:forEach>

		<c:choose>
			<c:when test="${paging.next }">
				<li class="page-item">
					<a class="page-link" href="boardList.do?page=${paging.endPage+1 }&searchCondition=${searchCondition}&keyword=${keyword}">Next</a>
				</li>
			</c:when>
			<c:otherwise>
				<li class="page-item disabled">
					<span class="page-link">Previous</span>
				</li>
			</c:otherwise>
		</c:choose>


	</ul>
</nav>
<!-- paging 끝  -->
