package com.dytes.todo;

import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.google.common.eventbus.EventBus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class ApplicationConfiguration {
    @Bean
    public com.fasterxml.jackson.databind.Module java8TimeModule() {
        return new JavaTimeModule();
    }

    @Bean
    @Scope("singleton")
    public EventBus eventBus() {
        return new EventBus();
    }
}
