drop table if exists comment;
create table comment
(
    id   bigint primary key auto_increment,
    text varchar(255),
    book_id bigint
);
drop table if exists book;
create table book
(
    id      bigint primary key auto_increment,
    title   varchar(255),
    genre_id bigint,
    author_id bigint
);

drop table if exists genre;
create table genre
(
    id   bigint primary key auto_increment,
    name  varchar(255) unique
);

drop table if exists author;
create table author
(
    id   bigint primary key auto_increment,
    name  varchar(255) unique
);

drop table if exists user;
create table user
(
    id   bigint primary key auto_increment,
    username  varchar(255) unique,
    password varchar(255)
);



alter table book
add constraint fk_bookGenre
foreign key (genre_id) references genre(Id);

alter table book
add constraint fk_bookAuthor
foreign key (author_id) references author(Id);

alter table comment
add constraint fk_commentBook
foreign key (book_id) references book(Id) ON DELETE CASCADE;