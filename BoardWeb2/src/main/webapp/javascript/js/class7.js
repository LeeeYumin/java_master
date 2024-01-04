//class7.js
//class6에서 사용한 기능 정의
import {friend, sum, getMax} from './class6.js'; //export import 하려면 type="module" 붙일것

let n1 = 10, n2 = 20;
console.log(sum(n1, n2));

console.log(getMax(n1, n2));

console.log(friend.showInfo());

