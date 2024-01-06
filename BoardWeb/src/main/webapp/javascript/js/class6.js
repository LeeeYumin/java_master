//class6.js 
//모듈
function sum(num1, num2) {
    return num1 + num2;
}

function getMax(num1, num2) { //최대값
    return num1 > num2 ? num1 : num2;
}

const friend = {
    name: "hong",
    age: 20,
    showInfo() {
        return `이름은 ${this.name}, 나이는 ${this.age} 입니다.`;
    }
}

export { friend, sum, getMax }; //특정한거만 반환해서 쓸것임. export import 하려면 type="module" 붙일것 (attribute 라고 함)