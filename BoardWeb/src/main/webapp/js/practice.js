/**
 * practice.js 
 */
let apiInfo = []; //[{},{},{}]


console.log('practice 실행중');
fetch('https://api.odcloud.kr/api/15077586/v1/centers?page=1&perPage=284&returnType=JSON&serviceKey=A3x8wqmcNVruYx64bzuPsXWEKlmVEQ0tqxcAlpRlYneaNnw2wDMiV8LoYq2g49Ymgd%2BCufXujIOiBUzwjB0Qbg%3D%3D')
	.then(result => result.json())
	.then(result => {
		console.log(result.data);
		apiInfo = result.data;
		makesidoList()

	})
	.catch(function(err) {
		console.log(err);
	})

let tr = `<tr>${eun}</tr>`;
function test() {
	document.querySelector('#eun tbody').appendChild(tr);
}

function makesidoList() {
	//
	let sidoList = []; //[지역1,지역2,...,지역3 ]
	for (let i = 0; i < apiInfo.length; i++) {
		if (sidoList.indexOf(apiInfo[i].sido) == -1) {
			sidoList.push(apiInfo[i].sido);
		}
	}
	console.log(sidoList);
	let select = document.querySelector('#select');
	console.log(select);
	//시도리스트 개수만큼 태그를 만듦 
	sidoList.forEach(sido => {
		let option = document.createElement('option'); //<option>서울</option> 
		option.innerHTML = sido; //시도 이름을 집어넣음 
		select.appendChild(option);

	})
}
//지역에 해당하는 병원 정보 담기 
let button=document.createElement('button');
button.value='삭제'; 
let options = document.querySelectorAll('option');//<option> 
let fields = ['centerName', 'address', 'facilityName', 'sido'];
document.querySelector('#select').addEventListener('change', function(e) {
	
	let localList = []; // 서울 :[{},{},{}]  
	let local = e.target.value;

	for (let i = 0; i < apiInfo.length; i++) {
		if (apiInfo[i].sido == local) {
			localList.push(apiInfo[i]);
		}
	}
	console.log("병원리스트", localList);
	
	//let tbody = document.querySelector('#tbody');
	let tbody = document.querySelector('#tbody');
	localList.forEach(item => {
		let tr = document.createElement('tr');
		for (let i = 0; i < fields.length; i++) {
			let td = document.createElement('td');
			//	console.log(fields[i]); 
			td.innerHTML = item[fields[i]];
			tr.appendChild(td);
		}
		tr.appendChild(button); 
		console.log(tr);
		tbody.appendChild(tr);
	})
})






