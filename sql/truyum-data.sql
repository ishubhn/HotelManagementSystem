use truyum;

/*0.CREATE Table menu_item (unique constraint added to id)*/
-- -----------------------------------------------------
DROP TABLE IF EXISTS menu_item;

CREATE TABLE menu_item (
	menuItemId INT AUTO_INCREMENT PRIMARY KEY,
	title VARCHAR(20),
	price DECIMAL(5,2),
	isActive BOOLEAN,
	dateOfLaunch DATE,
	category VARCHAR(20),
	isFreeDelivery BOOLEAN/*try enum too*/
);

/*0. create CART and USER table*/
DROP TABLE IF EXISTS users;

CREATE TABLE users (
	user_id INT AUTO_INCREMENT PRIMARY KEY,
	user_name VARCHAR(30)
);

DROP TABLE IF EXISTS cart;

CREATE TABLE cart (
	cart_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT,
    menuItem_id INT,
    FOREIGN KEY (user_id) REFERENCES users(user_id),
    foreign key (menuItem_Id) references menu_item(menuItemId)
    );
    
/*1.VIEW MENU ITEM LIST ADMIN*/
/*a. insert data in menu_item*/	/*date: STR_TO_DATE('15-03-2017', '%d-%m-%Y')*/
INSERT INTO menu_item (title, price, isActive, dateOfLaunch, category, isFreeDelivery)
VALUES
('Sandwich', 99.00, TRUE, '2017-03-15', 'Main Course', TRUE),
('Burger', 129.00, TRUE, '2017-12-23', 'Main Course', FALSE),
('Pizza', 149.00, TRUE, '2017-08-21', 'Main Course', FALSE),
('French Fries', 57.00, FALSE, '2017-07-02', 'Starters', TRUE),
('Chocolate Brownie', 32.00, TRUE, '2022-11-02', 'Dessert', TRUE);

/*b. sql query to get all menu items*/
select * from menu_item;

/*2. VIEW MENU ITEM LIST CUSTOMER*/
/*a. get all menu_items where they are after launch date and active*/
select * from menu_item m
where curdate() >= m.dateOfLaunch
and m.isActive = true;

/*3. EDIT MENU ITEM*/
/*a. get a menu item based on MENUITEM ID*/
select * from menu_item m
where m.id = '/*put your id here*/';

/*b. update sql menu items table to update all coloumns values based on id*/
update menu_item m
set m.coloumn_name = 'value'		/*update coloumn name and value, and repeat desired times*/
where m.id = ''; /*putting id is default as safe,to eliminate this feature 'SET SQL_SAFE_UPDATES = 0'*/

/*4. ADD TO CART*/
/*added data - 3 entries for user2 in cart table, while user1 has no entries*/     
insert into users (user_id, user_name)
values (0001, 'user1'),
(0002, 'user2'); 

insert into cart (user_id, menuItem_id)
values (0002, 1),
(0002, 2),
(0002,3);

/*5. VIEW  CART*/
/*a. query to get all menu items in particular users cart*/
-- need to join cart table with menu items table*/
select u.user_id, m.menuItemId, m.title, m.isFreeDelivery, m.price from users u
join cart c on u.user_id = c.user_id
join menu_item m on c.menuItem_id = m.menuItemId;

/*b. quet=ry to get total price of all menuitem in particular users cart*/
select sum(m.price) from users u
join cart c on u.user_id = c.user_id
join menu_item m on c.menuItem_id = m.menuItemId
where u.user_id = 002;


/*6. REMOVE ITEM FROM USER CART*/
/*a. query to remove menuitem from cart based on userID and menuItemId*/
delete from cart where user_Id = "002" and menuItem_Id = "2";