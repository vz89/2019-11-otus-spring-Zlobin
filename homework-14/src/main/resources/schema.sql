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

drop table if exists Batch_JOB_EXECUTION_CONTEXT;
drop table if exists Batch_JOB_EXECUTION_PARAMS;
drop table if exists Batch_JOB_EXECUTION_SEQ;
drop table if exists Batch_JOB_SEQ;
drop table if exists Batch_STEP_EXECUTION_CONTEXT;
drop table if exists Batch_STEP_EXECUTION_SEQ;
drop table if exists Batch_STEP_EXECUTION;
drop table if exists Batch_JOB_EXECUTION;
drop table if exists Batch_JOB_INSTANCE;



alter table book
add constraint fk_bookGenre
foreign key (genre_id) references genre(Id);

alter table book
add constraint fk_bookAuthor
foreign key (author_id) references author(Id);

alter table comment
add constraint fk_commentBook
foreign key (book_id) references book(Id) ON delete CASCADE;