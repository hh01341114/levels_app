document.addEventListener("DOMContentLoaded", function() {
	console.log("JS読み込み成功");

	const userItems = document.querySelectorAll(".user-item");

	userItems.forEach(item => {
		item.addEventListener("click", function() {
			const userName = item.textContent;
			const userId = item.getAttribute("data-userid");

			fetch("/approvals/user-requests?id=" + userId)
				.then(response => {
					if (!response.ok) {
						throw new Error("サーバーエラー");
					}
					// JONに変換
					return response.json();
				})
				.then(data => {
					// ここで data を使って右側に情報を表示
					console.log("取得データ", data);

					// 例: 申請の内容を一覧で表示（仮）
					const requestList = document.getElementById("request-list");
					requestList.innerHTML = ""; 

					data.forEach(request => {
						const li = document.createElement("li");
						li.textContent = `申請種別: ${request.kindLabel}, 対象日: ${request.targetDate}, 提出日: ${request.submittedAt}`;
						requestList.appendChild(li);
					});
				})
				.catch(error => {
					console.error("エラー:", error);
				});
			// データを右側に表示
			document.getElementById("detail-name").textContent = "名前: " + userName;
		});
	});
});