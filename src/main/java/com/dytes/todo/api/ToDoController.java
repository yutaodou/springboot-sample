package com.dytes.todo.api;

import com.dytes.todo.domain.ToDo;
import com.dytes.todo.domain.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("/todos")
public class ToDoController {

    private final ToDoService toDoService;

    @Autowired
    public ToDoController(ToDoService toDoService) {
        this.toDoService = toDoService;
    }

    @GetMapping
    public List<ToDoDTO> getToDoList() {
        return toDoService
            .findAll()
            .stream()
            .map(ToDoDTO::fromToDo)
            .collect(toList());
    }

    @PostMapping
    public ToDoDTO createToDo(CreateToDoRequest request) {
        ToDo toDo = toDoService.createToDo(request.title);
        return ToDoDTO.fromToDo(toDo);
    }

    @PostMapping("/{todoId}/subtasks")
    public ToDoDTO addSubTask(@PathVariable UUID todoId, AddSubTaskRequest request) {
        toDoService.addSubTask(todoId, request.getSubtask());
        return ToDoDTO.fromToDo(toDoService.getById(todoId).get());
    }

    @PostMapping("/{todoId}/subtasks/{subTaskId}")
    public ToDoDTO updateSubTask(@PathVariable UUID todoId,
                                 @PathVariable UUID subTaskId,
                                 UpdateSubTaskRequest request) {
        toDoService.updateSubTask(todoId, subTaskId, request.isDone());
        return ToDoDTO.fromToDo(toDoService.getById(todoId).get());
    }
}
