CREATE TABLE category (id SERIAL NOT NULL, parent_category_id INT DEFAULT NULL, name VARCHAR(255) NOT NULL, isDeleted BOOL DEFAULT FALSE, PRIMARY KEY(id));
CREATE INDEX IDX_64C19C1796A8F92 ON category (parent_category_id);
CREATE TABLE customer (id SERIAL NOT NULL, firstname VARCHAR(255) NOT NULL, lastname VARCHAR(255) NOT NULL, phone VARCHAR(255) DEFAULT NULL, address VARCHAR(255) DEFAULT NULL, password_hash VARCHAR(255) NOT NULL, email VARCHAR(255) NOT NULL, PRIMARY KEY(id), isAdmin BOOL DEFAULT FALSE);
CREATE TABLE item (id SERIAL NOT NULL, name VARCHAR(255) NOT NULL, description VARCHAR(255) NOT NULL, price NUMERIC(10, 0) NOT NULL, created_at TIMESTAMP(0) WITH TIME ZONE NOT NULL, isDeleted BOOL DEFAULT FALSE, PRIMARY KEY(id));
CREATE TABLE item_category (id SERIAL NOT NULL, item_id INT NOT NULL, category_id INT NOT NULL, PRIMARY KEY(id));
CREATE INDEX IDX_6A41D10A126F525E ON item_category (item_id);
        CREATE INDEX IDX_6A41D10A12469DE2 ON item_category (category_id);
CREATE TABLE review (id SERIAL NOT NULL, item_id INT NOT NULL, customer_id INT NOT NULL, rate_score INT NOT NULL, date TIMESTAMP(0) WITH TIME ZONE NOT NULL, text TEXT NOT NULL, PRIMARY KEY(id));
CREATE INDEX IDX_794381C6126F525E ON review (item_id);
        CREATE INDEX IDX_794381C69395C3F3 ON review (customer_id);
CREATE TABLE shopping_basket (id SERIAL NOT NULL, customer_id INT NOT NULL, date TIMESTAMP(0) WITH TIME ZONE DEFAULT NULL, PRIMARY KEY(id));
CREATE INDEX IDX_A9F94AE99395C3F3 ON shopping_basket (customer_id);
CREATE TABLE shopping_basket_item (id SERIAL NOT NULL, basket_id INT NOT NULL, item_id INT NOT NULL, count INT NOT NULL, PRIMARY KEY(id));
CREATE INDEX IDX_5683070D1BE1FB52 ON shopping_basket_item (basket_id);
        CREATE INDEX IDX_5683070D126F525E ON shopping_basket_item (item_id);
ALTER TABLE category ADD CONSTRAINT FK_64C19C1796A8F92 FOREIGN KEY (parent_category_id) REFERENCES category (id) NOT DEFERRABLE INITIALLY IMMEDIATE;
ALTER TABLE item_category ADD CONSTRAINT FK_6A41D10A126F525E FOREIGN KEY (item_id) REFERENCES item (id) NOT DEFERRABLE INITIALLY IMMEDIATE;
ALTER TABLE item_category ADD CONSTRAINT FK_6A41D10A12469DE2 FOREIGN KEY (category_id) REFERENCES category (id) NOT DEFERRABLE INITIALLY IMMEDIATE;
ALTER TABLE review ADD CONSTRAINT FK_794381C6126F525E FOREIGN KEY (item_id) REFERENCES item (id) NOT DEFERRABLE INITIALLY IMMEDIATE;
ALTER TABLE review ADD CONSTRAINT FK_794381C69395C3F3 FOREIGN KEY (customer_id) REFERENCES customer (id) NOT DEFERRABLE INITIALLY IMMEDIATE;
ALTER TABLE shopping_basket ADD CONSTRAINT FK_A9F94AE99395C3F3 FOREIGN KEY (customer_id) REFERENCES customer (id) NOT DEFERRABLE INITIALLY IMMEDIATE;
ALTER TABLE shopping_basket_item ADD CONSTRAINT FK_5683070D1BE1FB52 FOREIGN KEY (basket_id) REFERENCES shopping_basket (id) NOT DEFERRABLE INITIALLY IMMEDIATE;
ALTER TABLE shopping_basket_item ADD CONSTRAINT FK_5683070D126F525E FOREIGN KEY (item_id) REFERENCES item (id) NOT DEFERRABLE INITIALLY IMMEDIATE;
ALTER TABLE shopping_basket ADD UNIQUE (customer_id, date);

CREATE OR REPLACE FUNCTION create_new_basket() RETURNS TRIGGER AS
$BODY$
BEGIN
INSERT INTO
    shopping_basket(customer_id, date)
VALUES((select max(id) from customer),null);

RETURN new;
END;
$BODY$
language plpgsql;
create trigger new_basket after insert on customer
    execute procedure create_new_basket();

--init data insert

insert into customer (id, firstname, lastname, password_hash, email, isadmin)
values(1, 'Dima', 'Ponzel', '1', 'ponzel.dima35@gmail.com', true),
      (2, 'Orest', 'N', '1', 'o@gmail.com', false),
      (3, 'Danya', 'N', '1', 'd@n', false);

insert into item(id, name, description, price, created_at)
values
(1, 'Zakarpatske', 'From west Ukraine!!!! beer not for separatist', 13, current_date),
(2, 'Bila nich', 'not good, pain in bashka in the morning', 15.99, current_date),
(3, 'Sneks', 'Made from potato', 25, current_date),
(4, 'Holodilnik', 'White and big from 3 hostel, KPI', 3500, current_date);

insert into category(id, parent_category_id, name)
VALUES
(1, null, 'alcohol'),
(2, null, 'food'),
(3, 1, 'beer'),
(4, null, 'technic');

insert into item_category(item_id, category_id)
values
(1, 3),
(2, 3),
(3, 2),
(4, 4);

insert into review(item_id, customer_id, rate_score, date, text)
values
(1, 1, 5, current_date, 'Like it'),
(1, 2, 4, current_date, 'Not bed, but Vilinske is better');

