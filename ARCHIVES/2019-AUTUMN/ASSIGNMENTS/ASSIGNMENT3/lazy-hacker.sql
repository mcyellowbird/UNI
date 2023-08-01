CREATE TABLE order_detail AS (SELECT * FROM ORDER_DETAIL);

DELETE FROM order_detail
WHERE order_id = 267;

INSERT INTO order_detail VALUES(249,'Singaporean Hokkien Fried Mee', 0.0, 0.0, 0.0);

DELETE FROM ORDER_DETAIL;

INSERT INTO ORDER_DETAIL( SELECT * FROM order_detail);

INSERT INTO ORDER_DETAIL VALUES(251, 'Manjimup Dried Apples', 0.0, 0.0, 0.0);
INSERT INTO ORDER_DETAIL VALUES(250, 'Singaporean Hokkien Fried Mee', 0.0, 0.0, 0.0);

UPDATE ORDER_DETAIL
SET unit_price = unit_price + 1, quantity = quantity + 1
WHERE order_id = 248;

DELETE FROM order_detail;

DROP TABLE order_detail;

COMMIT;
