INSERT INTO events (name, description, event_date) VALUES 
('春のミュージックフェスティバル', '素晴らしい音楽イベントをお届けします', '2024-04-01 13:00:00'),
('テックカンファレンス2024', '最新技術のトレンドを学べます', '2024-05-15 10:00:00');

INSERT INTO tickets (event_id, price, total_count, remaining_count) VALUES 
(1, 5000, 100, 80),
(2, 15000, 50, 30); 