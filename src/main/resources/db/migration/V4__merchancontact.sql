CREATE TABLE public.merchant_contact (
	id bigserial NOT NULL,
	merchant_id bigint NOT NULL,
	platform varchar NOT NULL,
	link text NOT NULL,
	created_at timestamp NOT NULL,
    updated_at timestamp NOT NULL,
	CONSTRAINT merchant_contact_pk PRIMARY KEY (id),
	CONSTRAINT fk_merchant_contact FOREIGN KEY(merchant_id) REFERENCES merchant(id) ON DELETE CASCADE
);