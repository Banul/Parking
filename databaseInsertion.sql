INSERT INTO driver (first_name, surname, meter_active, meter_last_start_time, meter_last_stop_time, cost, vip) VALUES 
('Tadeusz', 'Wajche-Przeloz', 'false', '2017-12-20 23:15:00', '2018-03-01 22:00', 0, 'false');

INSERT INTO driver (first_name, surname, meter_active, meter_last_start_time, meter_last_stop_time,cost, vip) VALUES 
('Barbara', 'Cwierc-Pobozna', 'false', '2018-01-12 23:15:00', '2018-03-01 22:00', 0, 'false');


INSERT INTO driver (first_name, surname, meter_active, meter_last_start_time,meter_last_stop_time, cost, vip) VALUES 
('Jan', 'Nowak', 'false', '2018-02-20 23:15:00', '2018-03-01 22:00', 0,'true');


INSERT INTO driver (first_name, surname, meter_active, meter_last_start_time,meter_last_stop_time, cost, vip) VALUES 
('Anna', 'Nieznana', 'false', '2018-02-22 14:14:18', '2018-03-01 22:00', 0, 'true');


INSERT INTO driver (first_name, surname, meter_active, meter_last_start_time,meter_last_stop_time, cost, vip) VALUES 
('Krystyna', 'Zdanowicz', 'false', '2018-02-23 18:24:52', '2018-03-01 22:00', 0, 'false');


INSERT INTO driver (first_name, surname, meter_active, meter_last_start_time,meter_last_stop_time, cost, vip) VALUES 
('Adam', 'Mickiewicz', 'false', '2018-01-23 19:14:52', '2018-03-01 22:00', 0 ,'true');


INSERT INTO driver (first_name, surname, meter_active, meter_last_start_time,meter_last_stop_time, cost, vip) VALUES 
('Julian', 'Tuwim', 'false', '2018-01-25 21:14:52', '2018-03-01 22:00', 0, 'true');


INSERT INTO driver (first_name, surname, meter_active, meter_last_start_time,meter_last_stop_time, cost,  vip) VALUES 
('Konrad','Zych', 'false', '2018-01-22 22:44:12', '2018-03-01 22:00', 0 , 'false');


INSERT INTO driver (first_name, surname, meter_active, meter_last_start_time,meter_last_stop_time,  cost, vip) VALUES 
('Janina', 'Twarda','false', '2018-01-20 19:44:12', '2018-03-01 22:00', 0 , 'true');


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
('2018-01-20 23:15:00', 2, 4, 30, 'true');

INSERT INTO transaction (date, parking_id, driver_id, price, transaction_finished) VALUES 
('2018-01-20 23:15:00', 1, 9, 18, 'true');

INSERT INTO transaction (date, parking_id, driver_id, price, transaction_finished) VALUES 
('2018-01-20 23:15:00', 2, 7, 40, 'true');

