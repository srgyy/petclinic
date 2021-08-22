INSERT INTO veterinarian (id, name, specialty) VALUES
	(1, 'Samantha Gibson', 'Cardiology'),
	(2, 'Max Mitchell', 'Dentistry'),
	(3, 'Andrew Knox', 'Surgery'),
	(4, 'Emily Cameron', 'Nutrition'),
	(5, 'Deirdre Wright', 'Parasitology'),
	(6, 'Carolyn Clark', 'Radiology'),
	(7, 'Virginia Coleman', 'Immunology');


INSERT INTO owner (id, address, city, first_name, last_name, telephone) VALUES
	(1, '794 Briarhill Lane', 'Everett', 'Kylie', 'Russell', '7095857300'),
	(2, '3625 Chardonnay Drive', 'Seattle', 'Joe', 	'Skinner', '7431649918'),
	(3, '1850 Main Street', 'Redmond', 'Amelia', 'Bell', '4384313715'),
	(4, '2137 Owagner Lane', 'Seattle', 'Penelope', 'Parr', '9091314532'),
	(5, '2965 University Street', 'Seattle', 'Brandon', 'Howard', '8674731998'),
	(6, '1850 Main Street', 'Redmond', 'Neil', 'Bell', '1795193280'),
	(7, '3627 Conifer Drive', 'Everett', 'Alexandra', 'Bell', '7323570482'),
	(8, '3711 Owagner Lane', 'Seattle', 'Ava', 'Manning', '6227152265'),
	(9, '4788 Scenicview Drive', 'Redmond', 'Rose', 'Harris', '8807181492'),
	(10, '57 Harry Place', 'Seattle', 'Dylan', 'Martin', '0114372800');

SELECT setval('owner_id_seq', max(id)) FROM owner;

INSERT INTO pet_type (id, type) VALUES
	(1, 'bird'),
	(2, 'cat'),
	(3, 'dog'),
	(4, 'hamster'),
	(5, 'lizard'),
	(6, 'snake');

-- CREATE SEQUENCE pet_id_seq
--   start 1
--   increment 1;

INSERT INTO pet (id, birth_date, name, owner_id, type_id) VALUES
	(1, '2010-06-11', 'Kiwi', 1, 1),
	(2, '2012-05-24', 'Bella', 1, 2),
	(3, '2014-06-14', 'Buddy', 3, 3),
	(4, '2016-04-04', 'Biscuit', 4, 4),
	(5, '2018-04-09', 'Axel', 5, 5),
	(6, '2017-06-16', 'Tiki', 6, 1),
	(7, '2015-02-18', 'Charlie', 2, 2),
	(8, '2013-05-11', 'Milo', 8, 3),
	(9, '2011-06-23', 'Rosie', 9, 3),
	(10, '2021-09-21', 'Teddy', 10, 3),
	(11, '2020-06-24', 'Blue', 7, 5),
	(12, '2009-01-18', 'Leo', 5, 2),
	(13, '2010-02-19', 'Diablo', 3, 6);

SELECT setval('pet_id_seq', max(id)) FROM pet;
