package com.dytes.todo.api;

import com.dytes.todo.domain.SubTask;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Builder
@Data
public class SubTaskDTO {
    private UUID id;
    private String title;
    private boolean done;

    public static SubTaskDTO fromSubTask(SubTask subTask) {
        return SubTaskDTO.builder()
            .id(subTask.getId())
            .title(subTask.getTitle())
            .done(subTask.isDone()).build();
    }
}
