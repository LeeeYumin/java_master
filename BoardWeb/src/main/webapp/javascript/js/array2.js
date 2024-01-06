//array2.js
const numAry = [23, 10, 17, 35, 9];

let result = numAry.reduce((acc, num) => { //(이걸 받아서) => {이거 처리}
    console.log(acc, num);
    return acc + num; //누적값 + 가져오는값
}, 0);

result = numAry.reduce((acc, num) => {
    return acc > num ? acc : num;
}, 0);

//1. 최소값구하기
result = numAry.reduce((acc, num) => {
    return acc < num ? acc : num;
}); //
console.log(`최소값 : ${result}`);

//2. 평균 구하기 (1)
result = numAry.reduce((acc, num) => {
    return (acc + num);
}, 0);
console.log(`평균: ${result / numAry.length}`);

//2. 평균 구하기 (2)
result = numAry.reduce((acc, num, idx) => { //idx는 항상 배열의 크기? 보다 작다
    if (idx == numAry.length - 1) { 
    return (acc + num) / numAry.length;
}
return acc + num;
}, 0);
console.log(`평균: ${result}`);

//3. 10보다 큰 값을 새로운 배열로
result = numAry.reduce((acc, num)=>{
if(num > 10){
    acc.push(num);
}
return acc;
}, []); //[]이 초기값으로 쓰임

console.log(`결과: ${result}`)