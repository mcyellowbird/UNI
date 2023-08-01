/* (1)	A new job Database analyst needs to be added into the database. The salary of the job is 
        between 8000 and 10000. A new employee James Clark has been hired at 20/04/2017 for the job above. 
        He works in a department Information Technology. The manager id is 104. His employee id is 207. 
        His new email address is james.clark@bigmail.com.  His salary is 8500.					*/

INSERT INTO JOB VALUES( 'Database analyst', 8000, 10000 );
INSERT INTO EMPLOYEE VALUES( 207, 'James', 'Clark', 'james.clark@bigmail.com',  NULL, '2017-20-04', 'Database analyst', 8500, NULL, 104, 'Information Technology');
 
  
/* (2)	A company decides to replace employee_id 201 with a new employee_id 208. An email of the employee with 
        employee_id equal to 201 is MHARTSTE and mobile phone is 515.123.5555. Update related data in the 
        database.												*/

INSERT INTO EMPLOYEE (SELECT 208, 
                             first_name, 
                             last_name, 
                             NULL, 
                             NULL, 
                             hire_date, 
                             job_title, 
                             salary, 
                             commission_pct, 
                             supervisor_id, 
                             department_name
                      FROM EMPLOYEE
                      WHERE employee_id = 201 );

UPDATE EMPLOYEE 
SET supervisor_id = 208
WHERE supervisor_id = 201;

UPDATE DEPARTMENT 
SET manager_id = 208
WHERE manager_id = 201;

UPDATE JOBHISTORY 
SET employee_id = 208
WHERE employee_id = 201;

DELETE FROM EMPLOYEE
WHERE employee_id = 201;

UPDATE EMPLOYEE
SET email = 'MHARTSTE',
    phone_number = ' 515.123.5555'
WHERE employee_id = 208;


/* (3)	An employee with employee_id equal to 102 left the company. Remove all information about 
        the employee from the database. Note that  this employee is a manager of other employees and he is not 
        a manager of any department.	     	   		      	      	          	       	    	*/

UPDATE EMPLOYEE
SET supervisor_id = (SELECT supervisor_id
                    FROM (SELECT supervisor_id
                          FROM EMPLOYEE 
                          WHERE employee_id = 102) EMP102 )
WHERE supervisor_id= 102;

DELETE FROM JOBHISTORY
WHERE employee_id = 102;

DELETE FROM EMPLOYEE
WHERE employee_id = 102;

/* (4)	A company decided to merge a department Shipping with a department Marketing. 
        The new department name is called Logistics. It located in the same location as the department 
        Shipping and it has the same manager as the department Shipping. Update the database		*/

INSERT INTO DEPARTMENT (SELECT 'Logistics',  
                               street_address, 
                               postal_code,
                               city,
                               country_name,
                               manager_id 
                        FROM DEPARTMENT
                        WHERE department_name = 'Shipping');

UPDATE EMPLOYEE
SET department_name = 'Logistics'
WHERE department_name IN ('Marketing', 'Shipping');
 
UPDATE JOBHISTORY
SET department_name = 'Logistics'
WHERE department_name IN ('Marketing', 'Shipping');

DELETE FROM DEPARTMENT
WHERE department_name IN ('Marketing', 'Shipping');

/* (5)  An employee with employee_id equal to 180 has finished his job at 15/04/2017.  Save his old job 
        information in a relational table JOBHISTORY. He is hired as Finance Manager in a department
        Purchasing. Hire date is 20/04/2017. His salary is 4000 and commission percentage is 20.
        His manager is the same as previously.   	 	      		  			*/

INSERT INTO JOBHISTORY (SELECT employee_id, hire_date, '2017-04-15', job_title, department_name
                        FROM EMPLOYEE
                        WHERE employee_id = 180 );

UPDATE EMPLOYEE
SET job_title = 'Finance Manager',
    department_name = 'Purchasing',
    hire_date = '2017-04-20',
    salary = 400,
    commission_pct = 0.2
WHERE employee_id = 180;

