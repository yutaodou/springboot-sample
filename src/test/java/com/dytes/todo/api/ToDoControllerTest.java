package com.dytes.todo.api;

import com.dytes.todo.domain.ToDo;
import com.dytes.todo.domain.ToDoService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ToDoControllerTest {

    @InjectMocks
    private ToDoController controller;

    @Mock
    private ToDoService toDoService;

    @Test
    void shouldReturnListOfToDo() {
        ToDo todo = ToDo.builder().id(UUID.randomUUID()).title("test todo").build();
        List<ToDo> todoList = List.of(todo);
        when(toDoService.findAll()).thenReturn(todoList);

        List<ToDoDTO> todos = controller.getToDoList();
        assertThat(todos).hasSize(1);

        var actual = todos.get(0);
        assertThat(actual.getId()).isEqualTo(todo.getId());
        assertThat(actual.getTitle()).isEqualTo(todo.getTitle());
    }
}
