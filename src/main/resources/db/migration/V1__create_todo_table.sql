CREATE TABLE todo
(
    id         UUID NOT NULL,
    title     VARCHAR(255)             DEFAULT NULL,
    updated_at TIMESTAMP WITH TIME ZONE DEFAULT NOW(),
    created_at TIMESTAMP WITH TIME ZONE DEFAULT NOW(),
    PRIMARY KEY (id)
)
