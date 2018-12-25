package com.example.ajax;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;
import com.example.ajax.Task;

@Repository
@Transactional
public class TaskDao {

	@PersistenceContext
	private EntityManager em;
	
	public void create(Task task) {
		em.persist(task);
	}

	public List<Task> getAllTasksByDate(String date) {
		return em.createQuery("FROM Task WHERE date = :date", Task.class)
				.setParameter("date", date)
				.getResultList();
	}

	public List<Task> getAllTasks() {
		return em.createQuery("FROM Task ", Task.class)
				.getResultList();
	}

	public Task findByDescription(String description) {
		try {
			return em.createQuery("FROM Task WHERE description = :description", Task.class)
					.setParameter("description", description)
					.getSingleResult();
		} catch (NoResultException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public void updateCompleted(Task task) {
		em.merge(task);
	}
	
	
}
