CREATE TABLE TODO
(
    id             BIGSERIAL primary key,
    todo_text    text,
    completed boolean default false
);