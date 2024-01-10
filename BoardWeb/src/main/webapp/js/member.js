/*/member.js*/

$(document).ready(function() {
	//회원목록 출력
	$.ajax('memberListJson.do', {
		method: 'get', //서버에 데이터 요청하는 방식
		//data: {bno:1, rno:2}, //'bno=1&rno=2' 조회만 할거라서 파라메터필요없음
		dataType: 'json', //서버의 데이터를 담아와서 데이터 포맷을 지정
		success: function(result) {
			$(result).each((idx, member) => {
				//tr, td 생성
				let img = '';
				if (member.image) {
					img = $('<img />').attr({ 'src': 'images/' + member.image, 'style': 'width: 100px' });
				}

				let tr = $('<tr >').append($('<td />').text(member.id),
					$('<td />').text(member.name),
					$('<td />').text(member.responsibility),
					$('<td />').html(img)
				);
				$('#list').append(tr);
			}); //forEach

		},
		error: function(err) {
			console.log(err);

		}
	})

	//회원등록
	$('#addBtn').on('click', function() {
		let formData = new FormData(); //multipart/form-data : 
		formData.append('id', $('input[name="id"]').val());
		formData.append('pw', $('input[name="pw"]').val());
		formData.append('name', $('input[name="name"]').val());
		formData.append('image', $('input[name="image"]')[0].files[0]);

		/*for (let ent of formData.entries()) {
			console.log(ent);
		}*/ //확인하려고 쓴거. 기능이랑 상관없음. 지워도 됨..
		
		//등록하면 하단에 이어서 화면출력되게
		$.ajax('memberAddJson.do', {
			method: 'post',
			data: formData,
			processData: false,
			contentType: false,
			dataType: 'json',
			success: function(result) {
				if(result.vo == 'OK'){ //해보라고 하는 부분...
					let img = '';
				if (result.vo.image) {
					img = $('<img />').attr({ 'src': 'images/' + result.vo.image, 'style': 'width: 100px' });
				}
				let tr = $('<tr >').append($('<td />').text(result.vo.id),
										   $('<td />').text(result.vo.name),
										   $('<td />').text(result.vo.responsibility),
					                       $('<td />').html(img)
				);
				$('#list').append(tr);
				}
				console.log(result);
			},
			error: function(err) {
				console.error(err);
			}
		})

	})
})