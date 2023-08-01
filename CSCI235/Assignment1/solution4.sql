SPOOL solution4
SET SERVEROUTPUT ON
SET ECHO ON
SET FEEDBACK ON
SET LINESIZE 300
SET PAGESIZE 400

SET SERVEROUTPUT ON

DECLARE
    maxLength NUMBER(2) := 15;
    CURSOR countries IS
        SELECT DISTINCT COUNTRY, COUNT(COUNTRY) AS CUSTOMERS
        FROM CUSTOMER
        GROUP BY COUNTRY
        ORDER BY CUSTOMERS DESC, COUNTRY ASC;
    too_large EXCEPTION;
BEGIN
    DBMS_OUTPUT.PUT_LINE('-----------------------------------------------------------');
    
    FOR curCountry IN countries
    LOOP
        IF countries%NOTFOUND THEN
            EXIT;
        END IF;
        
        IF LENGTH(curCountry.COUNTRY) > 15 THEN
            RAISE too_large;
        END IF;
        
        DBMS_OUTPUT.PUT(RPAD(curCountry.COUNTRY, maxLength, '.'));
        
        FOR custCount IN 1..curCountry.CUSTOMERS
        LOOP
            DBMS_OUTPUT.PUT('*');
        END LOOP;
        
        DBMS_OUTPUT.PUT_LINE('');
    END LOOP;
    
    DBMS_OUTPUT.PUT_LINE('-----------------------------------------------------------');
EXCEPTION
    WHEN too_large THEN
        DBMS_OUTPUT.PUT_LINE('Length of Country is too long');
END;
/

SPOOL OFF