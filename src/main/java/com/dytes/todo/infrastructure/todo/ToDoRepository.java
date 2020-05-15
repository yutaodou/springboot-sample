package com.dytes.todo.infrastructure.todo;

import com.dytes.todo.domain.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ToDoRepository extends JpaRepository<ToDo, UUID> {
    Optional<ToDo> getById(UUID id);
}
