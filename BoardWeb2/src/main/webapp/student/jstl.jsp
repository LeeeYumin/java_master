<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>student/jstl.jsp</title>
</head>
<body>
<!-- 자바코드 대체하기. 선언은 set 출력은 out-->
<c:set var="name" value="홍길동"></c:set>
<c:out value="${name}"></c:out>
<c:set var="age" value="19"></c:set>

<!-- if -->
<c:if test="${age >= 20 }">
<p>성인입니다</p>
</c:if>

<!-- if 조건.. -->
<c:choose>
	<c:when test="${age >= 20 }">
	<p>성인입니다</p>
	</c:when>
	<c:otherwise>
	<p>미성년자입니다</p>
	</c:otherwise>
</c:choose>

<!-- for(i=1; i<=10; i++){} -->
<c:forEach begin="1" end="10" step="1" var="i">
<p>i의 값은 ${i}</p>
</c:forEach>
<!-- 구구단도 가능함-->
<c:forEach begin="1" end="9" step="1" var="i">
<p>3 * ${i} = ${3*i}</p>
</c:forEach>

<!-- for(String name : names) {} 확장for문. set으로는 컬렉션담기 어려움 -->
<c:set var="names" values="Hong,Hwang,Kim"></c:set>
<c:forEach items="${names }" var="n">
<p>${n }</p>
</c:forEach>

</body>
</html>