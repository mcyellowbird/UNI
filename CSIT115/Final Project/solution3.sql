/*
In this task, we use a sample database available for the final project.

Before you start the implementation of this task, please make sure that you remove all tables in the csit115 database. 
Download the files dbcreate_final.sql and dbdrop_final.sql. Next, process a script file dbdrop_final.sql immediately after the scripts dbcreate_final.sql to refresh a sample database in the csit115 database. 
No report expected from the processing of the scripts dbdrop_final.sql and dbcreate_final.sql.
*/

/* 
(1)	Find all the address and phone number of owners who own the property in Kiama.
*/

SELECT city, street, streetNum, phoneNum
FROM OWNER
WHERE phoneNum IN (SELECT phoneNum
				  FROM PROPERTY
                  WHERE city = "Kiama");

/* 
(2)	Find the name and phone number of all buyers who have inspected the property in Dapto city.    
*/

SELECT name, phoneNum
FROM BUYER
WHERE phoneNum IN (SELECT phoneNum
				  FROM INSPECTION
                  WHERE pNum IN (SELECT pNum
									FROM PROPERTY
                                    WHERE city = "Dapto"));

/* 
(3)	Update the price of all properties in Wollongong and North Wollongong by 10%.
*/

UPDATE PROPERTY
SET price = (price * 1.1);

/* 
(4)	Remove all information of buyer's named "Bart Smith".  
*/

DELETE FROM INSPECTION
WHERE phoneNum IN (SELECT phoneNum
				  FROM BUYER
                  WHERE name = "Bart Smith");

DELETE FROM BUYER
WHERE name = "Bart Smith";

/* 
(5)	List the name and phone number of all buyers interested in buying in Wollongong city and have inspected the property in the area more than two times.  
*/

SELECT name, phoneNum
FROM BUYER
WHERE phoneNum IN (SELECT phoneNum
				  FROM PREFERENCE
                  WHERE city = "Wollongong")
                  
AND phoneNum IN	(SELECT phoneNum
				FROM INSPECTION
                WHERE pNum IN (SELECT pNum
							  FROM PROPERTY
                              WHERE city = "Wollongong")
				GROUP BY phoneNum
				HAVING COUNT(*) >= 2);

/* 
(6)	Rank the potential buyers in the relational table PREFERENCE based on how frequent the buyer inspected the properties. 
    Note that you should display buyer name, buyer preferred city, maximum price and the frequency that buyer inspects the property in the city.
*/

SELECT B.name, PR.preferredCity, PR.maxPrice, COALESCE(I.cnt, 0) as frequency
FROM BUYER B
LEFT JOIN (SELECT phoneNum, city as preferredCity, maxPrice
	 FROM PREFERENCE) PR
ON B.phoneNum = PR.phoneNum
LEFT JOIN (SELECT phoneNum, COUNT(*) as cnt
	 FROM INSPECTION
     GROUP BY phoneNum) I
ON B.phoneNum = I.phoneNum
ORDER BY frequency DESC;

/* 
(7)	List the property information with the number of inspected buyers. 
    Note that if the property does not have anyone inspected before, then the number should be 0. 
*/

SELECT P.*, COALESCE(I.cnt,0) as inspections
FROM PROPERTY as P
LEFT JOIN (SELECT pNum, COUNT(*) as cnt
	 FROM INSPECTION
     GROUP BY pNum) I
ON P.pNum = I.pNum;

/* 
(8)	Find the buyer information who inspected the property listed after 01 January 2021, and the owner of the property lives in Hurstville city.
*/

SELECT *
FROM BUYER
WHERE phoneNum IN (SELECT phoneNum
				  FROM INSPECTION
                  WHERE inspDate > '2021-01-10'
                  AND pNum IN (SELECT pNum
							  FROM PROPERTY
                              WHERE PROPERTY.phoneNum IN (SELECT phoneNum
												FROM OWNER
                                                WHERE city = "Hurstville")));

/* 
(9) Create a view that calculates the sum of all properties asking prices that the owner has more than one property in the market. 
    The view consists of the sum value, owner’s name, owner's phone number and the number of the properties that he/she owns. 
	After that, display all information in the view.     
*/

CREATE VIEW PROPERTY_TOTALS AS
SELECT O.name, O.phoneNum, P.cnt as totalProperties, P.sumOfProperties
FROM OWNER O
RIGHT JOIN (SELECT phoneNum, COUNT(*) as cnt, SUM(price) as sumOfProperties
	 FROM PROPERTY
     GROUP BY phoneNum) P
ON O.phoneNum = P.phoneNum
WHERE cnt > 1;

SELECT * FROM PROPERTY_TOTALS;

/* 
(10) The owner named "Michael Jones" who live at 12, Gipps road, Rockdale want to inspect the property. 
    Write the INSERT script to insert the above data from the relational table OWNER into the relational table BUYER.  	 
*/

INSERT INTO BUYER (phoneNum, name, city, street, streetNum)
SELECT phoneNum, name, city, street, streetNum
FROM OWNER
WHERE name = "Michael Jones";