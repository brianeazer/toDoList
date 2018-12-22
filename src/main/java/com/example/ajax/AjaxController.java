package com.example.ajax;

import java.util.List;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AjaxController {
	
	@GetMapping("/make")
	public Task makeTask(
			@RequestParam(name="description", required=false) String description) {
		Task task = new Task();
		task.setDescription(description);
		System.out.println(description);
		return task;
	}
}
