package com.dytes.todo.domain;

import com.dytes.todo.share.event.DomainEvent;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Data
@Getter
@Setter
public class SubtaskAddedEvent extends DomainEvent {
    private final UUID todoId;
    private final UUID subtaskId;

    public SubtaskAddedEvent(UUID todoId, UUID subtaskId) {
        this.todoId = todoId;
        this.subtaskId = subtaskId;
    }
}
