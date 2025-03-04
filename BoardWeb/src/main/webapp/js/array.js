/**
 * arrary.js
 * foreach ,filter,map,reduce 메소드. 
 */
let ary=[
	{id:100,name: "홍길동",score:345},
	{id:101,name: "김말숙",score:432},
	{id:102,name: "최선기",score:232}
]
//reduce 
let result= ary.reduce((acc,item,idx,array)=>{
	console.log(acc); 
	return acc+item.score ;  //acc: accumulator
},0); 
console.log('최종결과:',result); 
result=ary.reduce((acc,item)=>{
	let li=document.createElement('li'); 
	li.innerHTML='id:'+item.id+',name: '+item.name; 
	acc.appendChild(li); 
	return acc; 
}, document.getElementById('list')); 

result=ary.reduce((acc, item) =>{
	return acc>item.score?acc:item.score; 
},0); 
console.log(result); 
result=ary.reduce((acc,item)=>{
	return acc<item.score?acc:item.score;
},500)
console.log('작은값'+result); 
ary.forEach(function(item,idx,array){
	
}); 
//filter 300점이상 
result=ary.reduce((acc,item) =>{
	if(item.score>300){
		acc.push(item);  // [{}] 
	}
	return acc; 
},[]); 

console.log('최종결과: ',result); 





/*
ary.forEach((item,idx,array)=>{
	console.log(item,idx,array); 
})

let filAry=ary.filter(item =>{
	if(item.score>400){
		return true; 
	}
	return false; 
})
console.log(filAry);
//map(ping) ,새로운 데이터 추가 
let mapAry=ary.map(item=>{
	//a:400 b:300 c:그외 
	if(item.score>400){
		item.group='A';
	} else if(item.score>300){
		item.group='B'; 
	}else{
		item.group='C';
	}
	return item; 
}); 

console.log(mapAry); 
*/

