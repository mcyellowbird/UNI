/* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
/* Applications (App) database						*/
/* Created by Janusz R. Getta,28 December 2017                          */
/* 	      	     	       	 	       	    	     	 	*/
/* dbload.sql script for laboratories and assignments in CSIT115,	*/
/* Autumn 2018	       	   		    		   		*/
/*									*/
/* To create a sample database run a script dbcreate.sql		*/
/* To drop all tables run a script dbdrop.sql				*/
/*									*/

/* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */ 
/* Lookup table                                                         */
/*									*/
INSERT INTO SKILL VALUES ( 'thinking' );
INSERT INTO SKILL VALUES ( 'reading' );
INSERT INTO SKILL VALUES ( 'writing' );
INSERT INTO SKILL VALUES ( 'CORBA programming' );
INSERT INTO SKILL VALUES ( 'C++ programming' );
INSERT INTO SKILL VALUES ( 'C programming' );
INSERT INTO SKILL VALUES ( 'Java programming' );
INSERT INTO SKILL VALUES ( 'PHP programming' );
INSERT INTO SKILL VALUES ( 'SQL programming' );
INSERT INTO SKILL VALUES ( 'database design' );
INSERT INTO SKILL VALUES ( 'Web design' );
INSERT INTO SKILL VALUES ( 'database administration' );
INSERT INTO SKILL VALUES ( 'network administration' );
INSERT INTO SKILL VALUES ( 'driving' );
INSERT INTO SKILL VALUES ( 'teaching' );
INSERT INTO SKILL VALUES ( 'accounting' );
INSERT INTO SKILL VALUES ( 'bricklaying' );
INSERT INTO SKILL VALUES ( 'concreting' );
INSERT INTO SKILL VALUES ( 'drawing' );
INSERT INTO SKILL VALUES ( 'painting' );
INSERT INTO SKILL VALUES ( 'cooking' );
INSERT INTO SKILL VALUES ( 'swimming' );
INSERT INTO SKILL VALUES ( 'playing piano' );
INSERT INTO SKILL VALUES ( 'playing guitar' );
INSERT INTO SKILL VALUES ( 'singing' );
INSERT INTO SKILL VALUES ( 'dancing' );
INSERT INTO SKILL VALUES ( 'skiing' );
INSERT INTO SKILL VALUES ( 'snowboarding' );

/* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */ 

INSERT INTO SREQUIRED VALUES ( 'CORBA programming', 'C++ programming', 5);
INSERT INTO SREQUIRED VALUES ( 'C++ programming', 'C programming', 5);
INSERT INTO SREQUIRED VALUES ( 'Java programming', 'C programming', 5);
INSERT INTO SREQUIRED VALUES ( 'PHP programming', 'C programming', 5);
INSERT INTO SREQUIRED VALUES ( 'C programming', 'reading', 10);
INSERT INTO SREQUIRED VALUES ( 'C programming', 'writing', 10);
INSERT INTO SREQUIRED VALUES ( 'C programming', 'thinking', 10);
INSERT INTO SREQUIRED VALUES ( 'database administration', 'SQL programming', 8 );
INSERT INTO SREQUIRED VALUES ( 'network administration', 'reading', 10);
INSERT INTO SREQUIRED VALUES ( 'network administration', 'writing', 10);
INSERT INTO SREQUIRED VALUES ( 'accounting', 'reading', 10);
INSERT INTO SREQUIRED VALUES ( 'accounting', 'writing', 10);
INSERT INTO SREQUIRED VALUES ( 'SQL programming', 'reading', 5 );
INSERT INTO SREQUIRED VALUES ( 'SQL programming', 'writing', 5 );
INSERT INTO SREQUIRED VALUES ( 'SQL programming', 'thinking', 10 );
INSERT INTO SREQUIRED VALUES ( 'database design', 'thinking', 10 );
INSERT INTO SREQUIRED VALUES ( 'database design', 'reading', 6 );
INSERT INTO SREQUIRED VALUES ( 'database design', 'writing', 9 );
INSERT INTO SREQUIRED VALUES ( 'teaching', 'writing', 10 );
INSERT INTO SREQUIRED VALUES ( 'teaching', 'reading', 9 );

/* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */ 
/* Relational tables implementing classes of objects			*/
/*									*/
INSERT INTO APPLICANT VALUES ( 000001, 'Harry', 'Potter', '1980-12-12',  'Perth', 'Western Australia', 645278453, NULL, 'jones@gmail.com' );
INSERT INTO APPLICANT VALUES ( 000002, 'Johnny', 'Walker', '1990-02-13',  'Geelong', 'Victoria', 63569784, 63569785, 'blunder@hotmail.com' );
INSERT INTO APPLICANT VALUES ( 000003, 'Mary', 'Poppins', '1950-01-01',  'Melbourne', 'Victoria', 62389541, NULL, NULL );
INSERT INTO APPLICANT VALUES ( 000004, 'Michael', 'Collins', '1960-05-25',  'Brisbane', 'Queensland', 63336666, NULL, 'mike@hotmail.com');
INSERT INTO APPLICANT VALUES ( 000005, 'Margaret', 'Finch', '1953-12-07',  'Sydney','New South Wales', 64573489, NULL, 'mf@163.com');
INSERT INTO APPLICANT VALUES ( 000006, 'Claudia', 'Kowalewski', '1959-05-03',  'Hobart', 'Tasmania', 64577744, NULL, 'cch@cs.odmg.org');
INSERT INTO APPLICANT VALUES ( 000007, 'James', 'Bond', '1960-06-01','Perth', 'Western Australia', 645278434, NULL, 'james@bigpond.com');
INSERT INTO APPLICANT VALUES ( 000008, 'Stephen', 'Staunton', '1977-10-23',  'Freemantle', 'Western Australia', 623778453, NULL, 'stephen@gmail.com');
INSERT INTO APPLICANT VALUES ( 000009, 'Joseph', 'Staunton', '1977-10-23',  'Newcastle', 'New South Wales', 623778453, NULL, 'joseph@gmail.com' );
INSERT INTO APPLICANT VALUES ( 0000010, 'John', 'Spiderman', '1990-06-21',  'Sydney', 'New South Wales', 24256789, 12345679, 'spider@yahoo.com');
INSERT INTO APPLICANT VALUES ( 0000011, 'George', 'Thefirst', '1991-10-12',  'Melbourne', 'Victoria', 2345987, NULL, 'g1st@hotmail.com');
INSERT INTO APPLICANT VALUES ( 0000012, 'Homer', 'Simpson', '1957-05-24',  'Adelaide', 'South Australia', 6134569876, NULL, 'homer@gmail.com');
INSERT INTO APPLICANT VALUES ( 0000013, 'Neil', 'Superman', '1960-07-20',  'Perth', 'Western Australia', 4567892345, 61343568, 'superneil@gmail.com');
INSERT INTO APPLICANT VALUES ( 0000014, 'Ivan', 'Theterrible', '1969-05-11',  'Brisbane', 'Queensland', 1234567898, NULL, 'ivan@yahoo.com');
INSERT INTO APPLICANT VALUES ( 0000015, 'Penelope', 'Princess', '1977-10-23',  'Hobart', 'Tasmania', 4007678911, NULL, 'pprincess@163.com');
INSERT INTO APPLICANT VALUES ( 0000016, 'Zhi Chao', 'Zhong', '1971-06-21',  'Horsley', 'New South Wales', 8615016189, NULL, 'suezhong@163.com');
INSERT INTO APPLICANT VALUES ( 0000017, 'Richard', 'Thelionheart', '1981-06-02',  'Waga Waga', 'New South Wales', 6134234567, NULL, 'rlion@hotmail.com');
INSERT INTO APPLICANT VALUES ( 0000018, 'Sherlock', 'Holmes', '1935-06-23',  'Bundaberg', 'Queensland', 4667667701, NULL, 'holmes@162.com');
INSERT INTO APPLICANT VALUES ( 0000019, 'Robin', 'Hood', '1951-08-21',  'Horsley', 'New South Wales', 86150329, NULL, 'robinhood@163.com');
INSERT INTO APPLICANT VALUES ( 0000020, 'Janusz', 'Getta', '1953-10-03',  'Horsley', 'New South Wales', 12345678, 12345679, 'jrg@uow.edu.au');
INSERT INTO APPLICANT VALUES ( 0000021, 'Sara', 'Wu', '1983-06-23',  'Zhongshan', 'Guangdong', 746934788, 12345679, 'sara@163.com');
INSERT INTO APPLICANT VALUES ( 0000022, 'Private', 'Ryan', '1985-06-02',  'Dapto', 'New South Wales', 74735653, 12345679, 'ryan@hotmail.com');
INSERT INTO APPLICANT VALUES ( 0000023, 'Susan', 'Han', '1976-05-01',  'Xiaolan', 'Siquan', 89830356, 12345679, 'susan@126.com');
INSERT INTO APPLICANT VALUES ( 0000032, 'Alexander', 'Thegreat', '1977-10-12',  'Hobart', 'Tasmania', 74693478, 12345679, 'agreat@xyz.com');
INSERT INTO APPLICANT VALUES ( 0000033, 'Julius', 'Caesar', '1971-05-10',  'Perth', 'Western Australia', 22316811, 12345679, 'ceasar@qq.com');
INSERT INTO APPLICANT VALUES ( 0000026, 'Marcus', 'Brutus', '1972-10-10',  'Adelaide', 'South Australia', 22316813, 12345679, 'marcus@qq.com');
INSERT INTO APPLICANT VALUES ( 0000027, 'Louis', 'Fourteenth', '1980-10-15',  'Sydney', 'New South Wales', 22316865, 12345679, 'lois14@126.com');
INSERT INTO APPLICANT VALUES ( 0000028, 'Louis', 'Fifteenth', '1986-05-06',  'Brisbane', 'Queensland', 07556060, 12345679, 'lois15@go-trans.com');
INSERT INTO APPLICANT VALUES ( 0000030, 'Henry', 'Eight', '1989-05-09',  'Gold Coast', 'Queensland', 07558821, 12345679, 'h8@go-trans.com');
INSERT INTO APPLICANT VALUES ( 0000031, 'Luke', 'Skywalker', '1976-11-03',  'Sydney', 'New South Wales', 07367742, 12345679, 'Luke@qq.com');

/* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */ 

INSERT INTO EMPLOYER VALUES ( 'University of Sydney', 'Sydney', 'New South Wales', 612345678, NULL, 'admin@uos.edu', 'www.uos.edu.au');
INSERT INTO EMPLOYER VALUES ( 'University of Western Sydney', 'Western Sydney', 'New South Wales', 612345678, NULL, 'muws@uws.edu.au', 'www.uws.edu.au');
INSERT INTO EMPLOYER VALUES ( 'University of Wollongong', 'Wollongong', 'New South Wales', 6124243689, 6124234569, 'admin@uow.edu.au', 'www.uow.edu.au');
INSERT INTO EMPLOYER VALUES ( 'University of New South Wales', 'Sydney', 'New South Wales', 6129874574, 6123454445, 'adm@unsw.edu.au', 'www.unsw.edu.au');
INSERT INTO EMPLOYER VALUES ( 'University of Technology, Sydney', 'Sydney', 'New South Wales', 6125646872, NULL, 'postmaster@uts.edu.au', 'www.uts.edu.au');
INSERT INTO EMPLOYER VALUES ( 'Macquarie University', 'Sydney', 'New South Wales', 6125646346, NULL, 'main@mcq.edu.au', 'www.mcq.edu.au');
INSERT INTO EMPLOYER VALUES ( 'Monash University', 'Melbourne', 'Victoria', 6134567932, NULL, 'admin@monash.edu.au', 'www.monash.edu.au');
INSERT INTO EMPLOYER VALUES ( 'La Trobe University', 'Melbourne', 'Victoria', 6136677899, NULL, NULL, 'www.latrobe.edu.au');
INSERT INTO EMPLOYER VALUES ( 'University of Melbourne', 'Melbourne', 'Victoria', 6131234567, 6132345678, 'admin@uom.edu.au', 'www.uom.edu.au');
INSERT INTO EMPLOYER VALUES ( 'RMIT', 'Melbourne', 'Victoria', 6135050607, NULL, NULL, 'www.rmit.edu.au');
INSERT INTO EMPLOYER VALUES ( 'University of Queensland', 'Brisbane', 'Queensland', 615333445, 6154465678, 'admin@uq.edu.au', 'www.uq.edu.au');
INSERT INTO EMPLOYER VALUES ( 'University of Adelaide', 'Adelaide', 'South Australia', 6172222567, 6172341278, 'main@uoa.edu.au', 'www.uoa.edu.au');
INSERT INTO EMPLOYER VALUES ( 'Murdoch University', 'Perth', 'Western Australia', 6182234588, NULL, 'admin@murdoch.edu.au', 'www.murdoch.edu.au');
INSERT INTO EMPLOYER VALUES ( 'Curtin University', 'Perth', 'Western Australia', 6182222567, NULL, 'main@curtin.edu.au', 'www.uoa.edu.au');
INSERT INTO EMPLOYER VALUES ( 'University of Western Australia','Perth', 'Western Australia', 6189876543, 6133341278, 'main@uowa.edu.au', 'www.uowa.edu.au');

/* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */ 

