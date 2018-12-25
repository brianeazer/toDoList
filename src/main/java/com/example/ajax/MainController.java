package com.example.ajax;

import java.util.ArrayList;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import antlr.collections.List;

@Controller
public class MainController {
	
	@Autowired
	TaskDao taskDao;
	
	@RequestMapping("/")
	public ModelAndView goHome() {
		ArrayList<Task> tasks = (ArrayList<Task>) taskDao.getAllTasks();
		TreeMap<String, ArrayList<Task>> tasksMap = new TreeMap<>();
		for (Task task: tasks) {
			if (!tasksMap.containsKey(task.getDate())) {
				ArrayList<Task> tasksOnDay = new ArrayList<>();
				tasksOnDay.add(task);
				tasksMap.put(task.getDate(), tasksOnDay);
			} else {
				String date = task.getDate();
				ArrayList<Task> tasksOnDay = tasksMap.get(date);
				tasksOnDay.add(task);
				tasksMap.put(date, tasksOnDay);
			}
		}
//		System.out.println(tasksMap);
		
		return new ModelAndView("home", "tasksMap", tasksMap);
	}
}
