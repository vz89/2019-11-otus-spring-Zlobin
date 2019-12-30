insert into genre (id,name) values (1,'Роман')
insert into genre (id,name) values (2,'Комедия')
insert into genre (id,name) values (3,'Детектив')

insert into author (id,name) values (1,'Достоевский')
insert into author (id,name) values (2,'Грибоедов')
insert into author (id,name) values (3,'Конан Дойл')

insert into book (id,title,genreId,authorId) values (1,'Идиот',1,1)
insert into book (id,title,genreId,authorId) values (2,'Горе от ума',2,2)
insert into book (id,title,genreId,authorId) values (3,'Шерлок Холмс',3,3)