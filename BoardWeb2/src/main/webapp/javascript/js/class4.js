//class4.js

const friend = {
    name: "홍길동",
    age: 20,
    hobbies: ['독서', '운동', '영화'], //배열도 객체임
    pets: [{ name: '야옹이', 
    gender: 'M',
    friends:['검양이','빨양이'] 
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
delete friend.age; //속성지우기
friend.ages = 20;
friend.showFriends = function (){ //메소드 추가도 가능
    console.log(this); //this는 friend 를 가리킴
}
console.log(friend['pets'][0]['friends']); //속성으로 가져오기 가능. .연산자도 가능
