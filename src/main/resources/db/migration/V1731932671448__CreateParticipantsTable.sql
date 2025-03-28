CREATE TABLE participants (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP NOT NULL,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    credit_card_info VARCHAR(255),
    participation_type VARCHAR(255) NOT NULL,
    event_id BIGINT NOT NULL,
    ticket_id BIGINT NOT NULL,
    CONSTRAINT fk_participants_event FOREIGN KEY (event_id) REFERENCES events(id),
    CONSTRAINT fk_participants_ticket FOREIGN KEY (ticket_id) REFERENCES tickets(id)
);