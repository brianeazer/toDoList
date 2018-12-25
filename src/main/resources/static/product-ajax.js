$(function() {
	var productsTable = document.getElementById("products-table");
	var description = document.getElementById("description");
	var date = document.getElementById("date");
	var button = document.getElementById("button1");
	// Do a new search whenever user types into the search box.
	button.addEventListener("click", function() {
		doSearch();
	});
	
	function doSearch() {
		// Build the URL.
		var url = "/make";
			url += "?date=" + encodeURIComponent(date.value) + "&description=" + encodeURIComponent(description.value);
		console.log("FETCH:", url);
		
		// Make the AJAX Request.
		fetch(url)
			.then(response => response.json()) // Parse response as JSON
			.then(function(data) {
				// Handle the response.
				console.log("DATA:", data)
				fillTable(data);
			});
	}
	
	function fillTable(tasks) {
		// Clear the table and add rows one by one.
		productsTable.innerHTML = "";
		tasks.forEach(addRow);
	}
	
	function addRow(task) {
		// Add a row to the table.
		productsTable.insertAdjacentHTML('beforeend', `
			<tr>
			  <td>${task.date}</td>
			  <td>${task.description}</td>
			  <td>${task.completed ? 'Yes' : 'No'}</td>
			</tr>
		`);
	}

});