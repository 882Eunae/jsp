<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<style>
tfoot input {
	width: 100%;
	padding: 3px;
	box-sizing: border-box;
}
</style>


<h3>testAjax댓글관리 페이지</h3>
<h4>manage.do</h4>

<button class="button" >입력후클릭</button>
	<input class="who" type="text" placeholder="유저명입력">


<table id="example" class="display" style="width: 100%">
	<thead>
		<tr>
			<th>replyer</th>
			<th>reply</th>
			<th>boardNo</th>
			<th>reply_date</th>
		</tr>
	</thead>
	<tbody>
		<!-- 댓글목록 -->
		<div id='replylist'></div>
		
	</tbody>

</table>





<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
<script src="https://cdn.datatables.net/2.2.2/js/dataTables.js"></script>
<script src="js/ajaxreply.js"></script>