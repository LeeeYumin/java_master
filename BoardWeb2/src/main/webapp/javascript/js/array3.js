//array3.js
//reduce 수업연속
import { members, titles } from './data.js';

console.log(members);
console.log(titles);

//reduce로 만들기
let str = titles.reduce((acc, title, idx) => {
    if (idx == 0) {
        acc += '<tr>'; //여는tr
    }
    acc += '<th>' + title + '</th>';
    if (idx == titles.length - 1) {
        acc += '<tr>'; //닫는tr
    }
    return acc;
}, '');
console.log(str);
document.getElementById('theader').innerHTML = str; //<tr><th.../th><tr>

//DOM 적용
const tbody = document.getElementById('tbody');
members.reduce((acc, member) => { //tbody 이름이 acc
    let tr = document.createElement('tr');
    for (let prop in member) {
        let td = document.createElement('td');
        td.innerText = member[prop];
        tr.appendChild(td);
    }
    acc.appendChild(tr);
    return acc;
}, tbody);

//map(A -> 'A'), filter(A -> B) 이부분은 검색하면서 다시 공부해보기...
//요소들을 조합해서 새로운 배열 생성함
let result = members.map((item, idx) => {
    let obj = {}
    obj.id = item.id;
    obj.name = item.first_name + '-' + item.last_name;
    obj.email = item.email;
    return obj;
});

// filter() : 조건을 만족하는 새로운 배열 생성
// 메소드체인 : 메소드를 이어서 사용(반환값이 맞아야 가능)
result = members
    .filter(item => item.gender == 'Female') //이게 메소드 체인
    .map((member, idx) => {
        let obj = {}
        obj.id = membe.id;
        obj.name = membe.first_name + '-' + member.last_name;
        obj.email = membe.email;
        return obj;
    })
    .map(item => item.name);
// return 과 {} 생략 가능    
console.log(result);
result.push('charles');
result.push('Hong');
result.push('charles');
console.log(result);


console.log(result.indexOf('charles',6)); //[7] 출력

//console.log(result.indexOf('Roby-Rhubottom')); //그 위치에있는 인덱스값

//p.207~221 배열! 책보고실습 (mdn봄)
//find() 조건 만족하는 첫번째 요소. 
//filter() 조건 만족하는 요소들을 가진 배열로 반환
//some() 조건 만족하는 요소가 하나라도 있으면 t 없으면 f 반환 default T
//every() 모든 배열 요소가 조건을 만족하면 t 아니면 f 반환 default F
//split() 1. 하나의 문자열을 구분자를 사용해 문자열 배열로 나눔 2. 문자열 일부를 배열로 가져옴
//forEach() 배열을 순환하며 요소 탐색, 콜백 함수로 배열 요소 처리
//map() 배열을 순환해 변경한 새 배열 반환
