SPOOL solution3
SET ECHO ON
SET FEEDBACK ON
SET LINESIZE 300
SET PAGESIZE 5000

-- 1 --
EXPLAIN PLAN FOR 
SELECT *
FROM EMPLOYEE
WHERE (city = 'Perth' OR city = 'Dapto') AND
      (firstname = 'James' or firstname = 'Kate');

SELECT * FROM TABLE(DBMS_XPLAN.DISPLAY);

CREATE INDEX EMPLOYEE_IDX ON EMPLOYEE(city, firstname);

EXPLAIN PLAN FOR 
SELECT *
FROM EMPLOYEE
WHERE (city = 'Perth' OR city = 'Dapto') AND
      (firstname = 'James' or firstname = 'Kate');

SELECT * FROM TABLE(DBMS_XPLAN.DISPLAY);

DROP INDEX EMPLOYEE_IDX;

-- 2 --
EXPLAIN PLAN FOR
SELECT product_name, category_name
FROM PRODUCT;

SELECT * FROM TABLE(DBMS_XPLAN.DISPLAY);

CREATE INDEX PRODUCT_IDX ON PRODUCT(product_name, category_name);

EXPLAIN PLAN FOR
SELECT product_name, category_name
FROM PRODUCT;

SELECT * FROM TABLE(DBMS_XPLAN.DISPLAY);

DROP INDEX PRODUCT_IDX;

-- 3 --
EXPLAIN PLAN FOR
SELECT category_name, sum(unit_price)
FROM PRODUCT
GROUP BY category_name;

SELECT * FROM TABLE(DBMS_XPLAN.DISPLAY);

CREATE INDEX PRODUCT_IDX ON PRODUCT(category_name);

EXPLAIN PLAN FOR
SELECT category_name, sum(unit_price)
FROM PRODUCT
GROUP BY category_name;

SELECT * FROM TABLE(DBMS_XPLAN.DISPLAY);

DROP INDEX PRODUCT_IDX;

-- 4 --
EXPLAIN PLAN FOR
SELECT customer_code, contact_name
FROM CUSTOMER
WHERE company_name LIKE 'X%';

SELECT * FROM TABLE(DBMS_XPLAN.DISPLAY);

CREATE INDEX CUSTOMER_IDX ON CUSTOMER(company_name);

EXPLAIN PLAN FOR
SELECT customer_code, contact_name
FROM CUSTOMER
WHERE company_name LIKE 'X%';

SELECT * FROM TABLE(DBMS_XPLAN.DISPLAY);

DROP INDEX CUSTOMER_IDX;

-- 5 --
EXPLAIN PLAN FOR
SELECT lastname, firstname, title, birthdate, address
FROM EMPLOYEE
ORDER BY birthdate;

SELECT * FROM TABLE(DBMS_XPLAN.DISPLAY);

CREATE INDEX EMPLOYEE_IDX ON EMPLOYEE(lastname, firstname, title, birthdate, address);

EXPLAIN PLAN FOR
SELECT lastname, firstname, title, birthdate, address
FROM EMPLOYEE
ORDER BY birthdate;

SELECT * FROM TABLE(DBMS_XPLAN.DISPLAY);

DROP INDEX EMPLOYEE_IDX;


SPOOL OFF