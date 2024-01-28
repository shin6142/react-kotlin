create table IF NOT EXISTS users (
  user_id uuid NOT NULL, 
  name varchar(20) NOT NULL,
  PRIMARY KEY (user_id)
);