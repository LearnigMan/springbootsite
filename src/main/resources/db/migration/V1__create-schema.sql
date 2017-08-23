--POSTGRES-SQL なのでダブルクォーテーション必要
CREATE TABLE IF NOT EXISTS "customers"(
    "id" serial PRIMARY KEY
  , "first_name" VARCHAR (30)
  , "last_name" VARCHAR (30)
);