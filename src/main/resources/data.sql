-- Categorías
INSERT INTO CATEGORIA (codigo, nombre, descripcion) VALUES ('CAT-2EST', '2 estrellas', 'Servicios básicos, ideal para presupuestos limitados');
INSERT INTO CATEGORIA (codigo, nombre, descripcion) VALUES ('CAT-3EST', '3 estrellas', 'Buena relación calidad-precio');
INSERT INTO CATEGORIA (codigo, nombre, descripcion) VALUES ('CAT-4EST', '4 estrellas', 'Alta calidad y confort');
INSERT INTO CATEGORIA (codigo, nombre, descripcion) VALUES ('CAT-5EST', '5 estrellas', 'Lujo y servicios exclusivos');

-- Hoteles
INSERT INTO HOTEL (codigo, nombre, descripcion, piscina, localidad, categoria_id) VALUES ('HOT-001', 'Hotel Playa', 'Frente al mar', true, 'Valencia', 3);
INSERT INTO HOTEL (codigo, nombre, descripcion, piscina, localidad, categoria_id) VALUES ('HOT-002', 'Hotel Centro', 'En el centro histórico', false, 'Madrid', 2);
INSERT INTO HOTEL (codigo, nombre, descripcion, piscina, localidad, categoria_id) VALUES ('HOT-003', 'Hotel Rural', 'Entorno natural', true, 'Asturias', 1);
INSERT INTO HOTEL (codigo, nombre, descripcion, piscina, localidad, categoria_id) VALUES ('HOT-004', 'Hotel Lujo', 'Exclusivo y elegante', true, 'Sevilla', 4);
INSERT INTO HOTEL (codigo, nombre, descripcion, piscina, localidad, categoria_id) VALUES ('HOT-005', 'Hotel Negocios', 'Cerca del aeropuerto', false, 'Barcelona', 3);
INSERT INTO HOTEL (codigo, nombre, descripcion, piscina, localidad, categoria_id) VALUES ('HOT-006', 'Hotel Familiar', 'Ideal para familias', true, 'Bilbao', 2);


