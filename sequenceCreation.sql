
CREATE SEQUENCE public.driver_seq
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;
ALTER TABLE public.driver_seq
  OWNER TO helloworld;


CREATE SEQUENCE public.parking_seq
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;
ALTER TABLE public.parking_seq
  OWNER TO helloworld;

  
CREATE SEQUENCE public.transaction_seq
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;
ALTER TABLE public.transaction_seq
  OWNER TO helloworld;
