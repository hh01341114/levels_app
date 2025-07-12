document.addEventListener("DOMContentLoaded", function() {
	console.log("JS読み込み成功");

	const userItems = document.querySelectorAll(".user-item");

	userItems.forEach(item => {
		item.addEventListener("click", function() {
			const userName = item.textContent;
			const userId = item.getAttribute("data-userid");

			//詳細パネル表示
			document.getElementById("user-detail").style.display = "block";

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
						li.innerHTML = `申請種別: ${request.kindLabel}, 対象日: ${request.targetDate}, 提出日: ${request.submittedAt}
						<form action="/approvals/approve" method="post" style="display:inline;">
							<input type="hidden" name="requestId" value="${request.id}" />
							<button type="submit" name="decision" value="APPROVED">承認</button>
							<button type="submit" name="decision" value="REJECTED">却下</button>
							<button type="submit" name="decision" value="REMAND">差し戻し</button>
						</form>`;
						requestList.appendChild(li);

						li.addEventListener("click", function() {
							document.getElementById("requestId").value = request.id;
						});
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