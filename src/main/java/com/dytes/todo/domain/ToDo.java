package com.dytes.todo.domain;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Entity;
import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity(name = "todo")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ToDo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String title;

    @CreatedDate
    private OffsetDateTime createdAt;

    @LastModifiedDate
    private OffsetDateTime updatedAt;

    @OneToMany(cascade = {CascadeType.ALL})
    @JoinColumn(name = "todo_id")
    @Builder.Default
    private List<SubTask> subTasks = new ArrayList<>();

    public SubTask addSubtask(String title) {
        var subtask = SubTask.builder().todoId(this.id).title(title).done(false).build();
        if (subTasks == null) {
            subTasks = new ArrayList<>();
        }
        subTasks.add(subtask);

        return subtask;
    }
}
