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
    city_id bigint,
    is_public boolean,
    enable_notification boolean
);

drop table if exists user_role;
create table user_role
(
    user_id bigint,
    role_id bigint
);

drop table if exists role;
create table role
(
    id bigint primary key auto_increment,
    name varchar(50)
);

drop table if exists user;
create table user
(
    id bigint primary key auto_increment,
    username varchar(50) unique,
    password varchar(255),
    first_name varchar(255),
    last_name varchar(255),
    email varchar(320),
    created_date DATE,
    status varchar(20)
);


create table if not exists city
(
    city_name text,
    lat double,
    lng double,
    iso2 char(2),
    iso3 char(3),
    id bigint primary key auto_increment
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
foreign key (user_id) references user(id) ON delete CASCADE;

alter table vacation
add constraint fk_vacationCountry
foreign key (country_id) references country(id);

alter table vacation
add constraint fk_vacationCity
foreign key (city_id) references city(id);

alter table user_role
add constraint fk_user_roleUser
foreign key (user_id) references user(id);

alter table user_role
add constraint fk_user_roleRole
foreign key (role_id) references role(id);