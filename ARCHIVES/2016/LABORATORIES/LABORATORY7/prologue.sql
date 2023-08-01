/* (1)	Download and unzip a file laboratory7-all-files.zip. You should get the files Laboratory7.pdf, 
        dbcreate7.sql, and dbdrop7.sql. Copy the files to your USB drive such that you can access both 
	files either through command line interface mysql or graphical user interface MySQL Workbench.			*/ 

/* (2)	Connect to a database server as a user root with a password root						*/

/* (3) Create a database with the same name as a prefix of your University email account. For example, 
       if your University email account is xyz007@uow.edu.au then a name of a database must be xyz007. 
       Note, that if you create a user xyz007 then you can be absolutely sure that you will get no marks 
       for this lab.													*/
   
CREATE DATABASE jrg;

/* (4)	Create 3 users with the following user names: prefix of your University email account_1, 
        prefix of your University email account_2, and  prefix of your University email account_3. 
	For example, if a prefix of your University email account is xyz007 then the names of users 
	are xyz007_1, xyz007_2, and xyz007_3. All passwords are up to you						*/

CREATE USER jrg_1 IDENTIFIED BY 'jrg_1';
CREATE USER jrg_2 IDENTIFIED BY 'jrg_2';
CREATE USER jrg_3 IDENTIFIED BY 'jrg_3';

/* (5)	While connected as a user root, execute a script dbcreate7.sql to create the relational tables 
        later on used in this laboratory class. All relational tables must be located in a database 
		created in step (3).											*/

USE jrg;
source dbcreate7.sql;
