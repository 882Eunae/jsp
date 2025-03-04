/**
 * practice.js 
 */
console.log('practice 실행중'); 
fetch('https://apis.data.go.kr/3450000/wasteFluoLampSepBinService_new/getWasteFluoLampSepBin_v2?serviceKey=A3x8wqmcNVruYx64bzuPsXWEKlmVEQ0tqxcAlpRlYneaNnw2wDMiV8LoYq2g49Ymgd%2BCufXujIOiBUzwjB0Qbg%3D%3D&currentPage=2&perPage=30')
	.then(result =>result.json())
	.then(result => {
		console.log(result.item); 
	})
	.catch(function(err){
		console.log(err);
	})
	
let eun='잘들어갔나..'; 
	
let tr=`<tr>${eun}</tr>`; 	
function test(){		
document.querySelector('#eun tbody').appendChild(tr); }

test(); 