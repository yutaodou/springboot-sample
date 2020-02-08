package com.dytes.todo;

import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.google.common.eventbus.EventBus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {
    @Bean
    public com.fasterxml.jackson.databind.Module java8TimeModule() {
        return new JavaTimeModule();
    }

    @Bean
    public EventBus eventBus() {
        return new EventBus();
    }
}
