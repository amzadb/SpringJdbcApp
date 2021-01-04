-- Table: public.coffee_beverages

-- DROP TABLE public.coffee_beverages;

CREATE TABLE public.coffee_beverages
(
    id integer NOT NULL,
    coffee_name text,
    coffee_description text,
    CONSTRAINT coffee_beverages_pkey PRIMARY KEY (id)
)

-- Sample rows of data insertion

INSERT INTO public.coffee_beverages(
		id, coffee_name, coffee_description)
	VALUES (1, 'Espresso', 'Espressos keep developers going in the morning. There are never enough of them.');

INSERT INTO public.coffee_beverages(
		id, coffee_name, coffee_description)
	VALUES (2, 'Cappuccino', 'For the finer moments. Wrap your espresso in a tasty layer of foam.');
	
INSERT INTO public.coffee_beverages(
		id, coffee_name, coffee_description)
	VALUES (3, 'Mocha', 'Mmmmh, chocolate.');

INSERT INTO public.coffee_beverages(
		id, coffee_name, coffee_description)
	VALUES (4, 'Latte', 'If you are more into milk than into foam.');
	
	

-- FUNCTION: public.find_all_coffee_beverages()

-- DROP FUNCTION public.find_all_coffee_beverages();

CREATE OR REPLACE FUNCTION public.find_all_coffee_beverages(
	OUT c_id integer,
	OUT c_name text,
	OUT c_desc text)
    RETURNS SETOF record 
    LANGUAGE 'plpgsql'

    COST 100
    VOLATILE 
    ROWS 1000
AS $BODY$
BEGIN
  RETURN QUERY
  SELECT ID, COFFEE_NAME, COFFEE_DESCRIPTION FROM COFFEE_BEVERAGES;
END;
$BODY$;

-- Running DB Function find_all_coffee_beverages()

select * from find_all_coffee_beverages();

-- FUNCTION: public.find_coffee(integer)

-- DROP FUNCTION public.find_coffee(integer);

CREATE OR REPLACE FUNCTION public.find_coffee(
	IN coffee_id integer,
	OUT c_id integer,
	OUT c_name text,
	OUT c_desc text)
    RETURNS SETOF record 
    LANGUAGE 'plpgsql'

    COST 100
    VOLATILE 
AS $BODY$
begin
	RETURN QUERY
	SELECT ID, COFFEE_NAME, COFFEE_DESCRIPTION 
		from COFFEE_BEVERAGES 
		where ID=coffee_id;
end
$BODY$;

-- Running DB Function find_coffee()

select * from find_coffee(4);