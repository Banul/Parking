INSERT INTO driver (first_name, surname, meter_active, meter_last_start_time, meter_last_stop_time, PESEL, vehicle_number, vip) VALUES 
('Tadeusz', 'Wajche-Przeloz', 'false', '2017-12-20 23:15:00', '2018-03-01', 1111, 'AAA', 'false');

INSERT INTO driver (first_name, surname, meter_active, meter_last_start_time, meter_last_stop_time, PESEL, vehicle_number, vip) VALUES 
('Barbara', 'Cwierc-Pobozna', 'false', '2018-01-12 23:15:00', '2018-03-01', 2222, 'BBB', 'false');


INSERT INTO driver (first_name, surname, meter_active, meter_last_start_time,meter_last_stop_time, PESEL, vehicle_number, vip) VALUES 
('Jan', 'Nowak', 'false', '2018-02-20 23:15:00', '2018-03-01', 3333, 'CCC', 'true');


INSERT INTO driver (first_name, surname, meter_active, meter_last_start_time,meter_last_stop_time, PESEL, vehicle_number, vip) VALUES 
('Anna', 'Nieznana', 'false', '2018-02-22 14:14:18', '2018-03-01', 4444, 'DDD', 'true');


INSERT INTO driver (first_name, surname, meter_active, meter_last_start_time,meter_last_stop_time, PESEL, vehicle_number, vip) VALUES 
('Krystyna', 'Zdanowicz', 'false', '2018-02-23 18:24:52', '2018-03-01', 5555, 'EEE', 'false');

INSERT INTO driver (first_name, surname, meter_active, meter_last_start_time, meter_last_stop_time, PESEL , vehicle_number, vip) VALUES 
('Adam', 'Mickiewicz', 'false', '2018-01-23 19:14:52', '2018-03-01' , 6666, 'FFF', 'true');


INSERT INTO driver (first_name, surname, meter_active, meter_last_start_time,meter_last_stop_time, PESEL, vehicle_number, vip) VALUES 
('Julian', 'Tuwim', 'false', '2018-01-25 21:14:52', '2018-03-01', 7777, 'GGG', 'true');


INSERT INTO driver (first_name, surname, meter_active, meter_last_start_time,meter_last_stop_time, PESEL, vehicle_number,  vip) VALUES 
('Konrad','Zych', 'false', '2018-01-22 22:44:12', '2018-03-01', 8888, 'HHH', 'false');


INSERT INTO driver (first_name, surname, meter_active, meter_last_start_time,meter_last_stop_time, PESEL, vehicle_number, vip) VALUES 
('Janina', 'Twarda','false', '2018-01-20 19:44:12', '2018-03-01', 9999, 'III', 'true');



INSERT INTO parking (car_limit) VALUES (120);
INSERT INTO parking (car_limit) VALUES (220);
INSERT INTO parking (car_limit) VALUES (80);
INSERT INTO parking (car_limit) VALUES (90);

INSERT INTO transaction (date, parking_id, driver_id, price, currency, transaction_finished) VALUES 
('2017-12-20', 2, 1, 10, 'PLN', 'true');

INSERT INTO transaction (date, parking_id, driver_id, price,  currency, transaction_finished) VALUES 
('2016-11-20', 3, 1, 12, 'PLN', 'true');

INSERT INTO transaction (date, parking_id, driver_id, price,  currency, transaction_finished) VALUES 
('2017-12-21', 2, 2, 20, 'PLN', 'true');

INSERT INTO transaction (date, parking_id, driver_id, price,  currency, transaction_finished) VALUES 
('2018-01-20', 2, 4, 30, 'PLN', 'true');

INSERT INTO transaction (date, parking_id, driver_id, price,  currency, transaction_finished) VALUES 
('2018-01-20', 1, 9, 18, 'PLN', 'true');

INSERT INTO transaction (date, parking_id, driver_id, price,  currency, transaction_finished) VALUES 
('2018-01-20', 2, 7, 40, 'PLN', 'true');

