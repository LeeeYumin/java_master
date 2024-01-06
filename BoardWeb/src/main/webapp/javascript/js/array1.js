//array1.js
// ary = []
const ary = [1, 2, '3', new Date()]; //타입 상관없이 모든 데이터 담기 가능

const numAry = [10, 20, 30, 40]
numAry.push(30); //일반적인 값 추가
numAry.unshift(40); //제일 첫번째에 값 추가
numAry.pop(); //마지막 요소 삭제
numAry.shift(); //첫번째 요소 삭제
numAry.splice(); //(몇번째배열위치, 몇개지울지)특정 위치의 값. 여기선 2번째 값 지울거라 1,1넣음
//numAry.splice(1, 0, 50, 60) //(몇번째배열위치, 몇개를, 대체할값)특정위치의 값 수정. 0만 넣으면 값 다 지움.
numAry.length = 10; //공간의 값을 더 만들어줌. 배열의 크기를 바꿔주는 속성. (java에서는 읽기전용임) 

const numAry2 = [50, 60];

//const numAry3 = numAry.concat(numAry2); //새로운 배열을 만들자
//numAry 에 numAry2 을 추가해보기
numAry2.forEach(num => numAry.push(num));

console.log(numAry);

//reduce
