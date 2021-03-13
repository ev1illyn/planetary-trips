INSERT INTO LOCAL(id, zip_code, country, state, city)
	VALUES(1, '63010-970', 'Brasil', 'CE', 'Juazeiro do Norte');
	
INSERT INTO LOCAL(id, zip_code, country, state, city)
	VALUES(2, '60741-900', 'Brasil', 'CE', 'Fortaleza');
	
INSERT INTO LOCAL(id, zip_code, country, state, city)
	VALUES(3, '58900-000', 'Brasil', 'PB', 'Cajazeiras');
	
INSERT INTO AIRPORT(id, name, address_id, street)
	VALUES(1, 'Aeroporto de Juazeiro do Norte - Orlando Bezerra de Menezes',
	1, 'Av. Virgílio Távora, 4000 - Aeroporto');
	
INSERT INTO AIRPORT(id, name, address_id, street)
	VALUES(2, 'Aeroporto Internacional de Fortaleza - Pinto Martins',
	2, 'Av. Senador Carlos Jereissati, 3000 - Serrinha');
	
INSERT INTO AIRPORT(id, name, address_id, street)
	VALUES(3, 'Aeroporto Regional de Cajazeiras - Pedro Vieira Moreira',
	3, 'Rodovia Transamazônica - Serrinha');
	
INSERT INTO USER(id, name, email, pass, phone_number, local_id, street)
	VALUES(1, 'Evillyn da Silva Oliveira', 'evillyndsoliveiras@gmail.com',
	'secret123', '988132352', 1, 'Francisca da Silva Moreira, 280');
	
INSERT INTO USER(id, name, email, pass, phone_number, local_id, street)
	VALUES(2, 'Emilly da Silva Oliveira', 'emillydsoliveiras@gmail.com',
	'secret123', '988962251', 1, 'Francisca da Silva Moreira, 280');
	
INSERT INTO USER(id, name, email, pass, phone_number, local_id, street)
	VALUES(3, 'Zil Leandro', 'zil@gmail.com',
	'secret123', '988962251', 2, 'Eusébio');
	
INSERT INTO FLIGHT(id, number, available_seats, duration, child_discount, destination_id, departure_id, arrival_date, departure_date, departure_airport_id, arrival_airport_id)
	VALUES(1, 1, 50, '00:40', 5.0, 2, 1, '2021-02-02T12:00:00', '2021-01-01T12:00:00', 3, 3);
	
	
	
	
