/* Implement SQL script solution1.sql that performs the following actions as a user root. 

   (1)	First, the script creates a new user with a name the same as a prefix of your University 
        email account. A password of the new user is up to you.							*/

CREATE USER jrg IDENTIFIED BY 'jrg';

/* (2)	Next, the script grants to the new user to read data from the relational tables EMPLOYEE and 
        JOBHISTORY, and to create the views located in a database with the same name as a prefix of your
        University email account. The privileges must be granted such that the new user is able to grant 
        all privileges listed above to the other users.								*/

GRANT SELECT ON jrg.EMPLOYEE TO jrg WITH GRANT OPTION;
GRANT SELECT ON jrg.JOBHISTORY TO jrg WITH GRANT OPTION;
GRANT CREATE VIEW ON jrg.* TO jrg WITH GRANT OPTION;

/* (3)	Next, the script sets the following values of resource limits to a name of account owner is the same as 
        a prefix of your University email account: total number of queries an account owner can issue per hour
        must be set to 100, and total number of simultaneous connections to the server by an account owner must
        be set to 3, total number of times an account can connect to the server per hour must be 10.		*/

ALTER USER jrg WITH MAX_QUERIES_PER_HOUR 100;
ALTER USER jrg WITH MAX_USER_CONNECTIONS 3;
ALTER USER jrg WITH MAX_CONNECTIONS_PER_HOUR 10;
 
/* (4)	Next, the script locks an account of the new user with the same name as the prefix of your University
        email account.												*/

ALTER USER jrg ACCOUNT LOCK;

/* (5)	Finally, the script lists the privileges granted to the new user, the values of resource limits set in 
        a step (3) and a status of the account a prefix of your University email account set in a step (4).  
        To do so your script must access appropriate relational tables in a database mysql. Do not list
        information not related to the actions performed above !						*/

SELECT db, user, create_view_priv, grant_priv
FROM mysql.db
WHERE user = 'jrg';

SELECT db, user, table_name, table_priv
FROM mysql.tables_priv
WHERE user = 'jrg';

SELECT max_questions, max_user_connections, max_connections, account_locked
FROM mysql.user
WHERE user = 'jrg';

	

