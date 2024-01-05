// class3.js
// 1. 객체: this는 객체자신.
// 2. function() this는 전역객체(window);
function myFunc() {
    console.log(this);
}
myFunc();

let obj = {}
obj.act = function () {
    this.value = 'default value';

    function innerAct() {
        this.value = 'innerAct value';
        console.log("this.value: " + this.value);
    }

    function innerReact(caller) {
        caller.value = "innerReact value";
        console.log("this.value: " + this.value);
        console.log("caller.value: " + caller.value);
    }
    innerAct();
    console.log("obj 객체의 this.value: " + this.value);

    innerReact(this);
    console.log("obj 객체의 this.value: " + this.value);
}

obj.act();

// window.location.href = "https://www.daum.net";
// 클로저.
function outerFunc(name) {
    let saying = name + ' 안녕!';

    return function () {
        return saying;
    }
}

const closure1 = outerFunc('라이언');
const closure2 = outerFunc('콘');
console.log(closure1());
console.log(closure2());

function getCounter() {
    let cnt = 1;

    return function () {
        cnt++;
        console.log(cnt);
    }
    //increaseCounter();
}
const clo1 = getCounter();
clo1();
clo1();
clo1();