-- New migration file to add columns to the events table

-- ALTER TABLE events ADD COLUMN title VARCHAR(255) NOT NULL; -- This line is commented out because the title column already exists in the events table
ALTER TABLE events ADD COLUMN is_online BOOLEAN NOT NULL;
ALTER TABLE events ADD COLUMN is_onsite BOOLEAN NOT NULL;
ALTER TABLE events ADD COLUMN online_capacity INTEGER;
ALTER TABLE events ADD COLUMN onsite_capacity INTEGER;
ALTER TABLE events ADD COLUMN recruitment_start_date TIMESTAMP NOT NULL;
ALTER TABLE events ADD COLUMN recruitment_end_date TIMESTAMP NOT NULL;
ALTER TABLE events ADD COLUMN total_capacity INTEGER;
ALTER TABLE events ADD COLUMN description VARCHAR(255);
-- status and event_date columns are already added in the reference migration file, so they are not included here