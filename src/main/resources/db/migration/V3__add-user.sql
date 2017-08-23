--POSTGRES-SQL なのでダブルクォーテーション必要
CREATE TABLE IF NOT EXISTS "users"(
     "username" VARCHAR (100) NOT NULL PRIMARY KEY
  , "encoded_password" VARCHAR (255)
);
INSERT INTO users (username,encoded_password) VALUES ('user01','429ba5e31a842b0e7de7346cca30887aa0beb08739540a870a6020bef162d206f3fb1b8bf49977c9');
INSERT INTO users (username,encoded_password) VALUES ('user02','429ba5e31a842b0e7de7346cca30887aa0beb08739540a870a6020bef162d206f3fb1b8bf49977c9');

--ALTER TABLE customers ADD username VARCHAR (100) NOT NULL DEFAULT 'user1';
--ALTER TABLE customers ADD CONSTRAINT FK_CUSTOMERS_USERNAME FOREIGN KEY (username) REFERENCES users;