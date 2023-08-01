/* Implement SQL script solution3.sql that performs the following actions.

   (1)	First, the script modifies a description of one department in a relational table DEPARTMENT 
        such that a new manager of the department is a member of a department different from the managed 
        department.												*/

UPDATE EMPLOYEE
SET department_name = 'Sales'
WHERE employee_id = 204;

/* (2)	Next, the script finds all cases that violate in a database csit115 the following consistency
        constraint.											
	
        "An employee who is a manager of a department must be a member of the same department"

        The script must list the outcomes of verification of the consistency constraint as a single column 
        table with the following messages as the following rows.

        An employee <Insert employee id here> who manages a department <insert name of department here> is 
        a member of department <Insert name of department here> 	      	   	       		      	 

        Use a function CONCAT to create the messages above.							*/


SELECT CONCAT('An employee ', EMPDEPT.employee_id, ' who manages a department ', EMPDEPT.ddn,  ' is a member of department ', EMPDEPT.edn)
FROM ( SELECT employee_id, DEPARTMENT.department_name ddn, EMPLOYEE.department_name edn
       FROM EMPLOYEE JOIN DEPARTMENT
                     ON employee_id = manager_id ) EMPDEPT
WHERE EMPDEPT.ddn <> EMPDEPT.edn
ORDER BY EMPDEPT.employee_id ASC;