INSERT INTO EMPLBY VALUES ( 000001, 'University of Sydney', '2000-02-01', '2008-06-05' );
INSERT INTO EMPLBY VALUES ( 000001, 'Curtin University', '2000-02-01',  NULL );
INSERT INTO EMPLBY VALUES ( 000002, 'University of Western Sydney', '2009-02-20',  NULL );
INSERT INTO EMPLBY VALUES ( 000003, 'University of Wollongong', '1977-01-01',  '1980-12-31' );
INSERT INTO EMPLBY VALUES ( 000003, 'University of New South Wales', '1981-01-01',  '1990-12-31' );
INSERT INTO EMPLBY VALUES ( 000003, 'Monash University', '1991-01-01',  '1999-08-31' );
INSERT INTO EMPLBY VALUES ( 000003, 'RMIT', '2000-06-30',  NULL ); 
INSERT INTO EMPLBY VALUES ( 000004, 'University of New South Wales', '1985-05-01',  '2005-04-22' );
INSERT INTO EMPLBY VALUES ( 000004, 'La Trobe University', '2005-05-01',  NULL );
INSERT INTO EMPLBY VALUES ( 000005, 'University of Technology, Sydney', '1977-12-01',  '1980-06-01' );
INSERT INTO EMPLBY VALUES ( 000005, 'University of Adelaide', '1980-07-01',  '1990-12-31' );
INSERT INTO EMPLBY VALUES ( 000005, 'University of Queensland', '1991-01-01',  '1996-03-30' );
INSERT INTO EMPLBY VALUES ( 000005, 'RMIT', '1996-12-01',  '2005-06-01' );
INSERT INTO EMPLBY VALUES ( 000005, 'University of Queensland', '2005-12-01',  NULL );
INSERT INTO EMPLBY VALUES ( 000006, 'University of Technology, Sydney', '1979-12-01',  '1985-06-01' );
INSERT INTO EMPLBY VALUES ( 000006, 'University of Adelaide', '1986-04-01',  '1987-06-01' );
INSERT INTO EMPLBY VALUES ( 000006, 'University of Queensland', '1987-12-01',  '2001-06-07' );
INSERT INTO EMPLBY VALUES ( 000006, 'RMIT', '2001-12-31',  '2010-06-01' );
INSERT INTO EMPLBY VALUES ( 000006, 'University of Queensland', '2010-07-01',  NULL );
INSERT INTO EMPLBY VALUES ( 000007, 'Macquarie University', '1980-01-01', '2000-01-31' );
INSERT INTO EMPLBY VALUES ( 000007, 'Monash University', '2001-05-03',  NULL );
INSERT INTO EMPLBY VALUES ( 000008, 'La Trobe University', '1990-10-01',  '1995-05-30' );
INSERT INTO EMPLBY VALUES ( 000008, 'University of Adelaide', '1997-05-01',  '1999-10-31' );
INSERT INTO EMPLBY VALUES ( 000008, 'Murdoch University', '2000-01-01',  '2005-10-31' );
INSERT INTO EMPLBY VALUES ( 000008, 'Curtin University', '2005-05-01',  '2009-12-31' );
INSERT INTO EMPLBY VALUES ( 000009, 'La Trobe University', '1990-10-1',  '1995-05-30' );
INSERT INTO EMPLBY VALUES ( 000009, 'University of Adelaide', '1997-05-01',  '1999-10-31' );
INSERT INTO EMPLBY VALUES ( 000009, 'Murdoch University', '2000-01-01',  '2005-10-31' );
INSERT INTO EMPLBY VALUES ( 000009, 'Curtin University', '2005-05-01',  '2009-12-31' );
INSERT INTO EMPLBY VALUES ( 000009, 'La Trobe University', '2010-10-01',  NULL );
INSERT INTO EMPLBY VALUES ( 0000010, 'RMIT', '2011-01-01',  '2011-01-31' );
INSERT INTO EMPLBY VALUES ( 0000010, 'Murdoch University', '2011-02-01',  '2011-05-31' );
INSERT INTO EMPLBY VALUES ( 0000010, 'RMIT', '2011-04-01',  '2011-05-31' );
INSERT INTO EMPLBY VALUES ( 0000010, 'Murdoch University', '2011-06-01',  '2011-11-30' );
INSERT INTO EMPLBY VALUES ( 0000010, 'RMIT', '2011-12-01',  NULL );
INSERT INTO EMPLBY VALUES ( 0000011, 'University of Queensland', '1010-10-01',  '2010-12-31' );
INSERT INTO EMPLBY VALUES ( 0000012, 'University of Adelaide', '1999-04-01',  '1999-06-01' );
INSERT INTO EMPLBY VALUES ( 0000012, 'University of Queensland', '1999-07-01',  '1999-07-10' );
INSERT INTO EMPLBY VALUES ( 0000012, 'RMIT', '1999-08-01',  '1999-08-31' );
INSERT INTO EMPLBY VALUES ( 0000012, 'Macquarie University', '1999-09-01', '1999-12-31' );
INSERT INTO EMPLBY VALUES ( 0000012, 'Monash University', '2001-01-01',  '2001-01-02' );
INSERT INTO EMPLBY VALUES ( 0000012, 'La Trobe University', '2001-01-03',  '2005-05-30' );
INSERT INTO EMPLBY VALUES ( 0000012, 'University of Adelaide', '2006-04-01',  '2006-06-08' );
INSERT INTO EMPLBY VALUES ( 0000012, 'University of Queensland', '2006-12-31',  '2007-06-07' );
INSERT INTO EMPLBY VALUES ( 0000012, 'RMIT', '2008-12-31',  '2010-06-01' );
INSERT INTO EMPLBY VALUES ( 0000012, 'University of Queensland', '2011-07-01',  '2011-07-31' );
INSERT INTO EMPLBY VALUES ( 0000012, 'Macquarie University', '2011-08-01', '2011-10-31' );
INSERT INTO EMPLBY VALUES ( 0000012, 'Monash University', '2011-11-01',  '2011-11-03' );
INSERT INTO EMPLBY VALUES ( 0000012, 'University of Adelaide', '2011-12-05',  '2011-12-31' );
INSERT INTO EMPLBY VALUES ( 0000013, 'Murdoch University', '1985-07-20',  '2010-12-31' );
INSERT INTO EMPLBY VALUES ( 0000014, 'Curtin University', '1991-05-01',  '2010-12-31' );
INSERT INTO EMPLBY VALUES ( 0000014, 'Murdoch University', '2010-01-01',  '2010-05-30' );
INSERT INTO EMPLBY VALUES ( 0000014, 'University of Adelaide', '2010-06-01',  '2010-10-31' );
INSERT INTO EMPLBY VALUES ( 0000014, 'Murdoch University', '2011-01-01',  NULL );
INSERT INTO EMPLBY VALUES ( 0000015, 'University of Western Australia', '2007-10-01',  '2010-10-01' );
INSERT INTO EMPLBY VALUES ( 0000015, 'University of Technology, Sydney', '2010-12-01',  NULL );
INSERT INTO EMPLBY VALUES ( 0000016, 'Curtin University', '2001-06-01',  NULL );
INSERT INTO EMPLBY VALUES ( 0000017, 'La Trobe University', '2009-06-01',  '2009-07-01' );
INSERT INTO EMPLBY VALUES ( 0000017, 'University of New South Wales', '2009-12-01',  '2010-12-31' );
INSERT INTO EMPLBY VALUES ( 0000017, 'University of Technology, Sydney', '2011-01-01',  NULL );
INSERT INTO EMPLBY VALUES ( 0000018, 'Monash University', '1965-06-01',  '1975-06-01' );
INSERT INTO EMPLBY VALUES ( 0000018, 'RMIT', '1975-09-01',  '1980-04-01' ); 
INSERT INTO EMPLBY VALUES ( 0000018, 'University of New South Wales', '1982-05-01',  '1983-09-20' );
INSERT INTO EMPLBY VALUES ( 0000018, 'La Trobe University', '1983-09-21',  '1985-06-01' );
INSERT INTO EMPLBY VALUES ( 0000018, 'University of Technology, Sydney', '1985-06-02',  '1990-12-01' );
INSERT INTO EMPLBY VALUES ( 0000018, 'University of Adelaide', '1991-07-01',  '1992-12-31' );
INSERT INTO EMPLBY VALUES ( 0000018, 'University of Queensland', '1993-01-01',  '1996-05-30' );
INSERT INTO EMPLBY VALUES ( 0000018, 'RMIT', '1996-12-01',  '1997-06-01' );
INSERT INTO EMPLBY VALUES ( 0000018, 'University of Sydney', '1998-02-01', '1999-06-07' );
INSERT INTO EMPLBY VALUES ( 0000018, 'Curtin University', '2000-02-01',  '2001-06-01' );
INSERT INTO EMPLBY VALUES ( 0000018, 'University of Western Sydney', '2002-02-20',  '2003-06-01' );
INSERT INTO EMPLBY VALUES ( 0000018, 'University of Wollongong', '2004-01-01',  '2004-12-31' );
INSERT INTO EMPLBY VALUES ( 0000018, 'University of New South Wales', '2005-01-01',  '2005-12-31' );
INSERT INTO EMPLBY VALUES ( 0000018, 'Monash University', '2006-01-01',  '2007-08-31' );
INSERT INTO EMPLBY VALUES ( 0000018, 'RMIT', '2008-06-21',  '2008-06-30' ); 
INSERT INTO EMPLBY VALUES ( 0000018, 'University of New South Wales', '2009-05-01',  '2010-04-13' );
INSERT INTO EMPLBY VALUES ( 0000018, 'La Trobe University', '2010-04-20',  '2010-06-01' );
INSERT INTO EMPLBY VALUES ( 0000018, 'University of Technology, Sydney', '2010-12-01',  '2011-01-02' );
INSERT INTO EMPLBY VALUES ( 0000018, 'University of Queensland', '2011-01-05',  '2011-06-01' );
INSERT INTO EMPLBY VALUES ( 0000018, 'University of Technology, Sydney', '2011-06-15',  '2011-08-01' );
INSERT INTO EMPLBY VALUES ( 0000018, 'University of Wollongong', '2011-11-25',  NULL );
INSERT INTO EMPLBY VALUES ( 0000020, 'University of Wollongong', '1991-01-01',  NULL );
INSERT INTO EMPLBY VALUES ( 0000021, 'RMIT', '2012-11-01',  NULL );
INSERT INTO EMPLBY VALUES ( 0000021, 'University of Queensland', '1999-10-05',  '2010-10-31' );
INSERT INTO EMPLBY VALUES ( 0000021, 'University of Adelaide', '2010-04-05',  '2010-04-06' );
INSERT INTO EMPLBY VALUES ( 0000021, 'University of Queensland', '2011-07-01',  '2012-01-10' );
INSERT INTO EMPLBY VALUES ( 0000022, 'RMIT', '2008-06-21',  '2008-06-30' ); 
INSERT INTO EMPLBY VALUES ( 0000022, 'University of New South Wales', '2009-05-01',  '2010-04-13' );
INSERT INTO EMPLBY VALUES ( 0000022, 'La Trobe University', '2010-04-20',  '2010-06-01' );
INSERT INTO EMPLBY VALUES ( 0000023, 'University of Sydney', '2001-02-01', '2002-06-07' );
INSERT INTO EMPLBY VALUES ( 0000023, 'Curtin University', '2002-08-01',  '2003-06-01' );
INSERT INTO EMPLBY VALUES ( 0000023, 'University of Western Sydney', '2004-02-20',  '2005-06-01' );
INSERT INTO EMPLBY VALUES ( 0000026, 'RMIT', '2008-06-21',  '2009-06-30' ); 
INSERT INTO EMPLBY VALUES ( 0000026, 'University of New South Wales', '2010-08-01',  NULL );
INSERT INTO EMPLBY VALUES ( 0000027, 'University of New South Wales', '2011-05-01',  NULL );
INSERT INTO EMPLBY VALUES ( 0000028, 'University of New South Wales', '2012-06-01',  NULL );
INSERT INTO EMPLBY VALUES ( 0000030, 'La Trobe University', '2009-06-01',  '2009-07-01' );
INSERT INTO EMPLBY VALUES ( 0000030, 'University of New South Wales', '2009-12-01',  '2010-12-31' );
INSERT INTO EMPLBY VALUES ( 0000030, 'University of Technology, Sydney', '2011-01-01',  NULL );
INSERT INTO EMPLBY VALUES ( 0000031, 'Monash University', '1965-06-01',  NULL );
INSERT INTO EMPLBY VALUES ( 0000032, 'RMIT', '1975-09-01',  '1980-04-01' ); 

/* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */ 

INSERT INTO POSITIONS VALUES ( 00000001, 'lecturer', 45000.00, 'computer', NULL, 'teaching', 'University of New South Wales');
INSERT INTO POSITIONS VALUES ( 00000002, 'lecturer', 450000.00, 'mouse pad', 500000.0, 'research', 'University of Wollongong');
INSERT INTO POSITIONS VALUES ( 00000003, 'senior lecturer', 50000.00, 'a lot of red markers', NULL, 'a lot of hard work', 'University of Technology, Sydney'  );
INSERT INTO POSITIONS VALUES ( 00000004, 'associate professor', 200000.00, 'silver pen', NULL, 'teaching', 'University of Wollongong');
INSERT INTO POSITIONS VALUES ( 00000005, 'professor', 200000.00, 'chair', NULL, 'research', 'University of Queensland' );
INSERT INTO POSITIONS VALUES ( 00000006, 'professor', 100000.00, 'chair and desk', NULL, 'research', 'University of New South Wales' );
INSERT INTO POSITIONS VALUES ( 00000007, 'professor', 800000.00, 'chair', NULL, 'teaching and research', 'University of Wollongong');
INSERT INTO POSITIONS VALUES ( 00000008, 'senior lecturer', 45000.00, 'computer', 100000.00, 'teaching', 'University of Wollongong');
INSERT INTO POSITIONS VALUES ( 00000009, 'lecturer', 450000.00, 'mouse pad', 500000.00, 'research', 'University of Wollongong');
INSERT INTO POSITIONS VALUES ( 00000010, 'associate professor', 50000.00, 'a lot of red markers', NULL, 'a lot of hard work', 'University of Technology, Sydney' );

/* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */ 
/* Relational tables implementing associations				*/
/*									*/
INSERT INTO SPOSSESSED VALUES ( 000001, 'Java programming', 9 );
INSERT INTO SPOSSESSED VALUES ( 000001, 'C programming', 4 );
INSERT INTO SPOSSESSED VALUES ( 000001, 'cooking', 9 );
INSERT INTO SPOSSESSED VALUES ( 000002, 'Java programming', 9 );
INSERT INTO SPOSSESSED VALUES ( 000002, 'driving', 9 );
INSERT INTO SPOSSESSED VALUES ( 000003, 'C++ programming', 10 );
INSERT INTO SPOSSESSED VALUES ( 000003, 'Java programming', 9 );
INSERT INTO SPOSSESSED VALUES ( 000003, 'painting', 5 );
INSERT INTO SPOSSESSED VALUES ( 000005, 'SQL programming', 6 );
INSERT INTO SPOSSESSED VALUES ( 000006, 'SQL programming', 8 );
INSERT INTO SPOSSESSED VALUES ( 000007, 'SQL programming', 9 );
INSERT INTO SPOSSESSED VALUES ( 000007, 'cooking', 10 );
INSERT INTO SPOSSESSED VALUES ( 000008, 'SQL programming', 3 );
INSERT INTO SPOSSESSED VALUES ( 000008, 'cooking', 9 );
INSERT INTO SPOSSESSED VALUES ( 0000010, 'database design', 10 );
INSERT INTO SPOSSESSED VALUES ( 0000010, 'cooking', 1 );
INSERT INTO SPOSSESSED VALUES ( 0000010, 'painting', 9 );
INSERT INTO SPOSSESSED VALUES ( 0000010, 'SQL programming', 10 );
INSERT INTO SPOSSESSED VALUES ( 0000011, 'network administration', 10 );
INSERT INTO SPOSSESSED VALUES ( 0000011, 'C programming', 5 );
INSERT INTO SPOSSESSED VALUES ( 0000012, 'cooking', 1 );
INSERT INTO SPOSSESSED VALUES ( 0000012, 'Java programming', 9 );
INSERT INTO SPOSSESSED VALUES ( 0000012, 'driving', 3 );
INSERT INTO SPOSSESSED VALUES ( 0000013, 'network administration', 7 );
INSERT INTO SPOSSESSED VALUES ( 0000013, 'database administration', 6 );
INSERT INTO SPOSSESSED VALUES ( 0000014, 'painting', 5 );
INSERT INTO SPOSSESSED VALUES ( 0000015, 'database administration', 4 );
INSERT INTO SPOSSESSED VALUES ( 0000016, 'SQL programming', 4 );
INSERT INTO SPOSSESSED VALUES ( 0000017, 'database administration', 7 );
INSERT INTO SPOSSESSED VALUES ( 0000017, 'cooking', 9 );
INSERT INTO SPOSSESSED VALUES ( 0000018, 'network administration', 5 );
INSERT INTO SPOSSESSED VALUES ( 0000018, 'bricklaying', 6 );
INSERT INTO SPOSSESSED VALUES ( 0000018, 'database design', 9 );
INSERT INTO SPOSSESSED VALUES ( 0000018, 'database administration', 3 );
INSERT INTO SPOSSESSED VALUES ( 0000019, 'database administration', 8 );
INSERT INTO SPOSSESSED VALUES ( 0000020, 'SQL programming', 10 );
INSERT INTO SPOSSESSED VALUES ( 0000021, 'SQL programming', 10 );
INSERT INTO SPOSSESSED VALUES ( 0000021, 'C++ programming', 10 );
INSERT INTO SPOSSESSED VALUES ( 0000022, 'thinking', 10 );
INSERT INTO SPOSSESSED VALUES ( 0000023, 'reading', 10 );
INSERT INTO SPOSSESSED VALUES ( 0000023, 'writing', 10 );
INSERT INTO SPOSSESSED VALUES ( 0000023, 'skiing', 10 );
INSERT INTO SPOSSESSED VALUES ( 0000026, 'snowboarding', 10 );
INSERT INTO SPOSSESSED VALUES ( 0000026, 'database administration', 8 );
INSERT INTO SPOSSESSED VALUES ( 0000026, 'SQL programming', 10 );
INSERT INTO SPOSSESSED VALUES ( 0000026, 'PHP programming', 6 );
INSERT INTO SPOSSESSED VALUES ( 0000027, 'SQL programming', 3 );
INSERT INTO SPOSSESSED VALUES ( 0000028, 'thinking', 4 );
INSERT INTO SPOSSESSED VALUES ( 0000030, 'reading', 1 );
INSERT INTO SPOSSESSED VALUES ( 0000030, 'writing', 1 );
INSERT INTO SPOSSESSED VALUES ( 0000031, 'skiing', 2 );
INSERT INTO SPOSSESSED VALUES ( 0000031, 'snowboarding', 18 );

/* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

INSERT INTO SNEEDED VALUES ( 00000001, 'Java programming', 8 );
INSERT INTO SNEEDED VALUES ( 00000001, 'cooking', 9 );
INSERT INTO SNEEDED VALUES ( 00000002, 'Java programming', 3 );
INSERT INTO SNEEDED VALUES ( 00000002, 'driving', 9 );
INSERT INTO SNEEDED VALUES ( 00000003, 'C++ programming', 7 );
INSERT INTO SNEEDED VALUES ( 00000003, 'Java programming', 10 );
INSERT INTO SNEEDED VALUES ( 00000003, 'painting', 4 );
INSERT INTO SNEEDED VALUES ( 00000005, 'cooking', 10 );
INSERT INTO SNEEDED VALUES ( 00000001, 'C programming', 4 );
INSERT INTO SNEEDED VALUES ( 00000006, 'cooking', 2 );
INSERT INTO SNEEDED VALUES ( 00000005, 'painting', 6 );
INSERT INTO SNEEDED VALUES ( 00000007, 'SQL programming', 10 );
INSERT INTO SNEEDED VALUES ( 00000004, 'SQL programming', 6 );
INSERT INTO SNEEDED VALUES ( 00000005, 'SQL programming', 3 );
INSERT INTO SNEEDED VALUES ( 00000007, 'painting', 5 );
INSERT INTO SNEEDED VALUES ( 00000001, 'SQL programming', 3 );
INSERT INTO SNEEDED VALUES ( 00000002, 'database design', 10 );
INSERT INTO SNEEDED VALUES ( 00000007, 'cooking', 8 );
INSERT INTO SNEEDED VALUES ( 00000008, 'singing', 3 );
INSERT INTO SNEEDED VALUES ( 00000009, 'painting',10  );
INSERT INTO SNEEDED VALUES ( 00000009, 'bricklaying', 9 );

/* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */ 

