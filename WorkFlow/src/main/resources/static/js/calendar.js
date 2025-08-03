//ページが読まれたときに下記を実行
document.addEventListener('DOMContentLoaded', function() {

	//カレンダーの要素を取得
	const calendarEl = document.getElementById('calendar');

	// オブジェクトを作成 FullCalendar.Calendar() を実行。引数として要素と表示するカレンダーの設定
	const calendar = new FullCalendar.Calendar(calendarEl, {
		initialView: 'dayGridMonth',
		events: [
			{
				title: 'イベント1',
				start: '2023-05-01'
			},
			{
				title: 'イベント2',
				start: '2023-05-05',
				end: '2023-05-07'
			},
			{
				title: 'イベント3',
				start: '2023-04-09T12:30:00',
				allDay: false
			}
		]

	});

	//カレンダーのレンダリング
	calendar.render();
});
