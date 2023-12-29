// table.js
// for(let prop in obj1) {      }
// table 생성. start.
let tbl = document.createElement('table');
tbl.setAttribute('border', 1); // attribute 추가. (속성, 값)
tbl.setAttribute('id', 'list');
tbl.appendChild(makeHead());
tbl.appendChild(makeBody());
document.querySelector('body').appendChild(tbl);
// table생성 end.

// 추가 버튼 클릭 이벤트.
document.getElementById('addBtn').addEventListener('click', function () { //addBtn을 누르면 함수 실행
    let id = document.getElementById('uid').value;
    let name = document.getElementById('uname').value;
    let phone = document.getElementById('uphone').value; //3개 값을 받아온다

    //빈칸의 경우 넣어지지 않게하기
    if(!id || !name || !phone) {
        alert('값을 입력하세요');
        return; //함수 종료
    }

    let obj = {id, name, phone } // {개체의 속성 : 변수의 값 인데 2개가 같으면 1개만 적으면 됨.}
    document.querySelector('#list>tbody').appendChild(makeTr(obj)); //>는 바로 하위의 자식요소 의미. id값이 list인 것의 하위값을 들고 오겠다

    //값 입력 후 빈칸이 되고 커서 깜빡임
    document.getElementById('uid').value = '';
    document.getElementById('uname').value = '';
    document.getElementById('uphone').value = '';
    document.getElementById('uid').focus();

    makeTr(obj); //이 변수에 담을거임


})

//변경 버튼 클릭 이벤트 등록
document.querySelector('#editBtn').addEventListener('click', function () {
    //찾을 값 :
    let findId = document.getElementById('uid').value;
    let phone = document.getElementById('uphone').value;
    //찾을 대상=target.
    let target = document.querySelectorAll('#list>tbody>tr'); //>생략도 되긴함...
    //console.log(target);
    target.forEach(function(item, idx, ary){ //foreach는 '함수'가 매개값으로 옴 function(배열의요소tr,인덱스값012,타겟자체)
        //console.log(item, idx, ary)
        let tr = item;
        console.log(tr.children[0].innerText, findId); //애매하면 콘솔로 찍어보기
        if(tr.children[0].innerText == findId){
            tr.children[2].innerText = phone;
        }
    })

})

//선택삭제 이벤트 시작 css선택자로...
document.querySelector('#delBtn').addEventListener('click', function () {
    document.querySelectorAll('#list>tbody>tr>td>input:checked').forEach(function(item) { //id값 요소. :뒤에는 옵션?
        item.parentElement.parentElement.remove();
    })  
})


function makeHead() {
    // thead 시작.
    let thd = document.createElement('thead');

    // tr.
    let tr = document.createElement('tr');

    // th*3.
    for (let prop in obj1) {
        let th = document.createElement('th');
        th.innerText = prop.toUpperCase();
        tr.appendChild(th);
    }
    // 삭제.
    let th = document.createElement('th');
    th.innerText = '삭제';
    tr.appendChild(th);

    //선택삭제
    th = document.createElement('th');
    th.innerText = '선택삭제';
    tr.appendChild(th);

    thd.appendChild(tr);
    return thd;
}

function makeBody() {
    // tbody 시작.
    let tbd = document.createElement('tbody');

    for (let friend of friends) {
        tbd.appendChild(makeTr(friend));
    }
    return tbd;
}

function makeTr(obj) { //obj 매개값 obj={} : 객체를 가지고 값이 안들어오면 초기값을 쓰겠다
    // tr.
    let trb = document.createElement('tr'); //trb는 변수
    trb.addEventListener('click', function () {
        console.log(this.children[1].innerText); //this 대신 trb 써도됨
        document.getElementById('uid').value = this.children[0].innerText; //칸 클릭하면 아이디 뜸
        document.getElementById('uname').value = this.children[1].innerText;
        document.querySelector('#uphone').value = this.children[2].innerText; //3개 다 넣어줘서 정보 다 따라보임
    })
    // td.
    for (let prop in obj) {
        let td = document.createElement('td');
        td.innerText = obj[prop];
        trb.appendChild(td);
    }
    //삭제버튼 생성
    let td = document.createElement('td');
    let btn = document.createElement('button');
    // button 이벤트 등록
    btn.addEventListener('click', function (e) { // 이벤트핸들러
        e.stopPropagation(); //상위요소로 이벤트 전파 차단
        console.log(this.parentElement.parentElement.remove());
    });
    btn.innerText = '삭제';
    td.appendChild(btn);
    trb.appendChild(td);

    //선택삭제(체크박스)
    let td2 = document.createElement('td');
    td2.setAttribute('align', 'center'); //중간정렬
    let chbox = document.createElement('input'); //타입이 input 태그임. 그 속성이 checkbox
    //체크박스 선택시 위에 3개 값 안따라오게하기
    chbox.addEventListener('click', function(e){ //event 가 매개값으로 넘어옴. 아무거나 못넣음. 
        e.stopPropagation(); //상위요소로 이벤트 전파 차단
        console.log(e);
    })
    chbox.setAttribute('type', 'checkbox');
    td2.appendChild(chbox);
    trb.appendChild(td2);


    return trb;
}