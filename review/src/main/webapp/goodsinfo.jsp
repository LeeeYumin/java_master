<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>goodsinfo.jsp</title>
<script src=" https://code.jquery.com/jquery-3.7.1.js"
        integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" crossorigin="anonymous"></script>
</head>
<body>
<h1>상품상세</h1>
${book }
<h1>리뷰등록</h1>
	<form  action="reviewAddServ">
	<input name="content" value="리뷰1">
	<input name="username" value="길동">
	<button>등록</button>
	</form>
	
	<form id="ajaxForm">
	<input name="content" value="리뷰1">
	<input name="username" value="길동">
	<button type="button" id="btnAdd">ajax등록</button>
	</form>

<h2>리뷰리스트</h2>
<div id="reviewList">
${review }
</div>
<script>
btnAdd.addEventListener("click", function(){
	let name = document.querySelectorAll('[name="content"]')[1].value;
	let content = document.querySelectorAll('[name="content"]')[1].value;
	//get
	//let param = `name=\${name}&content=\${content}`;
	//fetch("reviewAddAjaxServ?"+param)
	//.then(result => result.text())
	//.then(result => console.log(result));
	
	//post
	let formData = new FormData(ajaxForm)
	fetch("reviewAddAjaxServ?",{
		method:"post",
		headers: {
		  "Content-Type": "application/json",
		  //'Content-Type': 'application/x-www-form-urlencoded',
		},
		body: JSON.stringify({username, content}) }) //달러("ajaxForm").serialize() 오류뜨는데왜지
	.then(result => result.json())
	.then(result => console.log(result.test));
	
	
})
</script>


</body>
</html>