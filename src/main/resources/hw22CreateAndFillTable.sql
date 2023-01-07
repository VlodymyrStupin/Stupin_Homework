--Создать таблицу Customer с полями:
--login
--firstName
--lastName
--dateOfBirth
--country
--sex (male/female)
CREATE TABLE customer (login TEXT, firstName TEXT, lastName TEXT, dateOfBirdth DATE, country TEXT, sex TEXT)
--Заполнить таблицу (сделать insert) 10 записями
INSERT INTO customer VALUES
('user1', 'Dominik', 'Tyer', '1995-11-20', 'Poland', 'male'),
('user2', 'Kateryna', 'Onysczenko', '1999-11-20', 'USA', 'female'),
('user3', 'Sergei', 'Bryanskyi', '1995-10-20', 'Russia', 'male'),
('user4', 'Adam', 'Jonson', '1990-11-20', 'USA', 'male'),
('user5', 'Andrii', 'Kozak', '2022-11-20', 'Ukraine', 'male'),
('user6', 'Karol', 'Zydczak', '1984-11-20', 'Poland', 'male'),
('user7', 'Hatwhar', 'Biornson', '1992-04-17', 'Sweden', 'male'),
('user8', 'Anna', 'Nowak', '1977-01-01', 'Spain', 'female'),
('user9', 'Taras', 'Bulba', '1194-05-12', 'Ukraine', 'male'),
('user10', 'Adrian', 'Tartak', '1996-11-20', 'Italy', 'male');

