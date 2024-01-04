//class5.js
//Map
const map = new Map();
map.set('홍길동', 20); //값을 담을때 set
map.set('김민수', 22); //(key, value)
map.set('최성우', 25);
map.set('홍길동', 21); //같은 값이 있으면 변경돼서 보임

//삭제. 주석처리하면 다시 살아남
//map.delete('최성우');

console.log(map.get('김민수'));
//map.clear(); //클리어. map 전체내용삭제. remove는 선택삭제인듯

console.log(map.get('김민수')); //22 출력
for (let key of map.keys()) {
    console.log(`keys는 ${key}, value는 ${map.get(key)}`); //keys : 해당되는 키값을 새로운 컬렉션에 담아준다
}
console.log(map.values());
console.log(map.entries()); // key 와 values 같이
for (let [item, value] of map.entries()){
    console.log(item, value);
} //배열로 담아와봄. obj 대신 [item, value] 넣음.

//첫번째 매개값이 값value이고 두번째 매개값이 키key. 예상했던거랑은 다른 순서..
map.forEach((val, key) => console.log('key : ' + key + ', val :' + val));

//Set.
const set = new Set();
set.add('홍길동');
set.add('김민수');
set.add('홍성길');
set.add('홍길동'); //set은 중복값 허용안함

set.delete('김민수'); //삭제
//console.clear(); //전에 있던 콘솔 로그 지워주는 기능
console.log(set.size); //배열은 length. set은 size.

set.forEach(name => console.log(name));

const numAry = [10, 14, 12, 10]
//중복된 값 삭제하고 싶으면 set컬렉션
const num = new Set(numAry); //배열 -> Set
num.forEach(number => console.log(number)); //중복된 10은 제거됨

//김씨 성을 갖고 있는 사람의 합계 구하기
map.set('김명철', 80)
map.set('김익수', 70)
map.set('이명철', 80)
map.set('이익수', 85)
map.set('홍길동', 80)

let sum = 0;
map.forEach((score, name) => {
    if(name.indexOf('김') == 0) {
        sum += score;
    }
})
console.log(`합계점수 : ${sum}`); //위에 김민수 22 같이 합해진다.. 왜지?


