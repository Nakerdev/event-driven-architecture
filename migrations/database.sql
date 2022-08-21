CREATE TABLE Users
(
	id INT NOT NULL,
	firstName VARCHAR(255) NOT NULL,
	middleName VARCHAR(255) NOT NULL,
	lastName VARCHAR(255) NOT NULL,
	age INT NOT NULL,
	PRIMARY KEY(id)
);

INSERT INTO Users (id, firstName, middleName, lastName, age)
VALUES (1, 'Pablo', 'Motos', 'Burgos', 57);
