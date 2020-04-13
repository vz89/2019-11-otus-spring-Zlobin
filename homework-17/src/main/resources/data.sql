insert into genre (id,name) values (1,'Roman')
insert into genre (id,name) values (2,'Comedy')
insert into genre (id,name) values (3,'Detecctiv')

insert into author (id,name) values (1,'Dostoevskii')
insert into author (id,name) values (2,'Griboedov')
insert into author (id,name) values (3,'Conan Doil')

insert into book (id,title,genre_id,author_id) values (1,'Idiot',1,1)
insert into book (id,title,genre_id,author_id) values (2,'Bad instanse',2,2)
insert into book (id,title,genre_id,author_id) values (3,'Sherlock',3,3)
insert into book (id,title,genre_id,author_id) values (4,'Devils',1,1)

insert into comment (id,text,book_id) values(1,"Good book",1)
insert into comment (id,text,book_id) values(2,"Very good book",1)
insert into comment (id,text,book_id) values(3,"Very intresting",4)