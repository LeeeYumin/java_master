//class4.js

const friend = {
    name: "홍길동",
    age: 20,
    hobbies: ['독서', '운동', '영화'], //배열도 객체임
    pets: [{
        name: '야옹이',
        gender: 'M',
        friends: ['검양이', '빨양이']
    }, {
        name: '멍멍이',
        gender: 'F'
    }],
    showHobby() {
        return `${this.hobbies[0]}, ${this.hobbies[1]}, ${this.hobbies[2]},`; //갯수만큼 looping 돌면서 보여줌
    }
}

console.log(friend.hobbies[1]);
console.log(friend['pets'][0]['name']); //.name 도 가능
friend.pets[0]['friends'][2] = '노량이';
//delete friend.age; //속성지우기
friend.ages = 20; //이런 방법으로도 속성 추가됨.
friend.showFriends = function () { //메소드 추가도 가능
    console.log(this); //this는 friend 를 가리킴
}
console.log(friend['pets'][0]['friends']); //속성으로 가져오기 가능. .연산자도 가능

//1.4일
const fcopy = friend; //참조값 복사. (동일한 객체를 바라보고있어서 2개의 주소값이 같음. fcopy랑 friend랑 같음)
fcopy.age = 22;
console.log(fcopy)

//객체 복사
const fcopy2 = Object.assign({ bloodType: 'O' }, friend); //assign(초기화할객체, 복사할대상객체) : 정적메소드
fcopy2.age = 24;
console.log(fcopy2);

//속성추가방법2
Object.defineProperty(friend, 'height', { //(여기에, 이속성추가,)
    get: function () { //값 가지고 올때 get.
        return this._height;
    },
    set: function (value) { //값을 대입하고 불러오는 속성 추가 get set
        if (value <= 0) {
            alert('error');
        } else {
            this._height = value; //_빼면 자기자신을 계속 호출하는걸로 메모리초과로 오류남 (숨김속성)
        }
    }
});
friend.height = 162;
console.log(friend.height); 