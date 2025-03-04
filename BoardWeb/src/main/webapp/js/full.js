/**
 * full.js  
 */
document.addEventListener('DOMContentLoaded', function() {
	let eventAll = [];
	fetch('calData.do')
		.then(result => result.json())
		.then(result => {
			console.log(result);
			eventAll = result
			fullCalendarFunc();
		})
		.catch(function(err) {
			console.log(err);
		})

	function fullCalendarFunc() {
		var calendarEl = document.getElementById('calendar');

		var calendar = new FullCalendar.Calendar(calendarEl, {
			headerToolbar: {
				left: 'prev,next today',
				center: 'title',
				right: 'dayGridMonth,timeGridWeek,timeGridDay'
			},
			initialDate: '2023-01-12',
			navLinks: true, // can click day/week names to navigate views
			selectable: true,
			selectMirror: true,
			select: function(arg) {
				var title = prompt('Event Title:');
				fetch('insertEvent.do?title=' + title + '&start=' + arg.startStr + '&end=' + arg.endStr)
					.then(result => result.json)
					.then(function(result) {
						if (result.retCode == "OK") {
							if (title) {
								console.log(arg.startStr, arg.endStr, title);
								calendar.addEvent({
									title: title,
									start: arg.start,
									end: arg.end,
									allDay: arg.allDay
								})
								calendar.unselect()

							}
						}
					})
					.catch(function(err) {
						console.log("에러발생");
					})
			},
			eventClick: function(arg) {
				
				if (confirm('Are you sure you want to delete this event?')) {
					//삭제하는값이 같음 
					fetch('deleteCalendar.do?title=' + arg.event.title + '&start=' + arg.event.startStr + '&end=' + arg.event.endStr)
						.then(result => result.json())
						.then(result => {
							if (result.retCode == 'OK') {
								arg.event.remove();
							} else {
								alert('삭제중 예{외');
							}

						})
						.catch(err => console.log(err));
				}

			},
			editable: true,
			dayMaxEvents: true, // allow "more" link when too many events
			events: eventAll
		});
		calendar.render();
	}
});


