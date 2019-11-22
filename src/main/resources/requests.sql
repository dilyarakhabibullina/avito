CREATE TABLE IF NOT EXISTS houses
(
    id          INTEGER PRIMARY KEY AUTOINCREMENT,
    name        TEXT,
    district    TEXT,
    price       INTEGER CHECK (price > 0),
    underground TEXT,
    rooms       INTEGER CHECK (rooms > 0),
    square      INTEGER
);
INSERT into houses (name, district, price, underground, rooms, square)
VALUES ('flat', 'MidTown', 20000, '53th Street', 3, 71);
INSERT into houses (name, district, price, underground, rooms, square)
VALUES ('apartment', 'DownTown', 15000, '25th Street', 2, 52);
INSERT into houses (name, district, price, underground, rooms, square)
VALUES ('condo', 'CentralPark', 150000, '75th Street', 5, 152);
INSERT into houses (name, district, price, underground, rooms, square)
VALUES ('apartment', 'CentralPark', 170000, '80th Street', 7, 252);
INSERT into houses (name, district, price, underground, rooms, square)
VALUES ('flat', 'ChinaTown', 5000, '4th Street', 1,9);