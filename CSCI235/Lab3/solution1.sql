spool solution1
set echo on
set feedback on
set linesize 200
set pagesize 400

/* (1) First, the script modifies the structures of a sample database such that it would be possible to store information 
       about the total number of products supplied by each supplier. The best design is expected in this step. Remember 
       to enforce the appropriate consistency constraints.                                                                      */

CREATE TABLE SUPPLIER_TOTAL (
    SUPPLIER_NAME VARCHAR(40),
    PRODUCTS_SUPPLIED NUMBER(9,0),
    FOREIGN KEY (SUPPLIER_NAME) REFERENCES SUPPLIER(COMPANY_NAME)
);

/* (2) Next, the script saves in a database information about the total number of products supplied by each supplier.           */

INSERT INTO SUPPLIER_TOTAL (SUPPLIER_NAME, PRODUCTS_SUPPLIED)
SELECT UNIQUE SUPPLIER_NAME, COUNT(PRODUCT_NAME)
FROM PRODUCT
GROUP BY SUPPLIER_NAME;

/* (3) Next, the script stores in a data dictionary PL/SQL procedure that can be used to insert a new product into PRODUCT 
       relational table and such that it automatically updates information about the total number of products supplied by 
       each supplier. An efficient implementation of the procedure is expected.                                            

       The values of attributes describing a new product must be passed through the input parameters of the procedure.

       At the end, the stored procedure must commit inserted and updated information.

       Remember to put / in the next line after CREATE OR REPLACE PROCEDURE statement and a line show errors in the next line.  */

CREATE OR REPLACE PROCEDURE INSERT_PRODUCT(product IN VARCHAR,
                                           supplier IN VARCHAR,
                                           cat IN VARCHAR,
                                           quantityPU IN VARCHAR,
                                           unitPrice IN NUMBER,
                                           unitStock IN NUMBER,
                                           unitsOnOrder IN NUMBER,
                                           reorderLevel IN NUMBER,
                                           dcStatus IN CHAR) IS
BEGIN
    INSERT INTO PRODUCT VALUES(product, supplier, cat, quantityPU, unitPrice, unitStock, unitsOnOrder, reorderLevel, dcStatus);
    
    --UPDATE SUPPLIER_TOTAL
    --SET PRODUCTS_SUPPLIED = (SELECT COUNT(PRODUCT_NAME) FROM PRODUCT WHERE SUPPLIER_NAME = supplier)
    --WHERE SUPPLIER_NAME = supplier;
    
    COMMIT;
END INSERT_PRODUCT;
/
show errors;

/* (4) Next, the script performs a comprehensive testing of the stored procedure implemented in the previous step. 
       To do so, list information about the total number of products supplied by each supplier before insertion of 
       a new product. Then process the stored procedure and list information about the total number of products supplied 
       by each supplier after insertion of a new product.                                                                       */

SELECT * FROM SUPPLIER_TOTAL;

EXECUTE INSERT_PRODUCT('Soju', 'Tokyo Traders', 'Beverages', '6 - 360 ml bottles', 13.5, 12, 20, 20, 'N');

SELECT * FROM SUPPLIER_TOTAL;

spool off