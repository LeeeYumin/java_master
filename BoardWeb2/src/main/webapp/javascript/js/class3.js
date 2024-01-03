//class3.js
const ary= []
ary.push(1)
ary.push(2)
ary.push(3) //값 추가 push. 
console.log(ary.find(item=>{ //find : 매개값으로 함수 받는 메소드.
    return item >= 2 //true값 중(조건을 만족하는) 첫번째 요소를 반환. 만족하는 값이 없으면 undefined.
})); 

//p.100~101실습

class Estimate{ //클래스 정의
    constructor(param){ //생성자 
        this.unit = param; //변수값 대입
    }

    //견적가 얻기 메서드
    getEstimate(unittype, width, height){
        let priceinfo = this.unit.find(item=>item.type == unittype);
        return priceinfo.price*width*height;
    }
    //배열에 요소 추가 메서드
    addUnit(unit){
        unit.push(unit);
    }
}

let unitInfo = [{type:"wood", price:100}, {type:"iron", price:300}, {type:"plastic", price:200}];
const estimator = new Estimate(unitInfo); //new 키워드로 클래스 생성, estimator 변수에 담음
let result = estimator.getEstimate('wood', 20, 20);
console.log(result);

// this 1. 객체 안에서 사용되면 객체 자신. 2. function() this 는 전역객체(window);

function myFunc(){
    console.log(this);
}
myFunc();

let obj = {} //객체 선언
obj.act = function(){
    this.value = 'default value'; //여기의 this 는 메소드. value 라는 속성 추가.

    function innerAct(){
        this.value = 'innerAct Value'; //함수 안의 this. 전역변수. 여기의 this는 obj
        console.log("this.value: " + this.value); //innerAct Value
    }

    function innerReact(caller){
        caller.value = "innerReact value";
        console.log("this.value: " + this.value); //innerAct Value
        console.log("caller.value: " + caller.value);
    }
    innerAct();
    console.log("obj 객체의 this.value: " + this.value); //메소드 안임. default value

    innerReact(this);
    console.log("obj 객체의 this.value: " + this.value); //innerREact Value
}

obj.act();

// window.location.href = "https://www.daum.net";//window가 제일 상위에 있는 객체..

//클로저 p.116
function outerFunc(name){
    let saying = name + ' 안녕!'; //값 선언

    return function (){ //함수 리턴
        return saying;
    }
}

const closure1 = outerFunc('라이언');
const closure2 = outerFunc('콘');
console.log(closure1()); //함수 정의문이 담겨짐+()출력
console.log(closure2());

function getCounter(){
    let cnt = 1; //프로그램이 선언되는 시점. 외부에 보여지지 않음 (함수 내부에 선언)

    return function (){
        cnt++;
        console.log(cnt); //함수를 반환해주고 함수 안에서 쓰겠다..?
    }
    //increaseCounter();
}
//getCounter(); //밖에서 호출
const clo1 = getCounter();
clo1();
clo1();
clo1();
