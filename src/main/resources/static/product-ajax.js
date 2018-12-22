$(function() {
	var productsTable = document.getElementById("products-table");
	var description = document.getElementById("description");
	var button = document.getElementById("button");
	
	// Do a new search whenever user types into the search box.
	button.addEventListener("click", function() {
		doSearch(description.value);
	});
	
	function doSearch(query) {
		// Build the URL.
		var url = "/make";
		if (query) {
			url += "?description=" + encodeURIComponent(query);
		}
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
	
	function fillTable(task) {
		// Clear the table and add rows one by one.
		productsTable.innerHTML = "";
		addRow(task);
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