/* Implement SQL script solution2.sql that finds the differences between the contents of a relational table
   EMPLOYEE and a relational table with the same name as a prefix of your University email account_EMP.
 
   The script must first list the rows added to the relational table EMPLOYEE after the backup file was created, */

SELECT *
FROM EMPLOYEE
WHERE employee_id  NOT IN ( SELECT employee_id
                            FROM jrg_EMP);

/* then the rows deleted from a relational tables EMPLOYEE after the backup file was created,			*/

SELECT *
FROM jrg_EMP
WHERE employee_id  NOT IN ( SELECT employee_id
                            FROM EMPLOYEE);

/* and finally list the rows changed in relational table EMPLOYEE after the backup file was created. 
   
   In brief, the script must first list all added rows, then all deleted rows, and finally all changed rows 
   in a relational table  EMPLOYEE. It is allowed to use more than one SELECT statement to implement this
   task.													*/

SELECT EMPLOYEE.*
FROM EMPLOYEE JOIN jrg_EMP
              ON   EMPLOYEE.employee_id      =  jrg_EMP.employee_id   AND
	         ( EMPLOYEE.first_name      != jrg_EMP.first_name     OR
		   EMPLOYEE.email           != jrg_EMP.email          OR 
		   EMPLOYEE.phone_number    != jrg_EMP.phone_number   OR
		   EMPLOYEE.hire_date       != jrg_EMP.hire_date      OR
		   EMPLOYEE.job_title       != jrg_EMP.job_title      OR
		   EMPLOYEE.salary          != jrg_EMP.salary         OR
		   EMPLOYEE.commission_pct  != jrg_EMP.commission_pct OR
		   EMPLOYEE.supervisor_id   != jrg_EMP.supervisor_id  OR
		   EMPLOYEE.department_name != jrg_EMP.department_name   );
			     
