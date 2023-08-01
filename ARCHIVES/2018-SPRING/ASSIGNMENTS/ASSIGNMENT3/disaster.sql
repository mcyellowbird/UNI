SELECT * 
FROM Department
WHERE DNumber IN (1, 2, 3);

DELETE FROM DeptLocation
WHERE DNumber = 5;

UPDATE Department
SET Manager = '00187' 
where DNumber = 3;

UPDATE Department
SET MSDate = STR_TO_DATE('01/10/2018', '%d/%m/%Y') 
where DNumber = 5;

UPDATE Department
SET DName = 'PEOPLE RESOURCES' 
where DNumber = 4;

INSERT INTO Department VALUES (6, 'SUPPORT', '00103', STR_TO_DATE('12/10/2016', '%d/%m/%Y'));

INSERT INTO DeptLocation VALUES (6, '121 Gipps Road, Wollongong, NSW 2500');

SELECT *
FROM DeptLocation 
WHERE DNumber = 1;

INSERT INTO Employee VALUES ('00199', 'Susan', STR_TO_DATE('07/06/1988', '%d/%m/%Y'), '25 Moore street, Wollongong, NSW 2500', 'F', 82.5, '00250', 5);

DELETE FROM Dependent
WHERE ENumber = '00187';

INSERT INTO WorksOn VALUES ('00136', 1004, 10);

SELECT *
FROM Project
WHERE Budget >= 50000;

COMMIT;
