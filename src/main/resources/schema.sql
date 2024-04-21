create table if not exists customer
(
    id bigserial not null,
    name varchar not null,
    primary key (id)
);
