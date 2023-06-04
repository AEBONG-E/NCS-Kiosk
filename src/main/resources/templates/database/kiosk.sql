USE kiosk;
SHOW DATABASES;
SHOW TABLES;
DESCRIBE menu;
DESCRIBE menu_img;


DROP TABLE Admin;
DROP TABLE menu;
DROP TABLE menu_img;

SELECT * FROM Admin;
SELECT * FROM menu;
SELECT * FROM menu_img;



DROP TABLE Admin;
CREATE TABLE Admin (
    id          VARCHAR(50)     NOT NULL PRIMARY KEY,
    password    VARCHAR(255)    NOT NULL
);
INSERT INTO Admin (id, password) VALUES ('admin', '1111');
SELECT * FROM Admin;

SELECT id, password FROM Admin WHERE id = 'admin';

CREATE TABLE menu (
                      id BIGINT PRIMARY KEY AUTO_INCREMENT,
                      name VARCHAR(100) NOT NULL,
                      price DOUBLE NOT NULL,
                      type VARCHAR(100) NOT NULL,
                      size VARCHAR(100) NOT NULL,
                      menu_options VARCHAR(100) NOT NULL,
                      stock INT NOT NULL,
                      reg_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
                      menu_img_id BIGINT
#                       FOREIGN KEY (menu_img_id) REFERENCES kiosk.menu_img(imgId)
) AUTO_INCREMENT = 1001;

CREATE TABLE menu_img (
                          imgId BIGINT PRIMARY KEY AUTO_INCREMENT,
                          imageName VARCHAR(100) NOT NULL,
                          original_file_name VARCHAR(100) NOT NULL,
                          imageUrl VARCHAR(100) NOT NULL,
                          imagePath VARCHAR(100) NOT NULL,
                          imageBytes BLOB,
                          menu_id BIGINT,
                          CONSTRAINT fk_menu_img_menu_id FOREIGN KEY (menu_id) REFERENCES menu(id)
) AUTO_INCREMENT = 2001;

ALTER TABLE menu_img DROP FOREIGN KEY fk_menu_img_menu_id;
ALTER TABLE menu_img ADD CONSTRAINT fk_menu_img_menu_id FOREIGN KEY (menu_id) REFERENCES menu(id);

DROP TABLE Orders;
CREATE TABLE Orders (
    oid		        BIGINT		PRIMARY KEY	AUTO_INCREMENT,
    menuId		    BIGINT      NOT NULL,
    orderStatus		BOOLEAN     NOT NULL,
    orderCount      INT         NOT NULL,
    regDate		    TIMESTAMP	NOT NULL    DEFAULT	CURRENT_TIMESTAMP,
    FOREIGN KEY (menuId) REFERENCES Menu()
)AUTO_INCREMENT = 3001;
SELECT * FROM Orders;

DROP TABLE Sales;
CREATE TABLE Sales (
    rid		    BIGINT		PRIMARY KEY	AUTO_INCREMENT,
    ordersId	BIGINT      NOT NULL,
    salesCount	INT	        NOT	NULL,
    regDate		TIMESTAMP	NOT NULL    DEFAULT  CURRENT_TIMESTAMP,
    FOREIGN KEY (ordersId) REFERENCES Orders()
)AUTO_INCREMENT = 4001;
SELECT * FROM Sales;