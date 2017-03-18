CREATE TABLE article_element (
    id SERIAL PRIMARY KEY REFERENCES article(id),
    index INT not NULL,
    text TEXT,
    pictures TEXT
);

CREATE TABLE article (
    id SERIAL PRIMARY KEY REFERENCES event(id),
    articletitle VARCHAR(100),
    description TEXT
);

CREATE TABLE system_user (
    id serial primary key,
    firstname VARCHAR(30),
    surname VARCHAR(30),
    username VARCHAR(30),
    password VARCHAR(30),
    vipstatus BOOLEAN not null
    favourites TEXT;
    );

CREATE TABLE event (
    id serial primary key, 
    name VARCHAR(30),
    subject_title VARCHAR(30)
);