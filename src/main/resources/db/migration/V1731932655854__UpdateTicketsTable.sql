-- Add new columns to the "tickets" table: type, price, is_free
ALTER TABLE tickets
ADD COLUMN type VARCHAR(255) NOT NULL,
ADD COLUMN price DECIMAL(19, 2) NOT NULL,
ADD COLUMN is_free BOOLEAN NOT NULL;