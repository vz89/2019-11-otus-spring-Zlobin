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

insert into comment (id,text,book_id,user_id) values(1,"Good book",1,1)
insert into comment (id,text,book_id,user_id) values(2,"Very good book",1,1)
insert into comment (id,text,book_id,user_id) values(3,"Very intresting",1,2)
insert into comment (id,text,book_id,user_id) values(4,"Very very intresting",1,2)

insert into user (id,username,password) values(1,"admin","password")
insert into user (id,username,password) values(2,"user","user")
insert into user (id,username,password) values(3,"user2","user")

insert into user_role (user_id,roles) values (1,"ADMIN")
insert into user_role (user_id,roles) values (2,"USER")
insert into user_role (user_id,roles) values (3,"BANNED_USER")