<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>promise2.jsp</title>
</head>
<body>
<script>
fetch('data.json', {
	method: 'post', //'get'
	mode: 'cors',
	headers:{
		'Content-type': 'application/x-www-form-urlencoded'
	},
	body: 'x=120&y=200'
}) //url, option 객체
.then(result => {
	console.log(result);
	return result.json(); //문자열을 객체로 변환시켜주는 메소드
})
.then(json=>{ //여기서 쓴 json 변수라서 별 의미는 없음
	console.log(json);
})
.catch(error=>{
	console.error(error);
})

</script>
</body>
</html>