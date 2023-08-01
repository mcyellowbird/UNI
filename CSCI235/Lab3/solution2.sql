spool solution2
set echo on
set feedback on
set linesize 200
set pagesize 400

/* (1) Implement a stored function that finds the total number of distinct products ordered by a customer. Make a customer code 
       a formal parameter of the function.                                                                                     

       For example, if a customer submitted 3 orders with the following contents of each order: [a,b], [b,c,d] and [a,b,d] 
       then the total number of distinct products ordered is 4 because the customer ordered the products a, b, c and d.

       For example, if a customer submitted 2 orders with the following contents of each order: [a,b,c,d] and [a,b,d,e] 
       then the total number of distinct products ordered is 5 because the customer ordered the products a, b, c, d and e.

       If a customer submitted no orders then the function must return a value 0 (zero).                                             */

CREATE OR REPLACE FUNCTION DISTINCT_ORDERS ( custCode IN VARCHAR) RETURN NUMBER IS
    orderCount NUMBER := 0;
BEGIN
    SELECT COUNT(DISTINCT PRODUCT_NAME)
    INTO orderCount
    FROM ORDERS o, ORDER_DETAIL od
    WHERE o.ORDER_ID = od.ORDER_ID AND o.CUSTOMER_CODE = custCode
    GROUP BY CUSTOMER_CODE;
    
    RETURN orderCount;
    
END DISTINCT_ORDERS;
/
show errors;

/*     To test your function, implement the following SELECT statements that use the function.                                

   (2) Find the codes of customers who submitted no distinct products (you may have to insert a new customer to get a nonempty answer). */

SELECT DISTINCT CUSTOMER_CODE, COALESCE(DISTINCT_ORDERS(CUSTOMER_CODE), 0) AS DISTINCT_PRODUCTS
FROM CUSTOMER;

/* (3) Find the codes of customers and the total number of distinct products submitted by each customer such that the total number 
       of distinct products is greater than 1 and less then 5.                                                                          */

SELECT DISTINCT CUSTOMER_CODE, DISTINCT_ORDERS(CUSTOMER_CODE) AS DISTINCT_PRODUCTS
FROM ORDERS
WHERE DISTINCT_ORDERS(CUSTOMER_CODE) > 1 AND DISTINCT_ORDERS(CUSTOMER_CODE) < 5;

/* (4) Find the codes of customers who submitted the largest number of distinct products.                                               */

SELECT DISTINCT CUSTOMER_CODE, DISTINCT_ORDERS(CUSTOMER_CODE) AS DISTINCT_PRODUCTS
FROM ORDERS
WHERE DISTINCT_ORDERS(CUSTOMER_CODE) = (SELECT MAX(DISTINCT_ORDERS(CUSTOMER_CODE)) FROM ORDERS);

spool off