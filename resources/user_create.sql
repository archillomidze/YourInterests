CREATE TABLE system_user (
    id serial primary key,
    firstname VARCHAR(30),
    surname VARCHAR(30),
    username VARCHAR(30),
    password VARCHAR(30),
    vipstatus BOOLEAN not null
    );

CREATE TABLE event (
    id serial primary key, 
    name VARCHAR(30),
    subject_title VARCHAR(30)
);