CREATE TABLE persons (
id REAL,
name TEXT PRIMARY KEY,
age INTEGER,
driving_license BOOLEAN
INSERT INTO persons (driving_license) VALUES ('yes')
INSERT INTO persons (driving_license) VALUES ('no')
car TEXT REFERENCES cars (model));

CREATE TABLE cars (
id REAL,
brand TEXT,
model TEXT PRIMARY KEY,
price INTEGER);

SELECT persons.name, persons.age, persons.driving_license, cars.brand, cars.model
FROM persons
FULL JOIN cars ON persons.car = cars.model

