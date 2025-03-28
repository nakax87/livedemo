CREATE TABLE events (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP NOT NULL,
    title VARCHAR(255) NOT NULL,
    is_online BOOLEAN NOT NULL,
    is_onsite BOOLEAN NOT NULL,
    online_capacity INT,
    onsite_capacity INT,
    recruitment_start_date TIMESTAMP NOT NULL,
    recruitment_end_date TIMESTAMP NOT NULL,
    total_capacity INT,
    CONSTRAINT fk_event_tickets FOREIGN KEY (id) REFERENCES tickets(event_id)
);