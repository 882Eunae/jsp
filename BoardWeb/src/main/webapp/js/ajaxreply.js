/**
 * ajaxreply.js
 *  views/member/manager.jsp
 */
/*document.addEventListener('DOMContentLoaded', function() {
	document.querySelector('.form-control').addEventListener('click', function() {
			fetch('/ajaxReply.do')
			.then(result => result.json())
			.then(result=>console.log(reulst))
			.catch(function(err) {
				console.log(err);
			})
	})
});
*/

function ajaxMakeReply(reply={}){
	let html=`
	  <a href="#" class="list-group-item list-group-item-action active" aria-current="true" id="${reply.replyer}">
	    <div class="d-flex w-100 justify-content-between">
	      <h5 class="mb-1">${reply.replyer}</h5>
	      <small>${reply.replyDate}</small>
	    </div>
	    <p class="mb-1">${reply.reply}</p>
	    <small>${reply.boardNo}</small>
	  </a>
	 `
}



document.querySelector('.searchbutton').addEventListener('click',function(){
	
	let who=document.querySelector('.inputwho').value; 
	fetch(`/ajaxReply.do?who=${who}`)
		  .then(result => result.json()) //객체로만듦 
		  .then(function(result){
			let  replyList=result; 
			replyList.forEach(function(reply){
				console.log(reply)
				ajaxMakeReply(reply)
			})
		  })
		  .catch(function(err){
			console.log(err)
		  })
})



new DataTable('#example', {
		initComplete: function() {
			    this.api()      //여기서 사용자에 따른 댓글 목록을 찾아옴  원래 this.api
				.columns()
				.every(function() {
					let column = this;
					let title = column.footer().textContent;

					// Create input element
					let input = document.createElement('input');
					input.placeholder = title;
					column.footer().replaceChildren(input);

					// Event listener for user input
					input.addEventListener('keyup', () => {
						if (column.search() !== this.value) {
							column.search(input.value).draw();
						}
					});
				});
		}
	});

