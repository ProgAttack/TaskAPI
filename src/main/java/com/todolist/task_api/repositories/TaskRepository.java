package com.todolist.task_api.entities.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.todolist.task_api.entities.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {

}
