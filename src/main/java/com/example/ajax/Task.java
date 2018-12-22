package com.example.ajax;


public class Task {
	private String description;
	private String date;
	private boolean completed;
	
	Task(){
		
	}

	public Task(String description, String date, boolean completed) {
		super();
		this.description = description;
		this.date = date;
		this.completed = completed;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}

	
	
}
