package com.todolist.task_api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.todolist.task_api.entities.Status;
import com.todolist.task_api.entities.Task;
import com.todolist.task_api.entities.services.TaskServices;


@RestController
@RequestMapping("/tasks")
public class TaskController {
	
	@Autowired
	public TaskServices taskService;
	
	
	@PostMapping
	public ResponseEntity<Task> createTask(@RequestBody Task task){
		return ResponseEntity.ok(taskService.createTask(task));		
		
	}
	
	@GetMapping
	public ResponseEntity<List<Task>> findAll(){
		return ResponseEntity.ok(taskService.findAll());		
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Task> findTaskById(@PathVariable Long id) throws Exception{
		return ResponseEntity.ok(taskService.findTaskById(id));
		
	}
	
	@PatchMapping("/{id}/status")
	public ResponseEntity<Task> updateTaskStatus(@PathVariable Long id,@RequestParam Status status) throws Exception{
		return ResponseEntity.ok(taskService.updateTaskStatus(id, status));		
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteTask(@PathVariable Long id){
	    taskService.deleteTask(id);  // Chama o serviço para excluir a tarefa
	    return ResponseEntity.noContent().build(); // Retorna status 204 (sem conteúdo) quando a tarefa é deletada com sucesso
	}

	
	
	
	

}
