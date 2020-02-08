package com.dytes.todo.api;

import com.dytes.todo.domain.ToDo;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class ToDoDTO {
    private UUID id;
    private String title;

    public static ToDoDTO fromToDo(ToDo todo) {
        return builder().id(todo.getId()).title(todo.getTitle()).build();
    }
}
