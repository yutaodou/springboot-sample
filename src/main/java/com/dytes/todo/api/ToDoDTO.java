package com.dytes.todo.api;

import com.dytes.todo.domain.ToDo;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.UUID;

import static java.util.stream.Collectors.toList;

@Data
@Builder
public class ToDoDTO {
    private UUID id;
    private String title;
    private List<SubTaskDTO> subtasks;

    public static ToDoDTO fromToDo(ToDo todo) {
        return builder()
            .id(todo.getId())
            .title(todo.getTitle())
            .subtasks(todo.getSubTasks().stream().map(SubTaskDTO::fromSubTask).collect(toList()))
            .build();
    }
}
