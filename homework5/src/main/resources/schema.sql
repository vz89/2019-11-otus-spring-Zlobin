drop table if exists book;
create table book
(
    id      bigint primary key auto_increment,
    title   varchar(255),
    genreId bigint
);

drop table if exists genre;
create table genre
(
    id   bigint primary key auto_increment,
    name  varchar(255) unique
);