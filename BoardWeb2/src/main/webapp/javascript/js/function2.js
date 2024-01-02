//function2.js
let members = `[{"id":1,"first_name":"Doll","last_name":"Mainz","email":"dmainz0@princeton.edu","gender":"Female","salary":7329},
{"id":2,"first_name":"Latashia","last_name":"Moakes","email":"lmoakes1@github.io","gender":"Female","salary":9430},
{"id":3,"first_name":"Cynthy","last_name":"Ackwood","email":"cackwood2@gmpg.org","gender":"Female","salary":5891},
{"id":4,"first_name":"Aurlie","last_name":"Torpie","email":"atorpie3@npr.org","gender":"Female","salary":6424},
{"id":5,"first_name":"Derril","last_name":"Roundtree","email":"droundtree4@mapquest.com","gender":"Male","salary":2464},
{"id":6,"first_name":"Frasier","last_name":"Prosek","email":"fprosek5@mediafire.com","gender":"Male","salary":4034},
{"id":7,"first_name":"Clemmie","last_name":"Castelijn","email":"ccastelijn6@sphinn.com","gender":"Male","salary":7471},
{"id":8,"first_name":"Terrill","last_name":"McCarty","email":"tmccarty7@netvibes.com","gender":"Male","salary":1688},
{"id":9,"first_name":"Flinn","last_name":"Shooter","email":"fshooter8@gnu.org","gender":"Male","salary":1762},
{"id":10,"first_name":"Josepha","last_name":"Soars","email":"jsoars9@earthlink.net","gender":"Female","salary":4975},
{"id":11,"first_name":"Rockwell","last_name":"Dives","email":"rdivesa@nyu.edu","gender":"Male","salary":9115},
{"id":12,"first_name":"Marika","last_name":"Rooney","email":"mrooneyb@cpanel.net","gender":"Female","salary":5958},
{"id":13,"first_name":"Eduino","last_name":"Pantin","email":"epantinc@acquirethisname.com","gender":"Male","salary":7370},
{"id":14,"first_name":"Rainer","last_name":"Lyford","email":"rlyfordd@oakley.com","gender":"Male","salary":3255},
{"id":15,"first_name":"Verna","last_name":"Sprulls","email":"vsprullse@shutterfly.com","gender":"Female","salary":2699}]`;

let memberAry = JSON.parse(members); //문자열 값을 객체타입으로 변환
console.log(memberAry[14]);

let titles = ['아이디','이름','성씨','이메일','성별','급여'] //태그 만들기 위한 데이터

function makeHeader(fields=[], pos={}) {
    let tr = document.createElement('tr');
    fields.forEach(function(field){
        let th = document.createElement('th'); //looping 돌면서 th만들어줌
        th.innerText = field;
        tr.appendChild(th);
    })
    pos.appendChild(tr);
}

makeHeader(titles, document.getElementById('theader')); //(값, 붙을 위치)

function makeBody(data = [], pos = {}){
    //
    data.forEach(function (item){ //(item)은 객체
        let tr = document.createElement('tr');
        //tr에 속성 지정
        if(item.gender =='Male'){
            tr.setAttribute('style', 'background-color : aqua')
        }else if (item.gender =='Female'){
            tr.setAttribute('style', 'background-color : pink')
        }
        // console.log(item);
        for(let prop in item){ //for ~ in. 값의 명칭? 제목?을 가져옴..
        let td = document.createElement('td');
        td.innerText = item[prop]; //item의 값을 가져옴.
        tr.appendChild(td);
    }
    pos.appendChild(tr);
})
}

makeBody(memberAry, document.getElementById('tbody'));