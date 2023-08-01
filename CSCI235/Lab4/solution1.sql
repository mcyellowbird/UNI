SPOOL solution1
SET ECHO ON
SET FEEDBACK ON
SET LINESIZE 200
SET PAGESIZE 400
SET SERVEROUTPUT ON

/* (1) First, the script creates the additional database structures to record information about the total number of orders 
       handled by each employee.                                                                                           */

ALTER TABLE EMPLOYEE
ADD TOTAL_ORDERS NUMBER(9,0);

/* (2) Next, the script stores in a sample database information the total number of the total number of orders handled by 
       each employee. The information must be derived from the present contents of a sample database.                      */

UPDATE EMPLOYEE
SET TOTAL_ORDERS = (SELECT COUNT(EMPLOYEE_ID) FROM ORDERS WHERE ORDERS.EMPLOYEE_ID = EMPLOYEE.EMPLOYEE_ID);
		    
/* (3) Next, this script list information about the total number of orders handled by each employee.                       */

SELECT EMPLOYEE_ID, LASTNAME, FIRSTNAME, TOTAL_ORDERS FROM EMPLOYEE;

/* (4) Next, the script creates a row trigger that automatically updates information about the total number of orders 
       handled by each employee whenever a new order is submitted by a customer or an already submitted order is deleted.  */

CREATE OR REPLACE TRIGGER UPDATEEMPLOYEE
AFTER INSERT OR DELETE ON ORDERS
    FOR EACH ROW
BEGIN
    IF INSERTING THEN
        UPDATE EMPLOYEE
        SET TOTAL_ORDERS = (SELECT COUNT(EMPLOYEE_ID) FROM ORDERS WHERE EMPLOYEE_ID = :NEW.EMPLOYEE_ID)
        WHERE EMPLOYEE_ID = :NEW.EMPLOYEE_ID;
    ELSIF DELETING THEN
        UPDATE EMPLOYEE
        SET TOTAL_ORDERS = (SELECT COUNT(EMPLOYEE_ID) FROM ORDERS WHERE EMPLOYEE_ID = :OLD.EMPLOYEE_ID)
        WHERE EMPLOYEE_ID = :OLD.EMPLOYEE_ID;
    END IF;
END;
/

/* (5) Next, the script comprehensively tests the trigger. A test must include at least one insertion of a new order  
       and at least one deletion of an order.   The script must list information about the total number of orders handled 
       by each employee after insertion of a new order and after deletion of an already existing order.                    */

INSERT INTO ORDERS VALUES (386, 'ALFKI', 2, TO_DATE('09-SEP-98', 'DD-MON-YY'), TO_DATE('14-SEP-98', 'DD-MON-YY'), null, null, null, null, null, null, null, null, null);

SELECT EMPLOYEE_ID, LASTNAME, FIRSTNAME, TOTAL_ORDERS FROM EMPLOYEE;

DELETE FROM ORDERS
WHERE ORDER_ID = 386;

SELECT EMPLOYEE_ID, LASTNAME, FIRSTNAME, TOTAL_ORDERS FROM EMPLOYEE;

/* (6) Finally, the script removes from a data dictionary a trigger created in a step (4).                                 */

DROP TRIGGER UPDATEEMPLOYEE;

SPOOL OFF