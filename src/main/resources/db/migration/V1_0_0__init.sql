CREATE TABLE EXAMPLE
(
    id             BIGSERIAL primary key,
    example_text    text,
    example_int     integer,
    example_date    date,
    example_boolean boolean
);

CREATE TABLE IMAGE
(
    id         BIGSERIAL primary key,
    url        text,
    example_id bigint
        references EXAMPLE
)
