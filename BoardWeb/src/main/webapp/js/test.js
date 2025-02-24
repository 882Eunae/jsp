/**
 * js/test.js 
 * JSON(포멧) 문자열 -객체  
 */
console.log('경로정상');

let json = `{"name":"홍길동","age":20}`;
let obj = JSON.parse(json);
document.querySelector('input[name="name"]').value = obj.name;
document.querySelector('input[name="age"]').value = obj.age;



// 서버(서블릿) - jsp페이지. 
// Asynchronous Javascript And Xml 비동기방식
fetch('testData.do')
	.then(function(result) {
		console.log(result); //body:steream
		return result.json();
	})
	.then(function(result) {
		console.log(result); 	 //자바스크립트 객체 
		document.querySelector('input[name="name"]').value = result.name;
		document.querySelector('input[name="age"]').value = result.age;

	})




