drop table if exists book;
create table book
(
    id      bigint primary key auto_increment,
    title   varchar(255),
    genreId bigint,
    authorId bigint
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