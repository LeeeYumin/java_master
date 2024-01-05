// string1.js

let str1 = "Hello";
console.log(str1, typeof str1);
let str2 = new String("Hello");
console.log(str2, typeof str2);

console.log(str1 === str2);

console.log(str1.substring(1, 3));

let word = "   Hello, World  ";
console.log(word.trim());
// const obj = new Object(); {}
// const reg = new RegExp(); /값/
console.log(word.replace(/l/g, 'L'));
console.log(word.replace(/\s/g, ''));

word = '  how are you   to day  everyone.  ';
console.log(word.split(' ').filter(val => val).join(' '));
