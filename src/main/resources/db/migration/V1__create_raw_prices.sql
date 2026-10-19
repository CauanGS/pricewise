CREATE TABLE raw_prices(
    id BIGSERIAL PRIMARY KEY,
    ean VARCHAR(14) NOT NULL,
    source VARCHAR(50) NOT NULL,
    payload JSONB NOT NULL,
    created_at TIMESTAMPTZ NOT NULL DEFAULT now()
);

CREATE INDEX idx_raw_prices_ean ON raw_prices (ean);
