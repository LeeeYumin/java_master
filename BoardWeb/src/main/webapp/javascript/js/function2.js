// function2.js
let members = `[{"id":1,"first_name":"Delmer","last_name":"Murrthum","email":"dmurrthum0@ovh.net","gender":"Male","salary":5201},
{"id":2,"first_name":"Daffi","last_name":"Menault","email":"dmenault1@ask.com","gender":"Female","salary":5959},
{"id":3,"first_name":"Kellie","last_name":"Stuehmeier","email":"kstuehmeier2@histats.com","gender":"Female","salary":7627},
{"id":4,"first_name":"Joannes","last_name":"Surmeir","email":"jsurmeir3@redcross.org","gender":"Female","salary":5092},
{"id":5,"first_name":"Scotti","last_name":"Sybe","email":"ssybe4@booking.com","gender":"Male","salary":4031},
{"id":6,"first_name":"Hort","last_name":"Impett","email":"himpett5@soup.io","gender":"Male","salary":6697},
{"id":7,"first_name":"Aldridge","last_name":"Budgey","email":"abudgey6@linkedin.com","gender":"Male","salary":8664},
{"id":8,"first_name":"Neale","last_name":"Chatfield","email":"nchatfield7@google.ru","gender":"Male","salary":549},
{"id":9,"first_name":"Tootsie","last_name":"Jeanenet","email":"tjeanenet8@webmd.com","gender":"Female","salary":4166},
{"id":10,"first_name":"Stanfield","last_name":"Surgeoner","email":"ssurgeoner9@cyberchimps.com","gender":"Male","salary":8808},
{"id":11,"first_name":"Romain","last_name":"Icke","email":"rickea@redcross.org","gender":"Male","salary":3597},
{"id":12,"first_name":"Menard","last_name":"Ludewig","email":"mludewigb@washingtonpost.com","gender":"Male","salary":7830},
{"id":13,"first_name":"Guthry","last_name":"Burburough","email":"gburburoughc@linkedin.com","gender":"Male","salary":1389},
{"id":14,"first_name":"Roby","last_name":"Rhubottom","email":"rrhubottomd@ask.com","gender":"Female","salary":1354},
{"id":15,"first_name":"Ingmar","last_name":"Iacovielli","email":"iiacoviellie@buzzfeed.com","gender":"Male","salary":2869}]`;

let memberAry = JSON.parse(members); // 문자열 -> 객체변환.
// console.log(memberAry[14]);

let titles = ['아이디', '이름', '성씨', '이메일', '성별', '급여']

function makeHeader(fields = [], pos = {}) {
    let tr = document.createElement('tr');
    fields.forEach(function (field) {
        let th = document.createElement('th');
        th.innerText = field;
        tr.appendChild(th);
    })
    pos.appendChild(tr);
}

makeHeader(titles, document.getElementById('theader'));

function makeBody(data = [], pos = {}) {
    // 
    data.forEach(function (item) {
        let tr = document.createElement('tr');
        // tr에 속성지정.
        if (item.gender == 'Male') {
            tr.setAttribute('style', 'background-color: aqua');
        } else if (item.gender == 'Female') {
            tr.setAttribute('style', 'background-color: pink');
        }
        for (let prop in item) {
            let td = document.createElement('td');
            td.innerText = item[prop];
            tr.appendChild(td);
        }
        pos.appendChild(tr);
    })
}

makeBody(memberAry, document.getElementById('tbody'));