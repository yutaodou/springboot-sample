package com.dytes.todo.api;

import com.dytes.todo.domain.SubTask;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class SubTaskDTO {
    private String title;
    private boolean done;

    public static SubTaskDTO fromSubTask(SubTask subTask) {
        return SubTaskDTO.builder().title(subTask.getTitle()).done(subTask.isDone()).build();
    }
}
