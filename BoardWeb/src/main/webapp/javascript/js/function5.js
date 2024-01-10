//function5.js

//Array.pototype.forEach();
const ary = ['a','b','c']
ary.forEach(function (elem){ //forEach의 매개값으로 함수가 오는 건 정해져 있는 것
    console.log(elem);
})

//간단히 줄이면 이렇게도 가능함 (화살표 함수)
ary.forEach(elem => console.log(elem));

//값이 1개 이상인 경우는 이렇게..? (화살표 함수)
ary.forEach((elem, idx) =>{
    if(idx > 0) {
        console.log(elem);
    }
})

Array.prototype.sum = function(){ //prototype 예제
    console.log(this); //배열 자신을 찍어봄
    let result = 0;
    this.forEach(function(val){
        result += val;
    })
    return result;   
}
const numbers = [1, 2, 3, 4];
console.log('sum: ' + numbers.sum());