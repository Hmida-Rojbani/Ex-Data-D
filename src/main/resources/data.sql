INSERT INTO "STARS" VALUES
('John', 'adr1', DATE '1977-12-25', 'M'),
('Steven', 'adr2', DATE '1967-10-02', 'M'),
('Stella', 'adr3', DATE '1997-11-12', 'F'),
('Lora', 'adr4', DATE '1999-01-02', 'F'),
('Monica', 'adr5', DATE '1979-05-30', 'F'),
('Mark', 'adr6', DATE '1996-10-02', 'M');

INSERT INTO "STUDIOS" VALUES
('Std1', 'adr1'),
('Std2', 'adr2'),
('Std3', 'adr3');


INSERT INTO "MOVIES" VALUES
('Movie1', 1, TIME '01:33:19', 2010, 'Std1'),
('Movie2', 0, TIME '01:56:39', 1989, 'Std1'),
('Movie3', 1, TIME '02:02:44', 2005, 'Std1'),
('Movie4', 1, TIME '01:30:19', 2000, 'Std2'),
('Movie5', 0, TIME '01:34:19', 1990, 'Std3');

INSERT INTO "STARS_IN" VALUES
('Movie1', 'John'),
('Movie1', 'Monica'),
('Movie2', 'John'),
('Movie2', 'Lora'),
('Movie3', 'Lora'),
('Movie3', 'Stella'),
('Movie4', 'Monica'),
('Movie4', 'Mark'),
('Movie5', 'John'),
('Movie5', 'Mark');
