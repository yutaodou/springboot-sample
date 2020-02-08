package com.dytes.todo.share.event;

import com.dytes.todo.share.event.DomainEvent;
import com.google.common.eventbus.EventBus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DomainEventPublisher {
    private final EventBus eventBus;

    @Autowired
    public DomainEventPublisher(EventBus eventBus) {
        this.eventBus = eventBus;
    }


    public void publish(DomainEvent event) {
        this.eventBus.post(event);
    }
}
