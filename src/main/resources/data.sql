--inserts when not exists

MERGE INTO Ingredients KEY (ID) VALUES ('FLTO', 'Flour Tortilla', 'WRAP');
MERGE INTO Ingredients KEY (ID) VALUES ('COTO', 'Corn Tortilla', 'WRAP');
MERGE INTO Ingredients KEY (ID) VALUES ('GRBF', 'Ground Beef', 'PROTEIN');
MERGE INTO Ingredients KEY (ID) VALUES ('CARN', 'Carnitas', 'PROTEIN');
MERGE INTO Ingredients KEY (ID) VALUES ('TMTO', 'Diced Tomatoes', 'VEGGIES');
MERGE INTO Ingredients KEY (ID) VALUES ('LETC', 'Lettuce', 'VEGGIES');
MERGE INTO Ingredients KEY (ID) VALUES ('CHED', 'Cheddar', 'CHEESE');
MERGE INTO Ingredients KEY (ID) VALUES ('JACK', 'Monterrey Jack', 'CHEESE');
MERGE INTO Ingredients KEY (ID) VALUES ('SLSA', 'Salsa', 'SAUCE');
MERGE INTO Ingredients KEY (ID) VALUES ('SRCR', 'Sour Cream', 'SAUCE');