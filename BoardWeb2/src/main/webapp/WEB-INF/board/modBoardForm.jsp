<%@page import="com.yedam.board.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file ="../layout/menu.jsp" %>
<%@include file ="../layout/nav.jsp" %>

	<h3>수정화면</h3>
	<%
	BoardVO vo = (BoardVO) request.getAttribute("vo");
	%>
	<form action="modifyForm.do"> <!-- 커밋하면 여기로 넘어감 -->
		<input type="hidden" name="bno" value="<%=vo.getBoardNo()%>">
		<table border="1">
			<tbody>
				<tr>
					<td>글번호</td>
					<td colspan="4"><%=vo.getBoardNo()%></td>
				</tr>
				<tr>
					<td>제목</td>
					<td colspan="4"><%=vo.getTitle()%>프로그램공부..</td>
				</tr>
				<tr>
					<td>내용</td>
					<td colspan="4"><textarea cols="10" rows="4" name="content"><%=vo.getContent()%></textarea></td>
				</tr>
				<tr>
					<td>작성자</td>
					<td colspan="4"><%=vo.getWriter()%></td>
				</tr>
				<tr>
					<td>작성일</td>
					<td><%=vo.getWriteDate()%></td>
					<td>조회수</td>
					<td><%=vo.getClickCnt()%></td>
				</tr>
				<tr>
					<td>이미지</td>
					<td colspan="4"></td>
				</tr>
				<tr>
					<td colspan="4" align="center">
						<input type="submit" value="저장">
						<input type="reset" value="취소"></td>
				</tr>
			</tbody>
		</table>
	</form>
	<br>
	<a href="boardList.do">글목록으로</a>
	<%@ include file ="../layout/foot.jsp" %>