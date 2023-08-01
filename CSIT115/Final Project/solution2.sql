/* 
(1) The potential buyer preferred maximum price and minimum price are not less than zeros. The maximum price must not less than the minimum price.
*/

ALTER TABLE PREFERENCE
ADD CONSTRAINT PREFERENCE_CHK CHECK (minPrice >= 0 AND maxPrice >= 0 AND maxPrice >= minPrice);

/*
(2) We want to store email information for buyers. Each buyer has a unique email address.
*/

ALTER TABLE BUYER
ADD COLUMN EMAIL varchar(255) UNIQUE;
    
/*
(3) Use a single SQL statement to create a relational table, and load information of buyer phone number, property number, property city, property street, 
    property street number and asked price by the owner  into the table for the buyers who prefer cities are the same with the property cities, 
	and the price asked by the owner is between the minimum price and the maximum price of the buyers.
    
    Hint: You need to convert a NULL value of decimal to zero, then compare zero with other decimals.
    
    Next, enforce the appropriate consistency constraints on the new table, such as the primary key and foreign keys.
    
    When ready, use a SELECT statement to list the contents of the relational table created.
    
    Finally, drop the relational table created in this subtask.
*/

CREATE TABLE OFFER AS
	SELECT B.phoneNum, P.pNum, P.city, P.street, P.streetNum, P.price
    FROM BUYER AS B, PROPERTY AS P
    WHERE P.city IN (SELECT PREFERENCE.city
					FROM PREFERENCE
                    WHERE B.phoneNum IN (SELECT PREFERENCE.phoneNum
										FROM PREFERENCE)
					AND P.price BETWEEN COALESCE(PREFERENCE.minPrice, 0) AND PREFERENCE.maxPrice);
                    
ALTER TABLE OFFER
ADD CONSTRAINT OFFER_PKEY PRIMARY KEY (pNum, phoneNum),
ADD CONSTRAINT OFFER_FKEY1 FOREIGN KEY (phoneNum) REFERENCES BUYER(phoneNum),
ADD CONSTRAINT OFFER_FKEY2 FOREIGN KEY (pNum) REFERENCES PROPERTY(pNum),
ADD CONSTRAINT OFFER_FKEY3 FOREIGN KEY (city) REFERENCES PROPERTY(city);
    
SELECT *
FROM OFFER;

DROP TABLE OFFER;

/*
(4) Add to a relational table OWNER information about the total number of properties owned by each owner. 
    If an owner has no property, then the total number of properties must be zero (0) for the owner. 
    
	The total number of properties must be a positive number no more than 999.
    
    Use a SELECT statement to list the owner phone number, owner name and the total number of properties in the ascending order of owner name.
    
    Finally, remove the new column that added in this subtask.
*/

ALTER TABLE OWNER
ADD totalProperties int (3) DEFAULT '0' NOT NULL;

UPDATE OWNER
SET totalProperties = (SELECT COUNT(*)
					  FROM PROPERTY
                      WHERE OWNER.phoneNum = PROPERTY.phoneNum);
                      
SELECT phoneNum, name, totalProperties
FROM OWNER
ORDER BY name ASC;

/*
(5) The properties owned by an owner (phone number is 412356789) are no longer available. 
    Delete from the database information about this owner, the properties owned by the owner, and the inspection information related to the properties owned by the owner. 

    Note that you are not allowed to drop or suspend any referential integrity constraints. 

    The deletions of the technician must be implemented as the nested SELECT statements.
*/

DELETE FROM INSPECTION
WHERE pNum IN (SELECT pNum
			  FROM PROPERTY
              WHERE phoneNum IN (SELECT phoneNum
								FROM OWNER
                                WHERE phoneNum = 412356789));

DELETE FROM PROPERTY
WHERE (phoneNum = 412356789);

DELETE FROM OWNER
WHERE (phoneNum = 412356789);