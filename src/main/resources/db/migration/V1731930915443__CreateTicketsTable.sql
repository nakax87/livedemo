CREATE TABLE tickets (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP NOT NULL,
    type VARCHAR(255) NOT NULL,
    price DECIMAL(19, 2) NOT NULL,
    is_free BOOLEAN NOT NULL,
    event_id BIGINT NOT NULL,
    CONSTRAINT fk_tickets_event FOREIGN KEY (event_id) REFERENCES events(id)
);