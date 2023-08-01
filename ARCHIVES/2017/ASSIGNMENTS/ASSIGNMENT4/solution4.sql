/* Implement SQL script solution4.sql that performs the following actions.

   (1)	First, the script sets the appropriate values of the variables that allow create a general log, 
        to save a general log in a relational table, and to start recording a general log from now.		*/

SET GLOBAL general_log='ON';
SET GLOBAL log_output='TABLE';

/* (2)	Next, the script makes a relational table that contains a general log empty.				*/

TRUNCATE TABLE mysql.general_log;
 
/* (3)	Next, the script executes a script file dbchange4.sql. Do not put results of execution of script 
        dbchange4.sql into a report.										*/
notee;
source dbchange4.sql;
tee solution4.rpt;

/* (4)	Next, the script sets the appropriate values of all variables that stop recording a general log from 
        now.													*/
	
SET GLOBAL general_log='OFF';

/* (5)	Next, the script lists all DDL statements (CREATE, ALTER, DROP) processed in a period of time when 
        a general log was recorded.										*/

SELECT argument
FROM mysql.general_log
WHERE argument LIKE 'CREATE %'   OR
      argument LIKE '% CREATE %' OR
      argument LIKE 'ALTER %'    OR
      argument LIKE '% ALTER %'  OR
      argument LIKE 'DROP %'     OR
      argument LIKE '% DROP %';

/* (6)	Next, the script lists total number of times each one of DML statements like SELECT, INSERT, UPDATE, 
        DELETE has been processed in a period of time when a general log was recorded. It is acceptable 
        to ignore DML statement if it has not been processed at all. Sort the results in an ascending order 
        of the total number times a DML statement has been processed.						*/

SELECT substr(argument, 1, 6), COUNT(*) TIMES
FROM mysql.general_log
WHERE  argument LIKE 'SELECT %'   OR
       argument LIKE 'INSERT %'   OR
       argument LIKE 'DELETE %'   OR
       argument LIKE 'UPDATE %'   
GROUP BY substr(argument, 1, 6)
ORDER BY TIMES ASC; 

