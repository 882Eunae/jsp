/**
 * replyService.js  
 */



const svc = {
	name: "Hong",
	showName: function() {
		return this.name;
	},
	//목록메서드
	replyList: function(bno, successCallback, errorCallback) {
		fetch('replyList.do?bno=' + bno) //목록 데이터를 가져옴 
			.then(result=> result.json()) //화살표함수
			.then(successCallback) //정상처리시 실행함수 
			.catch(errorCallback) //에러시 실행할 함수 

	},
	//등록메서드
	addReply(param={bno,reply,replyer},successCallback, errorCallback) {
		fetch('addReply.do?bno='+param.bno+'&reply='+param.reply+'&replyer='+param.replyer)
		.then(result=> result.json())
		.then(successCallback)
		.catch(errorCallback)
		
	},
	//삭제메서드 
	removeReply(rno=1,successCallback, errorCallback) {
		fetch('removeReply.do?rno=' + rno) //목록 데이터를 가져옴 
					.then(result=> result.json()) //화살표함수
					.then(successCallback) //정상처리시 실행함수 
					.catch(errorCallback) //에러시 실행할 함수 			

	}
}