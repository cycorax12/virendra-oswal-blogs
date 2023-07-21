drop table if exists employee;
create table if not exists employee
(
    id   serial primary key,
    name varchar(255) not null,
    department varchar(48) not null,
    salary integer
);

