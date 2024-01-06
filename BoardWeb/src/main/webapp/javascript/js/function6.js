//function6.js
const args = [4,5,6];

function sum(num1=0, num2=0, ...arg){ //...args : 순서에 맞게 계산하는 펼침연산자
   let result = 0; //함수 선언
   result = num1 + num2; //매개값으로 넘어오면 계산하고
   if(args.length > 0){ //args에 있는 수만큼 looping 돌면서
       args.forEach(val => {
           result += val;
       })
   }
   return result; //연산한 값 반환
}

console.log(sum(10, 20, ...args));

const ary1=[10, 20];

const ary2 = ary1.concat(args); //concat : 2개의 배열 합함
console. log(ary2);

const ary3 = [...ary1, ...args ]; //배열 요소를 펼치는 것도 가능
console. log(ary3); // console. log(ary2);과 같은 결과 console.

const obj1 = {name: "Hong", age:20} //속성을 하나씩 펼쳐서 새로운 요소에 담는다
const obj2 = {name: "Hwang", height:170}

const obj3 = {...obj1, ...obj2} //펼침연산자를 써서 새로운 객체를 만드는 것도 가능
console.log(obj3); //같은속성(중복된값)은 하나만, 아니면 다 누적된 값 출력됨

//reduce 메소드 간단하게 봄...
let result = [4,5,6].reduce((acc, curItem, idx, ary) =>{ //첫번째 값의 누산값(=초기값), 현재 첫번째 순번(현재 진행되는 값), 인덱스(인덱스번호), 배열그자체 
   console.log(acc, curItem, idx);
   return acc + curItem; //이번에 받는 값 리턴
}, 0); //초기값 0으로 준다는 의미
console.log('결과값 : ' + result); 

//map 메소드 (고차함수) forEach는 반환되는 값이 없다는 점에서 다름.
result = [1,2,3,4].map((item, idx, ary)=> {
   console.log(item, idx, ary);
   return item * 2;
});
console.log('결과값 : ', result); 

//변수의 스코프(2교시 시작).
var name = '어피치'; //전역변수로 어디든(모든 영역에서) 사용가능.
var name = '어피치'; //var는 중복된 변수도 선언되지만 let은 안됨. 앞에 let으로 수정하면 에러뜬다.

function run(){
   if(true){
       var name = '라이언'; //true 니까 무조건 출력됨 (함수 안에서 선언되어 쓰면 로컬변수)
   }
   console.log(name); //var이면 라이언 출력 let은 어피치 출력 (let은 블럭단위라서 블럭 안에서 쓰여진대로 유효함)
   return name;
}
run();
console.log(name); //어피치 출력

//스코프 체인
var a = 1;
var b = 5;

function outerFunc(){
   var b; //undefined
   function innerFunc() { 
       a = b;
   }
   console.log(a); //1출력
   a = 3;
   b = 4;
   innerFunc();
   console.log(a, b); //4, 4 출력
   var b= 2; //이 b는 호이스팅으로 끌어당겨져서 undefined 의 값을 담음. 전역변수 var b=5로 가는 게 아님.
   console.log(b); //2 출력
}
outerFunc(); //호출하면 위에서부터 시작

//예외처리 : try catch로 담아줌
const c = 10;

try{
   c = 20;
} catch(error) { //catch구문은 에러시 출력
   console.log(error.message) 
} finally{ //finally는 에러유무 상관없이 출력
   console.log(c);
}
