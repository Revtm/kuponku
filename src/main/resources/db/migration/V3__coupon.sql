CREATE TABLE public.coupon (
	id bigserial NOT NULL,
	merchant_id bigint NOT NULL,
	title varchar NOT NULL,
	code varchar NOT NULL,
	rules text NOT NULL,
	publish_status boolean NOT NULL,
	stock_total int NOT NULL,
	owner_redeem_total int NOT NULL,
	expired_status boolean NOT NULL,
	expired_at timestamp NOT NULL,
	created_at timestamp NOT NULL,
    updated_at timestamp NOT NULL,
	CONSTRAINT coupon_pk PRIMARY KEY (id),
	CONSTRAINT fk_coupon FOREIGN KEY(merchant_id) REFERENCES merchant(id) ON DELETE CASCADE
);