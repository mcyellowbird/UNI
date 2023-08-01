use csit115;
\. dbdrop.sql
\. dbcreate.sql
\. dbload.sql

/* Implement SQL script solution2.sql that performs the following actions. */

/*   (1)	Make a relational table that supposed to contain a general query log empty.		*/

TRUNCATE TABLE mysql.general_log;

/* (2) Set the appropriate values of the variables that allow to create a general query log, 
   to save the log in a relational table, and to start recording the log from now.				*/

SET GLOBAL general_log='ON';
SET GLOBAL log_output='TABLE';

 
/* (3)	Process SQL script file disaster.sql.	*/

\. disaster.sql

commit;

/* (4)	Set the appropriate values of all variables that stop recording a general query log from now.	*/
	
SET GLOBAL general_log='OFF';

/* (5)	Use SELECT statement to list the contents of general query log 
   and compare it with the contents of SQL script file disaster.sql.			*/

SELECT *
FROM mysql.general_log
ORDER BY event_time ASC; 
