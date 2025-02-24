/**
 *member.js 
 */
//삭제함수. 
function deleeteRow(id){	
	console.log(id); 
	fetch("removeMember.do?mid="+id)
	.then(function(result){
		
		return result.json();
		
	})
	
	.then(function(result){
		console.log("잘지워짐");
		if(result.retCode=="OK"){
			this.parentElement.parentElement.remove();
		} else if(result.retCode=="NG"){
			alert('삭제오류발생');
		} else{
			alert('알수없는 코드입니다'); 
		}
})//end of deleteRow. 

fetch("testData.do")
	.then(function(result) {
		return result.json(); //stream -> object
	})
	.then(function(result){
		const memberAry=result; 
		memberAry.forEach(function(member){
		const target=document.querySelector('#list');
		const html=`<tr>
		              <td>${member.memberId}</td>
					  <td>${member.passwd}</td>
					  <td>${member.memberName}</td>
					  <td>${member.responsibility}</td>
					  <td><button onclick="deleteRow('${member.memberId}')" class="btn btn-danger">삭제</button></td>
					 </tr>`; 
		target.insertAdjacentHTML('beforeend',html);
						
		});
		
		
		
	})
}
