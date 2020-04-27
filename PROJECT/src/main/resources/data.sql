insert into user (id, username, password, first_name, last_name, email, joined_date)
values (1, 'admin', 'admin', 'Андрей', 'Привет', '123@m.ru', '2020-04-27');



INSERT INTO country (id, iso, name, nicename, iso3, numcode, phonecode) VALUES
(1, 'AF', 'AFGHANISTAN', 'Afghanistan', 'AFG', 4, 93);





insert into vacation (id, title, description, created_date, start_date, end_date, country_id, user_id, is_public)
values (1, 'first vacation', '2 weeks on sandy beaches', '2020-04-27', '2020-06-01','2020-06-14',1, 1, true);
