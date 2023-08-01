/* (1)	Find the full names of all employees who currently working in Canada. The query must be	
        implemented as a nested query.	     	       	       	  	      	    	 	*/

SELECT first_name, last_name
FROM EMPLOYEE
WHERE department_name IN (SELECT department_name
                          FROM DEPARTMENT
			  WHERE country_name = 'Canada');
			   
/* (2)	Find the full names of all employees who have no information about themselves recorded 
        in JOBHISTORY table. The query must be implemented as a correlated nested query with 
        a negated existential quantifier.							*/

SELECT first_name, last_name
FROM EMPLOYEE
WHERE NOT EXISTS (SELECT 'whatever'
                  FROM JOBHISTORY
		  WHERE EMPLOYEE.employee_id = JOBHISTORY.employee_id);
	
/* (3)	Find the full names of all employees who have completed two jobs. The query must be
        implemented as a nested query.								*/

SELECT first_name, last_name
FROM EMPLOYEE
WHERE employee_id IN (SELECT employee_id
                      FROM JOBHISTORY
		      WHERE end_date IS NOT NULL
		      GROUP BY employee_id
		      HAVING count(*) = 2);
	
/* (4)	Find the names of regions together with the names of departments located in each region.
        The query must be implemented as a join query.						*/
	
SELECT region_name, department_name
FROM COUNTRY JOIN DEPARTMENT
             ON COUNTRY.country_name = DEPARTMENT.country_name;
	
/* (5)	Find the names of departments located in Europe. The query must be implemented as 
        nested query with an existential quantifier.						*/

SELECT department_name
FROM DEPARTMENT
WHERE EXISTS (SELECT 'whatever'
              FROM COUNTRY
	      WHERE DEPARTMENT.country_name = COUNTRY.country_name AND
	            region_name = 'Europe');
	      
	      


