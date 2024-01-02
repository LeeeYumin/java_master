//function.js
//함수 선언식
function sum(num1 = 0, num2 = 0){ //그냥 (num1, num2) 하면 결과는 undefied+undefied=NaN
    let result = 0;
    //result = num1 + num2; //num1 num2는 파라메터(매개변수)
    //console.log(result);
    console.log(arguments); //매개값(몇개인지 모르는 경우)으로 들어온 걸 처리해주는 객체. 해당되는 함수가 실행되는 시점에 따로 변수 선언 안해줘도 출력됨
    if(arguments.length > 2){
        for(let arg=2; arg <arguments.length; arg++) {
            result += arguments[arg];
        }
    }
    return result; //반환값 주고싶다면 이렇게 (함수의 끝)
}

let result = sum(11, 22, 33, 44, 55, 66);
console.log('결과는 ' + result); 

//함수 표현식 (이렇게 처리됨)
let sum2 = function(num1 = 0, num2 = 0){
    let result = num1 + num2;
    return result;
}
console.log('결과 : ' + sum2(10, 20));

let obj1 = {
    name: "Hong",
    point:100
}
let obj2 = {
    name: "Hwang",
    point:80
}

let average = function(obj1={}, obj2={}) {  //obj1={}:객체타입의미
    let result = 0;
    result = (obj1.point + obj2.point) /2;
    return result;
}
console.log('평균값:' + average(obj1, obj2));

let array1 = [10, 20]
let array2 = [30, 40]
let sum3 = function(ary1=[], ary2=[]){ //전체 배열에 있는 값 선언. 어떤 타입이든지 다 올 수 있다
    let result = 0;
    ary1.concat(ary2).forEach(function (val){ //forEach문은 매개값으로 함수를 받는다
        result += val;
    })
    return result;
}
console.log("배열의 총합: " + sum3(array1, array2));

let myfunc = function(callback){ //callback말고 다른거 써도됨(4줄 밑 callback도 맞춰주면된다)
    let result = 0;
    let num1 = 10;
        num2 = 5;
    result = callback(num1, num2);
    return result;
}
let sumfunc = function (n1, n2){
    return n1 + n2;
}
let minusfunc = function (n1, n2){
    return n1 - n2;
}
console.log('함수결과 ' + myfunc(sumfunc));
