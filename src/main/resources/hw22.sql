-- выбрать все записи с firstName начинающимся с А
SELECT firstName
FROM customer
WHERE firstName
LIKE 'a%';
--выбрать все записи по стране Ukraine
SELECT *
FROM customer
WHERE customer.country = 'Ukraine'
--выбрать все записи с полом male
SELECT *
FROM customer
WHERE sex = "male";
--обновить страну у всех записей с date of birth до 2000 года на USA
UPDATE customer
SET country = 'USA'
WHERE dateOfBirdth < '2000-01-01';
--удалить все записи со страной Russia
DELETE
FROM customer
WHERE country = 'Russia';
--выбрать все имена, убрать повторяющиеся (если Alex встречается дважды - в выборке должен быть только 1 Alex)
SELECT firstName
FROM customer
GROUP BY firstName;
--выбрать все записи, отсортировать по дате рождения по убыванию
SELECT *
FROM customer
ORDER BY dateOfBirdth DESC ;
