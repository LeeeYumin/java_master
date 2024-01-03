//class1.js

const obj1 = {
    name: "hong",
    age: 20,
    showInfo(){
        return `이름은 ${this.name} 이고 나이는 ${this.age} 입니다.`; //변수의 값을 읽어올 때 ${this.}
    }
}

//클래스 생성
class Member{
    constructor(name, age){ //생성자(매개값)
        this.name = name; //this. = 매개값으로 불러올거로 객체만드는방법
        this.age = age;
    }
    titles = ['이름','나이']; //필드 선언(매개값을 받겠다) 필요한 메서드 안에서 선언? this 안붙이고 속성 바로 선언함.
    showTitle(){
        this.titles.forEach(item=>{
            console.log(item)
        })
        return undefined;
    }
    showInfo(){
        return `이름은 ${this.name} 이고 나이는 ${this.age} 입니다.`;
    }
}
Member.prototype.showName = function(){ //속성에 기능 구현을 하고 객체를 만들면 참조하고 있는 메소드를 활용해서 기능이 실행됨.
    return `이름은 ${this.name} 입니다.`; //prototype에 showName 메서드.. 방법.. 
}

const obj2 = new Member('홍길동', 20);
console.log(obj2.showInfo());
console.log(obj2.showTitle()); //undefined 출력
