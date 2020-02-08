package com.dytes.todo.domain;

import com.dytes.todo.share.event.DomainEvent;

import java.util.UUID;

public class ToDoCreatedEvent extends DomainEvent {
    private final UUID id;

    public ToDoCreatedEvent(UUID id) {
        super();
        this.id = id;
    }
}

