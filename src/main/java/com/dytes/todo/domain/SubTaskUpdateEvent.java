package com.dytes.todo.domain;

import com.dytes.todo.share.event.DomainEvent;
import lombok.Data;

import java.util.UUID;

@Data
public class SubTaskUpdateEvent extends DomainEvent {
    private final UUID todoId;
    private final UUID subTaskId;

    public SubTaskUpdateEvent(UUID todoId, UUID subTaskId) {
        this.todoId = todoId;
        this.subTaskId = subTaskId;
    }
}
