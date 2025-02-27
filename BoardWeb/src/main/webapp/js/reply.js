/**
 * reply.js 
 */

let page = 1; //페이징

//댓글 
function makeReply(reply = {}) {
	let html = `        <li data-id="${reply.replyNo}">
						<span class="col-sm-2">${reply.replyNo}</span>
						<span class="col-sm-5">${reply.reply}</span>
						<span class="col-sm-2">${reply.replyer}</span>
					
							<span class="col-sm-2"><button onclick="deleteRow('${reply.replyNo}')">삭제</button></span>
						  </li>`;
	return html;
}

//댓글삭제 
function deleteRow(rno) {
	if (!confirm("삭제하시겠습니까?")) {
		alert('취소합니다');
		return;
	}
	svc.removeReply(rno,
		function(result) {
			if (result.retCode == 'OK') {
				document.querySelector('li[data-id="' + rno + '"]').remove();
			}
		}
		, function(err) {
			console.log(err);
		})
}

//댓글목룍 출력함수 
function showPageList() {
	svc.replyList({ bno, page },
		function(result) {
			//기존목록 지우기 
			document.querySelectorAll('li[data-id]').forEach(function(element) {
				element.remove();
			});

			let resultAry = result;
			resultAry.forEach(function(reply) {
				let target = document.querySelector('.reply>.content>ul');
				target.insertAdjacentHTML('beforeend', makeReply(reply));
			});
		},
		function(err) {
			console.log(err);
		}
	);
}//end of showPageList

//목록.  
showPageList();
showPagingList();

//페이지 생성 
function showPagingList() {
	svc.makePaging(bno,
		function(result) {
			console.log(result);
			const totalCnt = result.totalCnt;
			// startPage, endPage ,currentPage
			//prev,next 계산  1.. 5  ...10    
			let currPage = page;
			let endPage = Math.ceil(currPage / 10) * 10;
			let startPage = endPage - 9; //endPage가 10이면 start 가 1이다  
			let realEnd = Math.ceil(totalCnt / 5);
			endPage = endPage > realEnd ? realEnd : endPage;
			//이전 이후 페이지 여부 
			let prev = startPage != 1 ? true : false;
			let next = endPage != realEnd ? true : false;
			//링크생성

			let target = document.querySelector('div.footer>nav>ul');
			target.innerHTML = ''; //이전 페이징 정보삭제 
			let html = '';
			//링크생성 
			if (prev) {
				html = `<li class="page-item ">
			               <a class="page-link" data-page="${startPage - 1}">Previous</a>
			            </li>`;
			} else {
				html = `<li class="page-item disabled">
			    <a class="page-link">Previous</a>
			  </li>`;
			}
			target.insertAdjacentHTML('beforeend', html);

			for (let p = startPage; p <= endPage; p++) {
				let html = ` <li class="page-item"><a class="page-link" href="#" data-page="${p}">${p}</a></li>`;
				if (currPage == p) {
					html = `<li class="page-item active" aria-current="page">
					                 <span class="page-link">${currPage}</span>
					             </li>`;

				}	//event 
				target.insertAdjacentHTML('beforeend', html);
			}

			if (next) {
				html = `<li class="page-item ">
						    <a class="page-link" href="# " data-page="${endPage + 1}" >Next</a>
						</li>`;
			} else {
				html = `<li class="page-item disabled">
						    <a class="page-link">Next</a>
						</li>`;
			}
			target.insertAdjacentHTML('beforeend', html);
			addLinkEvent(); //화면의 a태그에 이벤트 등록 
		},
		function(err) {
			console.log(err);
		}
	);
}//end of showPageList(). 

//댓글등록 이벤트  id=addReply
document.querySelector('#addReply').addEventListener('click', function() {
	//글번호:bno,작성자  작성자:logid,댓글 ? 
	const reply = document.querySelector('#reply').value;
	const replyer = logid;
	if (!reply || !replyer) {
		alert('필수입력값을 확인')
		return;
	}
	const parm = { bno, reply, replyer }
	svc.addReply(parm
		, function(result) {
			if (result.retCode == 'OK') {
				const html = makeReply(result.retVal);

				let target = document.querySelector('.reply>.content>ul');

				currPage = 1;
				showPageList();
				showPagingList();

				target.insertAdjacentHTML('beforeend', html);
			} else {
				alert('처리 예외 발생');
			}
		}
		, function(err) { });
});

//페이징목록의 링크()이벤트 [a,a,a,a,a...a]
function addLinkEvent() {
	document.querySelectorAll('div.footer>nav a').forEach(function(item) {
		item.addEventListener('click', function(e) {
			e.preventDefault(); //페이지 이동 차단 
			console.log(e.target.innerHTML);
			page = e.target.getAttribute('data-page'); //링크클릭하면 페이지정보
			showPageList(); //글목록 보여주는것 
			showPagingList();   //페이징 생성 


		});
	});

}



