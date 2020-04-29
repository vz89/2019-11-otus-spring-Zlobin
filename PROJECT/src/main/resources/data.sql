insert into user (id, username, password, first_name, last_name, email, joined_date, status) values
(1, 'admin', '$2a$10$Z5Pcdu/RnKN.mWDcVoTJJur0z1pB3k9Ip/a.W7rvr/ud.g9rBzeYy', 'Андрей', 'Привет', '123@m.ru', '2020-04-20', 'ACTIVE'),
(2, 'user', '$2a$10$Z5Pcdu/RnKN.mWDcVoTJJur0z1pB3k9Ip/a.W7rvr/ud.g9rBzeYy', 'Антон', 'Иванов', '1421@m532.ru', '2020-04-22', 'ACTIVE');



INSERT INTO country (id, iso, name, nicename, iso3, numcode, phonecode) VALUES
(1, 'AF', 'AFGHANISTAN', 'Afghanistan', 'AFG', 4, 93),
(2, 'AL', 'ALBANIA', 'Albania', 'ALB', 8, 355),
(3, 'DZ', 'ALGERIA', 'Algeria', 'DZA', 12, 213),
(4, 'AS', 'AMERICAN SAMOA', 'American Samoa', 'ASM', 16, 1684),
(5, 'AD', 'ANDORRA', 'Andorra', 'AND', 20, 376),
(6, 'AO', 'ANGOLA', 'Angola', 'AGO', 24, 244),
(7, 'AI', 'ANGUILLA', 'Anguilla', 'AIA', 660, 1264),
(8, 'AQ', 'ANTARCTICA', 'Antarctica', NULL, NULL, 0);




insert into vacation (id, title, description, created_date, start_date, end_date, country_id, user_id, is_public) values
(1, 'first vacation', '2 weeks on sandy beaches', '2020-04-27', '2020-06-01','2020-06-14',1, 1, true),
(2, 'свадебное путешествие', 'отдыхать в андорру после свадьбы', '2020-04-28', '2020-07-05','2020-08-04',5, 2, true),
(3, 'антарктика!!', 'научная экспедиция', '2020-04-29', '2020-10-01','2020-10-14',8, 2, true),
(4, 'Посещение Бобруйска', 'Ноу комментс', '2020-04-30', '2020-05-10','2020-05-10',2, 2, false);


insert into role (id, name) values
(1, 'ROLE_ADMIN'),
(2, 'ROLE_USER');

insert into user_role (user_id, role_id) values
(1,1),
(1,2),
(2,2);