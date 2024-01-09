/**
 * service.js
 */
function makeLi(reply = {}) {
	//console.log(reply) 이거 주석 풀면 콘솔에 누적됨
	// start.
	let li = document.createElement('li');
	let span = document.createElement('span');
	span.innerText = '글번호:' + reply.replyNo;
	li.appendChild(span);
	span = document.createElement('span');
	span.innerText = ' ' + reply.reply;
	li.appendChild(span);
	span = document.createElement('span');
	span.innerText = ' ' + reply.name;
	li.appendChild(span);

	// 삭제버튼.
	let btn = document.createElement('button');
	btn.addEventListener('click', async function() {
		// 댓글번호 삭제 후 화면에서 제거.		
		const promise = await fetch('delReplyJson.do?rno=' + reply.replyNo); //await : 한라인씩 처리하겠다
		const json = await promise.json();
		try {
			if (json.retCode == 'OK') {
				alert('삭제됨.'); //콘솔확인 alerts('삭제됨.');
				showList(pageInfo);
			} else if (result.retCode == 'NG') {
				alert('처리중 에러.');
			}
		} catch (err) {
			console.error(err) //콘솔확인 console.error('예외=>',err)
		}
	}, true)
	btn.innerText = '삭제';
	li.appendChild(btn);  // end.

	return li;
}