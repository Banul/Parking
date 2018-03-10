
CREATE TABLE public.driver
(
  meter_active boolean,
  first_name character varying(20),
  surname character varying(30),
  id integer NOT NULL DEFAULT nextval('driver_seq'::regclass),
  meter_last_start_time timestamp without time zone,
  meter_last_stop_time timestamp without time zone,
  PESEL integer,
  vehicle_number character varying(15), 
  vip boolean,
  CONSTRAINT "Driver_pkey" PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.driver
  OWNER to helloworld;

  
CREATE TABLE public.parking
(
  id integer NOT NULL DEFAULT nextval('parking_seq'::regclass),
  car_limit integer,
  CONSTRAINT "Parking_pkey" PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.parking
  OWNER to helloworld;

  
  
CREATE TABLE public.transaction
(
  id integer NOT NULL DEFAULT nextval('transaction_seq'::regclass),
  date character varying(20),
  parking_id integer,
  driver_id integer,
  price double precision,
  currency character varying(10),
  transaction_finished boolean,
  CONSTRAINT transaction_pkey PRIMARY KEY (id),
  CONSTRAINT driver_fk FOREIGN KEY (driver_id)
      REFERENCES public.driver (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT parking_fk FOREIGN KEY (parking_id)
      REFERENCES public.parking (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);



CREATE TABLE transaction_aggregate AS 
(SELECT date, SUM(price) as total, currency FROM transaction GROUP BY date, currency);

