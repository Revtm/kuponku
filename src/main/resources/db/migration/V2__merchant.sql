CREATE TABLE public.merchant (
	id bigserial NOT NULL,
	user_account_id bigint NOT NULL,
	name varchar NOT NULL,
	logo varchar NOT NULL,
	description text NOT NULL,
	address text NOT NULL,
	follower bigint NOT NULL,
	created_at timestamp NOT NULL,
    updated_at timestamp NOT NULL,
	CONSTRAINT merchant_pk PRIMARY KEY (id),
	CONSTRAINT fk_merchant FOREIGN KEY(user_account_id) REFERENCES user_account(id) ON DELETE CASCADE
);