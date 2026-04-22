create table member(
id int auto_increment primary key,
name VARCHAR(25) NOT NULL,
email VARCHAR(25) UNIQUE,
password VARCHAR(25) NOT NULL,
create_at timestamp default now()
);

insert into member values(1,'carami','carami@gmail.com','1234',default,default);
select * from member;

insert into member(name,email,password) values('taeyeop','taeyeop@gmail.com','1111');
insert into member(name,email,password) values
('철수','철수@gmail.com','1111'),
('짱구','짱구@gmail.com','1111'),
('유리','유리@gmail.com','1111'),
('맹구','맹구@gmail.com','1111');