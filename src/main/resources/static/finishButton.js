var finishButtons = document.getElementsByClassName("finishButton");
	var i;
	
	for (i = 0; i < finishButtons.length; i++) {
		finishButtons[i].addEventListener("click", function() {
			if (this.childNodes[3].childNodes[0].innerHTML == "Not completed"){
				this.childNodes[3].childNodes[0].innerHTML = "Done!";
			} else{
				this.childNodes[3].childNodes[0].innerHTML = "Not completed";
			}
			update(this.childNodes[1].innerHTML, this.childNodes[3].childNodes[0].innerHTML);
		});
	}
	
		function update(description, completed){
		// Build the URL.
		var url = "/update";
			url += "?description=" + encodeURIComponent(description) + "&completed=" + encodeURIComponent(completed);
		console.log("FETCH:", url);
		
		// Make the AJAX Request.
		fetch(url)
			.then(response => response.json()) // Parse response as JSON
			.then(function(data) {
				// Handle the response.
				console.log("DATA:", data)
//				fillTable(data);
			});
	}
//	}