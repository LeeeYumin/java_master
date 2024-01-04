//string2.js

const keyword= '홍';
const wordAry = ['사과', '홍씨', '홍장군', '김시홍', '감자']
//1. 배열에서 '홍'이 들어간 단어의 갯수 구하기
//내가 적은거 2가지.. 안나옴. 집에서 indexOf() 써봤는데 -1나옴.. 뭘까...
let count = 0;
for(let i = 0; i < wordAry.length; i++){
    if(wordAry[i] == '홍'){ //indexOf() 사용해서 값나오게 해보기
        count ++;
    }
}
console.log(`count : ${count}`);

//집에서 혼자.. 안됨ㅠ
let count2;
count2 = wordAry.indexOf("홍");
console.log(wordAry.indexOf("홍"));

const result = wordAry.filter(keyword => keyword == '홍');
console.log(result);
console.log(`count : ${result.length}`);

//교수님 풀이
console.log(wordAry.filter(val => val.indexOf(keyword) != -1).length);


const url = 'http://localhost/BoardWeb/index.jsp?x=12&y=23';
//2. url에서 파라미터(x,y)의 값을 찾기
//교수님 풀이
console.log(url.match(/\d+/g)[0], url.match(/\d+/g)[1]);

const word = '안녕하세요xx만나서xx반갑습x니x다.';
//3. "안녕하세요 만나서 반갑습니다." 문장으로 변환하기.
console.log(word.replace(/x/g ,' '));

//교수님 풀이
console.log(word.replace(/xx/g,' ').replace(/x/g, ''));

