/* (1)	Find the full names of employees who have been hired or had their jobs 
        in 1995.									*/

SELECT first_name, last_name
FROM EMPLOYEE
WHERE YEAR(hire_date) < '1996-01-01' OR
      employee_id IN (SELECT employee_id
                      FROM JOBHISTORY
		      WHERE ( end_date >= '1995-01-01' AND start_date < '1996-01-01' ) );

/* (2)	Find the names of departments with the total number of employees working at 
        each department. Include the departments that have no employees.		*/

SELECT DEPARTMENT.department_name, COUNT(employee_id)
FROM DEPARTMENT LEFT OUTER JOIN EMPLOYEE
                ON DEPARTMENT.department_name = EMPLOYEE.department_name
GROUP BY DEPARTMENT.department_name;
	
/* (3)	Find the full names of managers with the total number of employees directly 
        supervised by each one of them.							*/

SELECT first_name, last_name, total
FROM EMPLOYEE JOIN (SELECT supervisor_id, COUNT(*) total
	            FROM EMPLOYEE
	            GROUP BY supervisor_id) SVC
              ON EMPLOYEE.employee_id = SVC.supervisor_id;
	
/* (4)	Find the full names of employees who had completed their jobs and worked for 
        more than 1000 days					      	  	 	*/

SELECT first_name, last_name
FROM EMPLOYEE
WHERE employee_id IN (SELECT DISTINCT employee_id
                      FROM JOBHISTORY
		      WHERE end_date IS NOT NULL AND
                            DATEDIFF(end_date, start_date) >= 1000 );

