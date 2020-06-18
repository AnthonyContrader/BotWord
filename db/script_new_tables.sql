CREATE TABLE products (
  prod_id int(11) NOT NULL AUTO_INCREMENT,
  name varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  description varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  quantity int(11) NOT NULL,
  price double(10,2) NOT NULL,
  PRIMARY KEY (prod_id)
);