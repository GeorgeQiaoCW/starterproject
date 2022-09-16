DROP TABLE IF EXISTS BOOK CASCADE;
CREATE TABLE BOOK (
                      id INTEGER AUTO_INCREMENT PRIMARY KEY,
                      name VARCHAR(50) NOT NULL,
                      description VARCHAR(50) NOT NULL,
                      price INTEGER
);