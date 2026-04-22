use liondb;
show tables;

show databases;
select version();
select current_date();
select current_user();
select user();

create table Book(
id bigint PRIMARY KEY AUTO_INCREMENT,
title VARCHAR(200) NOT NULL,
auther VARCHAR(100) NOT NULL,
publisher VARCHAR(100),
isbn VARCHAR(20) UNIQUE,
price int not null,
publicshed_data  date,
created_at datetime default current_timestamp
);

ALTER TABLE Book
CHANGE publicshed_data published_date date;
DESC Book;

insert into Book(title, auther ,publisher, isbn, price,published_date) 
values
('누가 내머리에 똥쌌어','베르너 홀츠바르트','사계절','11111111',13000,'1999-05-02');
insert into Book(title, auther ,publisher, isbn, price,published_date) 
values
('누가 니 머리에 똥쌌어','베르너 홀츠바르트','사계절','11111112',13000,'2000-05-02'),
('누가 우리 머리에 똥쌌어','베르너 홀츠바르트','사계절','11111113',13000,'2001-05-02'),
('너가 똥쌌어','베르너 홀츠바르트','사계절','11111114',13000,'2002-05-02'),
('싸버렸어','베르너 홀츠바르트','사계절','11111115',13000,'2003-05-02');
