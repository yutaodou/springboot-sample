CREATE TABLE subtask
(
    id         UUID NOT NULL,
    todo_id    UUID NOT NULL,
    title      VARCHAR(255)             DEFAULT NULL,
    done       BOOLEAN                  DEFAULT FALSE,
    updated_at TIMESTAMP WITH TIME ZONE DEFAULT NOW(),
    created_at TIMESTAMP WITH TIME ZONE DEFAULT NOW(),
    PRIMARY KEY (id)
)
