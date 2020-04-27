drop table if exists vacation;
create table vacation
(
    id bigint primary key auto_increment,
    title varchar(50),
    description varchar(255),
    created_date DATE,
    start_date DATE,
    end_date DATE,
    country_id smallint,
    user_id bigint,
    is_public boolean
);

drop table if exists user;
create table user
(
    id   bigint primary key auto_increment,
    username varchar(50),
    password varchar(255),
    first_name varchar(255),
    last_name varchar(255),
    email varchar(320),
    joined_date DATE
);


drop table if exists country;
create table country
(
  id smallint not null auto_increment,
  iso char(2) NOT NULL,
  name varchar(80) NOT NULL,
  nicename varchar(80) NOT NULL,
  iso3 char(3) DEFAULT NULL,
  numcode smallint(6) DEFAULT NULL,
  phonecode int(5) NOT NULL,
  PRIMARY KEY (id)
);

alter table vacation
add constraint fk_vacationUser
foreign key (user_id) references user(id) ON DELETE CASCADE;

alter table vacation
add constraint fk_vacationCountry
foreign key (country_id) references country(id);