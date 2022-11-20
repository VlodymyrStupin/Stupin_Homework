SELECT firstName FROM customer WHERE firstName LIKE 'a%';
SELECT country FROM customer;
SELECT * FROM customer WHERE sex = "male";
UPDATE customer
SET country = 'USA'
WHERE dateOfBirdth < '2000-01-01';
DELETE FROM customer
WHERE country = 'Russia';
SELECT firstName 
FROM customer
GROUP BY firstName;
SELECT * FROM customer ORDER BY dateOfBirdth DESC;
