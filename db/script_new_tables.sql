DROP TABLE IF EXISTS `users`;
DROP TABLE IF EXISTS `products`;
DROP TABLE IF EXISTS `shopping_lists`;

CREATE TABLE users (
  user_id int(11) NOT NULL AUTO_INCREMENT,
  user_user varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  user_type varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  user_password varchar(50) NOT NULL,
  user_name varchar(50) NOT NULL,
  user_surname varchar(50) NOT NULL,
  user_address varchar(50) NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='Insert all users';

CREATE TABLE products (
  prod_id int(11) NOT NULL AUTO_INCREMENT,
  name varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  description varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  quantity int(11) NOT NULL,
  price double(10,2) NOT NULL,
  category varchar(25) NOT NULL,
  PRIMARY KEY (prod_id)
);

CREATE TABLE shopping_lists (
  shopping_list_id int(11) NOT NULL AUTO_INCREMENT,
  user_id int(11) NOT NULL,
  total_price double(10,2) NOT NULL,
  shopping_list JSON NOT NULL,
  PRIMARY KEY (shopping_list_id)
);

INSERT INTO users VALUES (1,'admin','admin','admin','Mario','Rossi','Via x'),(2,'user','user','user','Mario','Gialli', 'Piazza y');

INSERT INTO products VALUES (1, "sedia", "ha 4 piedi", 10, 3,20,"mobili"), (2, "tavolo", "ha 4 piedi", 10, 7,20, "mobili"), (3, "martello", "pesa poco", 40, 5,20, "strumenti"),(4, "cacciavite", "è comodo", 40, 2,20,"strumenti") ;

INSERT INTO shopping_lists VALUES (1, 2, 11,80, '{"1": 2, "3": 2}');
