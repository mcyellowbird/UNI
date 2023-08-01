
/*
Before starting to run this solution, please make sure that you remove all table in csit115 and 
run dbcreate_final.sql to populate the tables and data in the csit115 database. Also, make sure to log in as a root. 
Do not include the process of running  dbcreate_final.sql in the report. 
*/
 
/*
(1)	Create a new database. A name of a new database must be the same as a prefix of your UOW email account. 
    For example, if your UOW email account is xyz111@uowmail.edu.au then a database name must be xyz111. 
	Create a USER table that consists of a username, password and owner name. Let username be the primary key. 
	Extract the owner’s name and phone number from the OWNER table as the owner’s name and username in the USER table, respectively.  
	Let the default password be a username concatenated with "abcd".  Display all rows in the USER table. 
	
    For example, if the username is "42154522", then the password is "42154522abcd".
*/

CREATE DATABASE iem651;

use iem651;

CREATE TABLE USER
(
username VARCHAR(50) NOT NULL,
password VARCHAR(50) NOT NULL,
ownerName VARCHAR(50) NOT NULL,

CONSTRAINT USER_PKEY PRIMARY KEY (username)
);

INSERT INTO USER (username, password, ownerName)
SELECT phoneNum, CONCAT(phoneNum, 'abcd'), name
FROM csit115.OWNER;

/*
(2) In the new database, create a new relational table. This relational table is named "PROPERTY_DETAIL". 
    It must contain complete information about the property and owner. Complete information means all information extracted from 
	the PROPERTY table and the owner’s name from the OWNER table.  The "PROPERTY_DETAIL" table should not contain a duplicated column. 
	Display all rows in the PROPERTY_DETAIL table.  
	
	Noted that the sample database should be upload to the csit115 database before running this solution so that you can extract 
	columns information from it and assign them to the "PROPERTY_DETAIL" table in the new database.
*/

CREATE TABLE PROPERTY_DETAIL AS
SELECT P.pNum, P.city, P.street, P.streetNum, P.apartmentNum, P.phoneNum, P.price, O.name
FROM csit115.PROPERTY as P
JOIN csit115.OWNER as O
ON P.phoneNum = O.phoneNum;
                    
SELECT * FROM PROPERTY_DETAIL;

/*
(3) Create two new roles, which are a power user and an app user. The power user role has all privileges for the new database, 
   including granting privileges to a user. Meanwhile, the app user role is allowed only to read, add, delete and update the tables 
   in the new database.      
*/

CREATE ROLE powerUser;
GRANT ALL ON iem651.* TO powerUser WITH GRANT OPTION;

CREATE ROLE appUser;
GRANT SELECT, INSERT, DELETE, UPDATE ON iem651.* TO appUser;

/*
(4)	Create two users. These user accounts should be able to log in with a password. The names of the users and passwords are up to you to design.
    Assign one of the users to the power user role and the other user to the app user role.   
*/

CREATE USER user1 IDENTIFIED BY 'user1';
GRANT powerUser to user1;

CREATE USER user2 IDENTIFIED BY 'user2';
GRANT appUser to user2;

/*
(5)	The first user belongs to the category "OWNER_CSIT115", and the OWNER_CSIT115 group have access in the read and write mode to a relational table
    OWNER located in the csit115 database. Additionally, the first user must have access in reading mode to the rest of the relational tables 
	in the csit115 database excepted for a relational table BUYER.
*/

CREATE ROLE OWNER_CSIT115;
GRANT OWNER_CSIT115 to user1;
GRANT SELECT, INSERT, UPDATE, DELETE ON csit115.OWNER TO OWNER_CSIT115;
GRANT SELECT ON csit115.INSPECTION TO user1;
GRANT SELECT ON csit115.OWNER TO user1;
GRANT SELECT ON csit115.PREFERENCE TO user1;
GRANT SELECT ON csit115.PROPERTY TO user1;

/*
(6)	Allow the second user to have only access in reading mode to the owner’s name in a relational table BUYER located in the csit115 database. 
    Also, allow the second user to have only access in reading mode to all information but the price in a relational table PROPERTY 
	located in csit115 database. 
*/

GRANT SELECT (name) ON csit115.BUYER TO user2;
GRANT SELECT (pNum, city, street, streetNum, apartmentNum, phoneNum) ON csit115.PROPERTY to user2;

/*
(7)	List user name, database name (and/or table name), read and write privileges on all databases and tables that both users got. 
    Note that you may need to write a couple of select statements to display all privileges.
*/

SELECT user, db, table_name, column_name, column_priv
FROM mysql.columns_priv
WHERE user = "user1"
OR user = "user2";

SELECT user, db, table_name, table_priv, column_priv
FROM mysql.tables_priv
WHERE user = "user1"
OR user = "user2";

SELECT user, db, select_priv, insert_priv, update_priv, delete_priv
FROM mysql.db
WHERE user = "appUser"
OR user = "powerUser";

SHOW GRANTS FOR user1;
SHOW GRANTS FOR user2;

/* 
(8)	Create a logical backup of the OWNER table in the database csit115. The logical backup file name is a prefix of your UOW email account 
    with backup.sql. For example, if your UOW email account is xyz222@uow.edu.au, then the logical backup file name is xyz222backup.sql. 
	Next, create a new database based on the backup file name. For example, "xyz222backup" is the database name. 
	Run the restore command to restore the database from the backup file to the new database. List the OWNER table in the new database.
*/

#system mysqldump csit115 OWNER -u root -p -v -l > iem651backup.sql;
notee;
system mysql -u root -p iem651 < iem651backup.sql;
tee solution4.rpt;

SELECT * FROM iem651.OWNER;

/*
(9) Remove the power user role from the first user. Remove the phone number reading right on the relational table PROPERTY in 
    the csit115 database from the second user.
*/

REVOKE powerUser FROM user1;
REVOKE SELECT ON csit115.PROPERTY FROM user2;

/*  
(10) Write scripts to remove the above two users and all the roles. Also, write the script to remove the created databases in this task as well.
*/

DROP ROLE powerUser;
DROP USER user1;
DROP USER user2;
DROP ROLE appUser;
DROP ROLE OWNER_CSIT115;
DROP DATABASE iem651;