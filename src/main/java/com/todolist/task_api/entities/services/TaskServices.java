package com.todolist.task_api.entities.services;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todolist.task_api.entities.Status;
import com.todolist.task_api.entities.Task;
import com.todolist.task_api.entities.repositories.TaskRepository;

import jakarta.transaction.Transactional;

@Service
public class TaskServices {

	@Autowired
	private TaskRepository repository;
	
	public List<Task> findAll(){
		return this.repository.findAll();			
	}
	
	
	public Task findTaskById(Long id) throws Exception {
		return this.repository.findById(id).orElseThrow(() -> new Exception("Usuário não encontrado"));
	}
	
	@Transactional
	public Task createTask(Task task) {
		task.setStatus(Status.PENDING);
		task.setCreatedAt(LocalDateTime.now());
		return repository.save(task);
	}
	
	public Task updateTaskStatus(Long id, Status newStatus) throws Exception {
		Task task = repository.findById(id).orElseThrow(() -> new Exception ("Tarefa não encontrada"));
		task.setStatus(newStatus);
		return repository.save(task);

	}
	
	public void deleteTask(Long id) {
		repository.deleteById(id);
	}
	
	
}

	
