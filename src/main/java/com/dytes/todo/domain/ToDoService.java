package com.dytes.todo.domain;

import com.dytes.todo.infrastructure.todo.ToDoRepository;
import com.dytes.todo.share.event.DomainEventPublisher;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Slf4j
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

    @Transactional
    public void addSubTask(UUID todoId, String subTaskTitle) {
        var todo = toDoRepository.getById(todoId)
            .orElseThrow(() -> new RuntimeException("ToDo not found: " + todoId));

        var subTask = todo.addSubtask(subTaskTitle);
        toDoRepository.save(todo);

        domainEventPublisher.publish(new SubtaskAddedEvent(todoId, subTask.getId()));
    }

    public Optional<ToDo> getById(UUID todoId) {
        return toDoRepository.getById(todoId);
    }

    public void updateSubTask(UUID todoId, UUID subTaskId, boolean done) {
        var todo = toDoRepository.getById(todoId)
            .orElseThrow(() -> new RuntimeException("ToDo not found: " + todoId));

        todo.markSubTaskDone(subTaskId, done);
        toDoRepository.save(todo);

        domainEventPublisher.publish(new SubTaskUpdateEvent(todoId, subTaskId));
    }
}
