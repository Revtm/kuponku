CREATE TABLE public.user_account (
	id bigserial NOT NULL,
	user_name varchar NOT NULL,
	email varchar NOT NULL,
	"role" int4 NOT NULL,
	"password" varchar NOT NULL,
	status bool NOT NULL,
	created_at timestamp NOT NULL,
	updated_at timestamp NOT NULL,
	CONSTRAINT user_accounts_pk PRIMARY KEY (id)
);