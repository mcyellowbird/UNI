/* DML for Task 2 */
INSERT INTO EMPLOYEE VALUES 
        ( 210
        , 'Marry'
        , 'Webster'
        , 'MWEBSTER'
        , '515.134.8182'
        , STR_TO_DATE('15-06-2010', '%d-%m-%Y')
        , 'Accountant'
        , 8200
        , NULL
        , 105
        , 'Accounting'
        );

INSERT INTO EMPLOYEE VALUES 
        ( 211
        , 'Simon'
        , 'Cronaca'
        , 'SCRONACA'
        , '515.135.8281'
        , STR_TO_DATE('10-08-2015', '%d-%m-%Y')
        , 'Accountant'
        , 8350
        , NULL
        , 105
        , 'Accounting'
        );
		

INSERT INTO JOBHISTORY VALUES 
		( 210
       , STR_TO_DATE('21-09-2005', '%d-%m-%Y')
       , STR_TO_DATE('14-06-2010', '%d-%m-%Y')
       , 'Accountant'
       , 'Accounting');

INSERT INTO JOBHISTORY VALUES 
		( 211
       , STR_TO_DATE('21-09-2001', '%d-%m-%Y')
       , STR_TO_DATE('27-10-2010', '%d-%m-%Y')
       , 'Accountant'
       , 'Accounting');
	   
DELETE FROM JOBHISTORY WHERE employee_id = 177;

DELETE FROM EMPLOYEE WHERE employee_id = 177;

UPDATE JOBHISTORY SET job_title = 'Accountant', department_name = 'Accounting' WHERE employee_id = 175;

COMMIT;
