CREATE TABLE system_user (
    id serial primary key,
    firstname VARCHAR(30),
    surname VARCHAR(30),
    username VARCHAR(30),
    password VARCHAR(30),
    favourites TEXT;
    );

CREATE TABLE event (
    id serial primary key, 
    name VARCHAR(30),
    subject_title VARCHAR(30)
);

CREATE TABLE article (
    id SERIAL PRIMARY KEY,    
    articletitle VARCHAR(100),
    description TEXT,
    event_id INT REFERENCES article(id)
);

CREATE TABLE article_element (
    id SERIAL PRIMARY KEY,   
    index INT not NULL,
    text TEXT,
    pictures TEXT,
    article_id INT REFERENCES article_element(id),
);


