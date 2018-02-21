INSERT INTO driver (first_name, surname, meter_active, meter_last_start_time, vip) VALUES 
('Tadeusz', 'Wajche-Przeloz', 'false', '2017-12-20 23:15:00', 'false');

INSERT INTO driver (first_name, surname, meter_active, meter_last_start_time, vip) VALUES 
('Barbara', 'Cwierc-Pobozna', 'false', '2018-01-12 23:15:00', 'false');


INSERT INTO driver (first_name, surname, meter_active, meter_last_start_time, vip) VALUES 
('Jan', 'Nowak', 'false', '2018-02-20 23:15:00', 'true');


INSERT INTO driver (first_name, surname, meter_active, meter_last_start_time, vip) VALUES 
('Anna', 'Nieznana', 'true', '2018-02-22 14:14:18', 'true');


INSERT INTO driver (first_name, surname, meter_active, meter_last_start_time, vip) VALUES 
('Krystyna', 'Zdanowicz', 'true', '2018-02-23 18:24:52', 'false');


INSERT INTO driver (first_name, surname, meter_active, meter_last_start_time, vip) VALUES 
('Adam', 'Mickiewicz', 'false', '2018-01-23 19:14:52', 'true');


INSERT INTO driver (first_name, surname, meter_active, meter_last_start_time, vip) VALUES 
('Julian', 'Tuwim', 'true', '2018-01-25 21:14:52', 'true');


INSERT INTO driver (first_name, surname, meter_active, meter_last_start_time, vip) VALUES 
('Konrad','Zych', 'false', '2018-01-22 22:44:12', 'false');


INSERT INTO driver (first_name, surname, meter_active, meter_last_start_time, vip) VALUES 
('Janina', 'Twarda','true', '2018-01-20 19:44:12', 'true');


INSERT INTO parking (car_limit) VALUES (120);
INSERT INTO parking (car_limit) VALUES (220);
INSERT INTO parking (car_limit) VALUES (80);
INSERT INTO parking (car_limit) VALUES (90);


INSERT INTO transaction (date, parking_id, driver_id, price, transaction_finished) VALUES 
('2017-12-20 23:15:00', 2, 1, 10, 'true');

INSERT INTO transaction (date, parking_id, driver_id, price, transaction_finished) VALUES 
('2016-11-20 22:11:10', 3, 1, 12, 'true');

INSERT INTO transaction (date, parking_id, driver_id, price, transaction_finished) VALUES 
('2017-12-21 23:15:00', 2, 2, 20, 'true');

INSERT INTO transaction (date, parking_id, driver_id, price, transaction_finished) VALUES 
('2018-01-20 23:15:00', 2, 4, 30, 'false');

INSERT INTO transaction (date, parking_id, driver_id, price, transaction_finished) VALUES 
('2018-01-20 23:15:00', 1, 9, 18, 'false');

INSERT INTO transaction (date, parking_id, driver_id, price, transaction_finished) VALUES 
('2018-01-20 23:15:00', 2, 7, 40, 'false');

