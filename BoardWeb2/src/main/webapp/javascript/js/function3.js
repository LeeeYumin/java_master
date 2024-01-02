//function3.js
//1. 객체생성 :{}
let obj1 ={
    name:"홍길동", 
    age:20,
    showInfo:function(){
        return '이름은 ' + this.name + ', 나이는 ' +this.age;
    }
}

let obj2 ={
    name:"홍길동", //속성:값 계속 선언? 정의? 해줘야함 (중복된 값 계속 선언해줘야 사용가능) 앞에 this 안붙임
    age:20,
    showInfo:function(){
        return '이름은 ' + this.name + ', 나이는 ' +this.age;
    }
}

console.log(obj1.name);
console.log(obj1['age']);
console.log(obj1.showInfo());

//2. 함수를 가지고 객체를 만드는 방식 (객체 선언)
function Member(name, age){ //관례적으로 대문자사용 (생성자함수라고 부름)
    this.name = name; //생성자 통해 객체 생성. this 붙여줘야함 (안붙이면 전역변수(windows 소속되는 변수) 의미함)
    this.age = age;
    this.showInfo = function(){
        return '이름은 ' + this.name + ', 나이는 ' +this.age;
    }
}

let obj3 = new Member("김명철", 22);
let obj4 = new Member("이형섭", 25); //new 붙여주면 객체 만들어주는 의미. new빼면 그냥 함수.
console.log(obj3.showInfo());
console.log(obj4.showInfo());







//3. 클래스로 객체 만드는 방법도 있음