INSERT INTO APPLIES VALUES( 000001, 00000001, '2017-12-13' );
INSERT INTO APPLIES VALUES( 000002, 00000001, '2017-12-13' );
INSERT INTO APPLIES VALUES( 000003, 00000002, '2017-11-14' );
INSERT INTO APPLIES VALUES( 000004, 00000002, '2017-01-20' );
INSERT INTO APPLIES VALUES( 000005, 00000002, '2017-12-22' );
INSERT INTO APPLIES VALUES( 000005, 00000003, '2017-05-09' );
INSERT INTO APPLIES VALUES( 000006, 00000003, '2017-06-17' ); 
INSERT INTO APPLIES VALUES( 000007, 00000003, '2017-06-18' );
INSERT INTO APPLIES VALUES( 000007, 00000004, '2018-01-13' );
INSERT INTO APPLIES VALUES( 000008, 00000004, '2018-02-13' );
INSERT INTO APPLIES VALUES( 000009, 00000004, '2018-02-26' );
INSERT INTO APPLIES VALUES( 000010, 00000005, '2017-09-23' );
INSERT INTO APPLIES VALUES( 000001, 00000006, '2017-10-26' );
INSERT INTO APPLIES VALUES( 000002, 00000006, '2018-01-27' );
INSERT INTO APPLIES VALUES( 000003, 00000006, '2018-01-28' );
INSERT INTO APPLIES VALUES( 000004, 00000007, '2017-01-01' );
INSERT INTO APPLIES VALUES( 000005, 00000007, '2017-01-03' );
INSERT INTO APPLIES VALUES( 000006, 00000007, '2017-01-04' );
INSERT INTO APPLIES VALUES( 000007, 00000007, '2018-01-07' );

COMMIT;

/* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */ 
/* End of script                                                        */
/* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
