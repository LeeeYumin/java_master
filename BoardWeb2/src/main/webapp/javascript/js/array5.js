//array5.js

const ary = [12, 20, 2, 1, 100, 88]
ary.sort((a, b) => {
    //오름차순: -1, 내림차순 : 1
    if(a > b) { //숫자 2개 비교해서 (12랑 20 비교)
        return -1 //if조건을 만족하면 정렬될거
    }else{
        return 1;
    }
});

console.log("Hong" > "Park")
const friends = [
    {name : "Hong", age : 12},
    {name : "Hwang", age : 98},
    {name : "Park", age : 2},
    {name : "Kim", age : 34}
]

friends.sort((a,b) => { //(앞에오는값, 뒤에오는값)
    if(a.age < b.age){
        return -1;
    }else{
        return 1;
    }
})  

console.log(ary);
console.log(friends);