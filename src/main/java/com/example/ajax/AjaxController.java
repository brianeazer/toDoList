package com.example.ajax;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AjaxController {
	
	@Autowired
	TaskDao taskDao;
	
	@GetMapping("/make")
	public List<Task> makeTask(
			@RequestParam(name="description", required=false) String description,
			@RequestParam(name="date", required=false) String date) {
		Task task = new Task();
		task.setDescription(description);
		task.setDate(date);
		if (!description.equals("") && !date.equals("")) {
		taskDao.create(task);
		}
		List<Task> tasks = taskDao.getAllTasksByDate(date);
		return tasks;
	}
	
	@GetMapping("/update")
	public Task update(
			@RequestParam(name="description", required=false) String description,
			@RequestParam(name="completed", required=false) String done) {
		System.out.println("You made it to the update method in AjaxController. The description is" + description + ".");
		Task task = taskDao.findByDescription(description);
		if (done.equals("Done!")) {
			task.setCompleted(true);
		} else {
			task.setCompleted(false);
		}
		System.out.println(task);
		taskDao.updateCompleted(task);
		return task;
	}
}
