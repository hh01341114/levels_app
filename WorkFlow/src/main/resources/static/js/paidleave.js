document.addEventListener("DOMContentLoaded", function () {
	const filter = document.getElementById("status-filter");
	const requestItems = document.querySelectorAll("#pending-table tr");

	filter.addEventListener("change", function () {
		const selected = filter.value;

		requestItems.forEach(item => {
			const status = item.getAttribute("data-status");
			item.style.display = (selected === "ALL" || status === selected) ? "" : "none";
		});
	});
});