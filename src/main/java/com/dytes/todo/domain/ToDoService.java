package com.dytes.todo.domain;

import com.dytes.todo.share.event.DomainEventPublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ToDoService {

    private final ToDoRepository toDoRepository;
    private final DomainEventPublisher domainEventPublisher;

    @Autowired
    public ToDoService(ToDoRepository toDoRepository, DomainEventPublisher domainEventPublisher) {
        this.toDoRepository = toDoRepository;
        this.domainEventPublisher = domainEventPublisher;
    }

    public List<ToDo> findAll() {
        return toDoRepository.findAll();
    }

    @Transactional
    public ToDo createToDo(String title) {
        ToDo todo = ToDo.builder().title(title).build();
        ToDo saved = toDoRepository.save(todo);
        domainEventPublisher.publish(new ToDoCreatedEvent(todo.getId()));
        return saved;
    }
}
