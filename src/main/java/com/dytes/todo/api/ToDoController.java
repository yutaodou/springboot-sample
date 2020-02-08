package com.dytes.todo.api;

import com.dytes.todo.domain.ToDo;
import com.dytes.todo.domain.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
}
