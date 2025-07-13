document.addEventListener("DOMContentLoaded", function() {
	console.log("JS読み込み成功");

	const userItems = document.querySelectorAll(".user-item");
	const filter = document.getElementById("status-filter");

	// 絞り込みロジック（初期表示含む）
	function applyFilter(status) {
		document.querySelectorAll("#request-list li").forEach(li => {
			const liStatus = li.getAttribute("data-status");
			li.style.display = (liStatus === status) ? "block" : "none";
		});
	}

	// フィルター変更イベントは最初に1度だけ登録
	if (filter) {
		filter.addEventListener("change", function() {
			applyFilter(filter.value);
		});
	}

	userItems.forEach(item => {
		item.addEventListener("click", function() {
			const userName = item.textContent;
			const userId = item.getAttribute("data-userid");

			document.getElementById("user-detail").style.display = "block";

			fetch("/approvals/user-requests?id=" + userId)
				.then(response => {
					if (!response.ok) {
						throw new Error("サーバーエラー");
					}
					return response.json();
				})
				.then(data => {
					const requestList = document.getElementById("request-list");
					requestList.innerHTML = "";

					data.forEach(request => {
						const li = document.createElement("li");
						li.setAttribute("data-status", request.status);

						li.innerHTML = `
							申請種別: ${request.kindLabel}, 対象日: ${request.targetDate}, 提出日: ${request.submittedAt}
							${request.status === "PENDING" ? `
							<form action="/approvals/approve" method="post" style="display:inline;">
								<input type="hidden" name="requestId" value="${request.id}" />
								<button type="submit" name="decision" value="APPROVED">承認</button>
								<button type="submit" name="decision" value="REJECTED">却下</button>
								<button type="submit" name="decision" value="REMAND">差し戻し</button>
							</form>` : `<span>処理済: ${request.status}</span>`}
						`;

						requestList.appendChild(li);

						li.addEventListener("click", function() {
							document.getElementById("requestId").value = request.id;
						});
					});

					// 初期表示：未承認のみ
					applyFilter("PENDING");

					// 名前表示
					document.getElementById("detail-name").textContent = "名前: " + userName;
				})
				.catch(error => {
					console.error("エラー:", error);
				});
		});
	});
});