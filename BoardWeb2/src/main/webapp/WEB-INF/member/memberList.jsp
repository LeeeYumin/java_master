<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- member/memberList.jsp 보여지게 -->
<h3>회원목록</h3>
<table class="table">
	<thead>
		<tr>
			<th>아이디</th>
			<th>비밀번호</th>
			<th>이름</th>
			<th>권한</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="vo" items="${memberList}">
			<tr>
			<td>${vo.logId }</td>
			<td>${vo.pw }</td>
			<td>${vo.logName }</td>
			<td>${vo.responsibility }</td>		
			</tr>
		</c:forEach>
		</tbody>
</table>