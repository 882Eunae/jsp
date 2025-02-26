/**
 *member.js 
 */
//삭제함수. 
function deleteRow(id) {
	console.log(id);
	let btn = this;
	fetch("removeMember.do?mid=" + id)
		.then(function(result) {
			return result.json();
		})

		.then(function(result) {
			console.log(result);
			if (result.retCode == "OK") {
				document.querySelector('#tr_' + id).remove(); //한건 지우기 
			} else if (result.retCode == "NG") {
				alert('삭제오류발생'); //에러. 
			} else {
				alert('알수없는 코드입니다');
			}
		})//end of deleteRow. 
}

fetch("testData.do")
	.then(function(result) {
		console.log(result);
		return result.json();  //stream -> object
	})
	.then(function(result) {
		const memberAry = result;
		memberAry.forEach(function(member) {
			const target = document.querySelector('table.table #list_member');
			const html = `<tr id=tr_${member.memberId}>
		              <td>${member.memberId}</td>
					  <td>${member.passwd}</td>
					  <td>${member.memberName}</td>
					  <td>${member.responsibility}</td>
					  <td><button onclick="deleteRow('${member.memberId}')" class="btn btn-danger">삭제</button></td>
					 </tr>`;
			target.insertAdjacentHTML('beforeend', html);

		});
	})

/*document.querySelector('#addMember').addEventListener('click', function(e) {
	alert('클릭됨');
	

	
	


})





fetch("addMember.do?mid=" + id + "?mpw=" + pw + "?mname=" + name)
	.then(function(result) {
		console.log(result) 
		return result.json();  //  추가한 정보를 객체로 만듬  
	})
	.then (function(result){
		if (result.retCode == "OK") {
						document.querySelector('#tr_' + id).remove(); //한건 지우기 
					} else if (result.retCode == "NG") {
						alert('추가오류발생'); //에러. 
					} else {
						alert('알수없는 코드입니다');
					}
				
		
	})


	.catch(err => console.log(err))


*/
