insert into genre (id,name) values (1,'Роман')
insert into genre (id,name) values (2,'Комедия')
insert into genre (id,name) values (3,'Детектив')

insert into author (id,name) values (1,'Достоевский')
insert into author (id,name) values (2,'Грибоедов')
insert into author (id,name) values (3,'Конан Дойл')

insert into book (id,title,genre_id,author_id) values (1,'Идиот',1,1)
insert into book (id,title,genre_id,author_id) values (2,'Горе от ума',2,2)
insert into book (id,title,genre_id,author_id) values (3,'Шерлок Холмс',3,3)
insert into book (id,title,genre_id,author_id) values (4,'Бесы',1,1)

insert into comment (id,text,book_id) values(1,"Good book",1)
insert into comment (id,text,book_id) values(2,"Very good book",1)
insert into comment (id,text,book_id) values(3,"Very intresting",4)

insert into user (id,username,password) values(1,"admin","password")