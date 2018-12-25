var acc = document.getElementsByClassName("accordion");
	var buttons = document.getElementsByClassName("btn btn-dark btn-sm");
	var i;
	
	for (i = 0; i < acc.length; i++) {
	  acc[i].addEventListener("click", function() {
		if (this.childNodes[1].childNodes[3].childNodes[0].innerHTML == "view"){
			this.childNodes[1].childNodes[3].childNodes[0].innerHTML = "close";
		} else {
			this.childNodes[1].childNodes[3].childNodes[0].innerHTML = "view";
		}
		 
	    /* Toggle between adding and removing the "active" class,
	    to highlight the button that controls the panel */
		if (buttons[0].innerHTML==="view"){
			buttons.innerHTML = "close";
		}
	    /* Toggle between hiding and showing the active panel */
	    var panel = this.nextElementSibling;
	    if (panel.style.display === "") {
	      panel.style.display = "none";
	    } else {
	      panel.style.display = "";
	    }
	  });
	}