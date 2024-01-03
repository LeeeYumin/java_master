//class2.js
let year = 2024;
let month = 2;

let today = new Date(year, month - 1, 1); //{} new Object()
today = new Date(year, month, 0)
console.log(today.getFullYear())
console.log(today.getMonth()) //0부터 시작(1월은 0)
console.log(today.getDate(), today.getDay()) //해당되는 날짜, 일요일 : 0 수요일은 3

class Calendar {
    constructor(year, month) { //속성을 담기 위해 생성자 생성
        this.year = year;
        this.month = month; //년월은 여기서 해놔서 밑에선 또 해줄 필요 없음

    }
    days = ['Sun', 'Mon', 'Tue', 'Wed', 'Thr', 'Fri', 'Sat'] //필드(속성 선언)
    makeCalendar() {
        this.makeTitle(document.getElementById('theader'));
        this.makeBody(document.getElementById('tbody')); //어느 위치에 넣어주겠다~
        //console.log('달력생성.')
    }

    makeTitle(pos) { //pos : 매개값
        let tr = document.createElement('tr');
        this.days.forEach(function (field) {
            let th = document.createElement('th');
            th.innerText = field;
            tr.appendChild(th);
        })
        pos.appendChild(tr);
    }

    makeBody(pos = {}) { //DOM객체
        let tr = document.createElement('tr');
        // 공백.
        let firstDay = this.getFirstDay();
        for (let i = 0; i < firstDay; i++) {
            let td = document.createElement('td');
            td.innerText = "";
            tr.appendChild(td);
        }
        // 날짜.
        let lastDate = this.getLastDate();
        for (let i = 1; i <= lastDate; i++) {
            // 토욜: pink, 일욜: aqua.
            let td = document.createElement('td');
            // td의 속성을 추가.
            if ((firstDay + i) % 7 == 1) {
                td.setAttribute('style', 'background-color: pink');
            } else if ((firstDay + i) % 7 == 0) {
                td.setAttribute('style', 'background-color: aqua');
            }
            td.innerText = i;
            tr.appendChild(td);
            if ((firstDay + i) % 7 == 0) {
                pos.appendChild(tr);
                tr = document.createElement('tr');
            }
        }
        pos.appendChild(tr);
    } //

    getFirstDay() {
        return new Date(this.year, this.month - 1, 1).getDay();
    }

    getLastDate() {  //년도, 월 넣어줌. this.year, this.month
        return new Date(this.year, this.month, 0).getDate(); //0:마지막날을 의미
    }
}
const cal = new Calendar(year, month);
cal.makeCalendar();

