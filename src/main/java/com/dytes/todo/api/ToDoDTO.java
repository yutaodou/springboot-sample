package com.dytes.todo.api;

import com.dytes.todo.domain.ToDo;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
@Builder
public class ToDoDTO {
    private UUID id;
    private String title;
    private LocalDate dueDate;

    public static ToDoDTO fromToDo(ToDo todo) {
        return builder().id(todo.getId()).title(todo.getTitle()).dueDate(todo.getDueDate()).build();
    }
}
