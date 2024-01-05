// class2.js
let year = 2024;
let month = 2;

class Calendar {
    constructor(year, month) {
        this.year = year;
        this.month = month;
    }
    days = ['Sun', 'Mon', 'Tue', 'Wed', 'Thr', 'Fri', 'Sat'];
    makeCalendar() {
        this.makeTitle(document.getElementById('theader'));
        this.makeBody(document.getElementById('tbody'));
    }
    makeTitle(pos) {
        let tr = document.createElement('tr');
        this.days.forEach(function (field) {
            let th = document.createElement('th');
            th.innerText = field;
            tr.appendChild(th);
        })
        pos.appendChild(tr);
    }
    makeBody(pos = {}) {
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
    getLastDate() {
        return new Date(this.year, this.month, 0).getDate();
    }
}
const cal = new Calendar(year, month);
cal.makeCalendar();