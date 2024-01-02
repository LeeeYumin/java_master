//calendar.js
let days = ['Sun', 'Mon', 'Tue', 'Wed', 'Thr', 'Fri', 'Sat']

let lastDate = getLastDate(1);
let firstDay = getFirstDay(1);
console.log(lastDate, firstDay);

//달력 생성
function makeCalendar(month) {
    makeTitle(days, document.getElementById('theader'));
    makeBody(month, document.getElementById('tbody'));
}
makeCalendar(3);

function getLastDate(month) {
    //월을 입력하면 마지막 날을 반환. 31,29,31,30,31,30...
    //if , switch 뭘 쓰든 상관없음
    switch (month) {  //if 써서 짝수는 30 홀수는 31 2,8월은 개별로 주는 방법도 될 거 같은데 일단 따라서 침
        case 4:
        case 6:
        case 9:
        case 11:
            return 30;
            break;
        case 2:
            return 29;
            break;
        default:
            return 31;
    }
}

function getFirstDay(month) {
    //월을 입력하면 1일의 위치(공백이 몇 개인지 반환)
    switch (month) {
        case 1:
            return 1;
            break;
        case 2:
            return 4;
            break;
        case 3:
            return 5;
            break;
    }
}

//header 생성해주는 함수. makeTitle 호출해서 쓸거임. 값은 days를 넣어줌
function makeTitle(dayAry = [], pos = {}) {
    let tr = document.createElement('tr');
    dayAry.forEach(function (field) {
        let th = document.createElement('th'); //looping 돌면서 th만들어줌
        th.innerText = field;
        tr.appendChild(th);
    })
    pos.appendChild(tr);
}

//날짜 생성해주는 함수.
function makeBody(month = 1, pos = {}) { //pos:position 
    let tr = document.createElement('tr');
    //공백이 몇개인지 그 수만큼 tr td 생성
    let firstDay = getFirstDay(month);
    for (let i = 0; i < firstDay; i++) {
        let td = document.createElement('td');
        td.innerText = ""; //공백만들어주니까 빈칸
        tr.appendChild(td);
    }

    //날짜 출력
    let lastDate = getLastDate(month);
    for (let i = 1; i <= lastDate; i++) {
        //토요일:pink, 일요일:aqua 색넣기
        let td = document.createElement('td')
        //td의 속성 추가
        if ((firstDay + i) % 7 == 1){
            td.setAttribute('style','background-color : aqua');
        }else if((firstDay + i) % 7 == 0){
            td.setAttribute('style','background-color : pink');
        }

        
        td.innerText = i;
        tr.appendChild(td);

        if ((firstDay + i) % 7 == 0) {
            pos.appendChild(tr);
            tr = document.createElement('tr');
        }
    }
    pos.appendChild(tr);
}
