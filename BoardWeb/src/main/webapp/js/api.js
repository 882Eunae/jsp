/**
 * api.js
 */
//이벤트 등록 

let centerAll = [];
document.querySelector('#centerlist').addEventListener('change', function(e) {
	console.log('체인지이벤트...');
	let sidoName = e.target.value;//도시이름 
	console.log(sidoName);
	let filterSido = [];
	filterSido = centerAll.reduce((acc, item) => {
		if (item.sido == sidoName) {
			console.log(sidoName);
			acc.push(item);
		}
		return acc;
	}, filterSido);
	console.log(filterSido);
	makeCenterList(filterSido);
})

function makeCenterList(centerAry = []) {
	let fields = ['id', 'centerName', 'phoneNumber', 'sido'];
	centerAry.forEach(center => {
		//tr>td 
		let tr = document.createElement('tr');
		tr.addEventListener('click', item => {
			console.log('클릭발생');
			console.log(center);
			//cosole.log(center.lat,center.lng); 
			let name = center.sido + center.sigungu + '센터';
			window.open('map.do?lat=' + center.lat + '&lng=' + center.lng + '&name=' + name);
		});

		for (let i = 0; i < fields.length; i++) {
			let td = document.createElement('td');
			td.innerHTML = center[fields[i]];
			tr.appendChild(td);
		}
		document.getElementById('list').appendChild(tr);
	});
}
//여기서 우선 모든 정보를 가져옴 
fetch('https://api.odcloud.kr/api/15077586/v1/centers?page=1&perPage=284&returnType=JSON&serviceKey=A3x8wqmcNVruYx64bzuPsXWEKlmVEQ0tqxcAlpRlYneaNnw2wDMiV8LoYq2g49Ymgd%2BCufXujIOiBUzwjB0Qbg%3D%3D')
	.then(result => result.json())
	.then(result => {
		console.log(result.data);
		centerAll = result.data;
		makeSidoList();
	})
	.catch(err => console.log(err));

//시도정보 중복제거후 화면 출력 
function makeSidoList() {
	let sidoList = [];
	for (let i = 0; i < centerAll.length; i++) {
		if (sidoList.indexOf(centerAll[i].sido) == -1) {
			sidoList.push(centerAll[i].sido);
		}
	}
	console.log(sidoList.sort());
	sidoList.forEach(sido => {
		let option = document.createElement('option');
		option.innerHTML = sido;
		document.getElementById('centerlist').appendChild(option);
	})
};

