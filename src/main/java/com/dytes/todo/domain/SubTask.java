package com.dytes.todo.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

import static javax.persistence.GenerationType.AUTO;

@Entity(name = "subtask")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SubTask {
    @Id
    @GeneratedValue(strategy = AUTO)
    @Column(name = "id")
    private UUID id;

    @Column(name = "todo_id")
    private UUID todoId;

    private String title;

    private boolean done;

    public static SubTask newSubTask(String title) {
        return builder().title(title).done(false).build();
    }
}
