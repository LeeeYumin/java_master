//string1.js

let str1 = "Hello!"; //문자열을 담음
console.log(str1, typeof str1); //타입 string
let str2 = new String("Hello!");
console.log(str2, typeof str2); //타입 object

console.log(str1 === str2); //타입까지 비교해서 false

console.log(str2.substring(1,3)); //잘라서 반환. 앞(1)에는 포함하고 뒤(3)에는 포함안함. el출력...?

//trim p.158
let word = "  Hello, World    ";
console.log(word.trimStart()); //왼쪽 여백 제거
console.log(word.trimEnd()); //오른쪽 여백 제거

//replace
word.replace('H' ,'h') //(찾아올거, 대치할거)
console.log(word.replace('H' ,'h'));
//const obj = {} 로 선언 가능.  const obj = new Object(); 도 가능.
//const reg = new RegExp(); /값/
console.log(word.replace(/l/g ,'L')); //정규표현식 객체. g는 global 의미.
console.log(word.replace(/\s/g,'')); //\s : 공백 의미

//split
word = '   how are you    to day everyone.   '; //문자열
console.log(word.split(' ').filter((val) => { //구분자를 기준으로 공백을 만들어줌..
    return val;
}).join(' ')); //filter는 가져온 값이 조건에 true 인것만 담아서 새로운 배열로 만들어줌. 공백은 false

console.log(word.split(' ').filter(val => val).join(' ')); //이렇게도 줄일 수 있음
//가지고 와서 문장으로 만들어주는 게 join.

//p.160~172 타이핑 자습
//slice
const str160 = 'This is the only one story';
console.log(str160.slice(10,15)); //e onl 출력 (0부터 시작)
console.log(str160.slice(-8,15)); //빈값
console.log(str160.slice(10,4)); //빈값
console.log(str160.slice(30)); //빈값
console.log(str160.slice(0,-10)); //끝 인덱스는 -값 사용가능. This is the only
console.log(str160.slice(8,100)); //문자열 길이값보다 큰 값은 마지막 인덱스+1. the only one story

//substring
console.log(str160.substring(8,11)); //the
console.log(str160.substring(10,-8)); //This is th

//substr (시작인덱스, 가져 올 문자열 길이)
console.log(str160.substr(8,11)); //the only on

//toString 숫자->문자열
const arr163 = [1,2,'a','b',3];
console.log(arr163.toString()); //1,2,a,b,3
const obj163 = {key:'data', value:15};
console.log(obj163.toString()); //[object object]
console.log(obj163.key.toString()); //data
console.log(obj163.value.toString()); //15

//indexOf(), lastIndexOf() : 찾은 문자열의 시작 위치
//charAt() : 특정 위치의 문자 1개 얻기
//includes() : 특정 문자열 포함유무 (있으면t 없으면f)
//search() : 대소문자 구분없이 문자열 위치 찾기 /찾는문자열/i 하면 대소문자 무시하고 찾음
//match() : 정규표현식과 일치하는 모든 문자열 찾기

//toLowerCase() : 모두 소문자로
//toUpperCase() : 모두 대문자로

//concat()
const str71 = '집';
const str72 = ' 가고싶다';
console.log(str71.concat(str72)); //집 가고싶다 출력