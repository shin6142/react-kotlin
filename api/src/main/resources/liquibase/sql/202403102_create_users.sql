create table IF NOT EXISTS users (
  user_id uuid NOT NULL,
  created_at timestamp NOT NULL,
  PRIMARY KEY (user_id)
);

create table IF NOT EXISTS user_details (
    user_id uuid NOT NULL,
    username varchar(255) NOT NULL,
    created_at timestamp NOT NULL,
    PRIMARY KEY (user_id),
    FOREIGN KEY (user_id) REFERENCES users (user_id)
);

