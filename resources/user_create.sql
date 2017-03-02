CREATE TABLE system_user (
    id serial primary key,
    firstname VARCHAR(30),
    surname VARCHAR(30),
    username VARCHAR(30),
    password VARCHAR(30),
    vipstatus BOOLEAN not null
    );