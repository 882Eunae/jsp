<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<h3>Ajax연습페이지</h3>



<form action="addData.do">
	<table class="table">
		<tr>
			<th>회원ID</th>
			<td><input type="text" name="mid" id="mid"></td>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td><input type="text" name="mpw" id="mpw"></td>
		</tr>
		<tr>
			<th>회원이름</th>
			<td><input type="text" name="mname"id="mname"></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<button id="addMember" class="btn btn-danger">추가</button>
			</td>
		</tr>
	</table>
</form>

<h3>회원목록</h3>
<table class="table">
	<thead>
		<tr>
			<th>아이디</th>
			<th>비번</th>
			<th>이름</th>
			<th>권한</th>
		</tr>
	</thead>
	<tbody id="list_member">

	</tbody>
</table>


<script src="js/member.js"></script>
