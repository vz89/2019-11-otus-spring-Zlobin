drop table if exists book;
create table book (
    id bigint not null,
    title varchar(255),
    genreId bigint
);

drop table if exists genre;
create table genre(
    id bigint not null,
    name varchar(255)
);