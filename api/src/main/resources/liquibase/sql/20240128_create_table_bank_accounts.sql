create table IF NOT EXISTS bank_accounts (
    user_id uuid NOT NULL,
    balance int NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users (user_id)
);