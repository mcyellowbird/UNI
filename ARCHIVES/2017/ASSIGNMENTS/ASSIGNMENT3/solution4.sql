/* (1)	Use a single SQL statement to create a relational table EMPCONTACT that consists of the columns 
        EID, FNAME, LNAME, EMAIL and PHONENUM and such that it contains all approriate data copied from 
        a relational table EMPLOYEE. When ready, enforce appropriate consistency constraints on 
        a relational table EMPCONTACT.			 	     		 			*/

CREATE TABLE EMPCONTACT AS
 (SELECT employee_id EID, first_name FNAME, last_name LNAME, email EMAIL, phone_number PHONENUM
  FROM EMPLOYEE);    

ALTER TABLE EMPCONTACT ADD CONSTRAINT EMPCONTACT_PK PRIMARY KEY(EID);
ALTER TABLE EMPCONTACT ADD CONSTRAINT EMPCONTACT_CK1 UNIQUE(EMAIL);
ALTER TABLE EMPCONTACT ADD CONSTRAINT EMPCONTACT_CK2 UNIQUE(PHONENUM);
ALTER TABLE EMPCONTACT ADD CONSTRAINT EMPLOYEE_FK FOREIGN KEY(EID) REFERENCES EMPLOYEE(employee_id);

/* (2)	Create an empty relational table SALESEMPLOYEE, which has the following columns: EID, FNAME,
        LNAME and JOBTITLE with the same types as the columns with the respective names in a relational 
        table EMPLOYEE. Enforce primary key and referential integrity constraints on a relational table
        SALESEMPLOYEE. Copy information about all employees who have job related to Sales into 
        SALESEMPLOYEE. Note that if an employee has a job related with Sales then it means that job 
        title contains a word Sales.									*/

CREATE TABLE SALESEMPLOYEE(
 EID           DECIMAL(6)	NOT NULL,
 FNAME         VARCHAR(20)	NOT NULL,
 LNAME         VARCHAR(25)	NOT NULL,
 JOBTITLE      VARCHAR(35)	    NULL,
 CONSTRAINT SALESEMPLOYEE_PK PRIMARY KEY(EID),
 CONSTRAINT SALESEMPLOYEE_FK3 FOREIGN KEY(JOBTITLE) REFERENCES EMPLOYEE(job_title) );

INSERT INTO SALESEMPLOYEE (SELECT employee_id,
                                  first_name,
                                  last_name,
                                  job_title
                           FROM EMPLOYEE
                           WHERE UPPER(job_title) LIKE '%SALES%'); 

/* (3)	Use a single UPDATE statement to increase salary by 500 for all employees that have been hired in 
        1998 and earlier.   	      	 	  	     	     	       	    	      	        */

UPDATE EMPLOYEE
SET salary = salary + 500
WHERE YEAR(hire_date) <= 1998;

/* (4)	Add a column TOTSTAFF to a relational table DEPARTMENT. A type of the column must be DECIMAL(3)
        with no other constraints imposed on the column. Next, insert into a column TOTSTAFF the total 
        number of employees in each department.  	       	      	     	    	     	        */

ALTER TABLE DEPARTMENT ADD COLUMN TOTSTAFF DECIMAL(3) NULL;

UPDATE DEPARTMENT
SET TOTSTAFF = ( SELECT COUNT(*)
                 FROM EMPLOYEE
                 WHERE department_name = DEPARTMENT.department_name );

/* (5)	Use a single DELETE statement to remove all data from JOBHISTORY related to the employees who 
        completed at least one job before 1996     	      		 	    		  	*/

DELETE FROM JOBHISTORY
WHERE end_date IS NOT NULL AND
      end_date < 1996;
