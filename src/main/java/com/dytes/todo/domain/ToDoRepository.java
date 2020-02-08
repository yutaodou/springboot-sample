package com.dytes.todo.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ToDoRepository extends JpaRepository<ToDo, UUID> {
}
