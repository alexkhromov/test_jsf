declare
EMPLOYEEID NUMBER;
PROJECTID NUMBER;
REPORTID NUMBER;
begin
  EXECUTE IMMEDIATE 'select EMPLOYEE_ID_SEQUENCE.nextval from dual' INTO EMPLOYEEID;
  EXECUTE IMMEDIATE 'select PROJECT_ID_SEQUENCE.nextval from dual' INTO PROJECTID;
  EXECUTE IMMEDIATE 'select REPORT_ID_SEQUENCE.nextval from dual' INTO REPORTID;
  EXECUTE IMMEDIATE 'INSERT INTO EMPLOYEE ( ID, NAME, HIREDATE, POSITION, SALARY ) VALUES ( :1, ''John Smith'', TO_DATE( ''2011-02-01'',''YYYY-MM-DD'' ), ''Project Manager'', 1000 )'
  USING EMPLOYEEID;
  EXECUTE IMMEDIATE 'INSERT INTO PROJECT ( ID, NAME, DESCRIPTION ) VALUES ( :1, ''Risk analysis system'', ''Analysis of goods incoming by post'' )'
  USING PROJECTID;  
  EXECUTE IMMEDIATE 'INSERT INTO EMPLOYEEPROJECT ( EMPLOYEEID, PROJECTID ) VALUES ( :1, :2 )'
  USING EMPLOYEEID, PROJECTID;
  EXECUTE IMMEDIATE 'INSERT INTO REPORT ( ID, EMPLOYEEID, PROJECTID, CREATEDATE, BODY ) VALUES ( :1, :2, :3, TO_DATE( ''2014-02-02'', ''YYYY-MM-DD'' ), ''Guys we need a meeting!'' )'
  USING REPORTID, EMPLOYEEID, PROJECTID;

  EXECUTE IMMEDIATE 'select EMPLOYEE_ID_SEQUENCE.nextval from dual' INTO EMPLOYEEID;
  EXECUTE IMMEDIATE 'select PROJECT_ID_SEQUENCE.nextval from dual' INTO PROJECTID;
  EXECUTE IMMEDIATE 'select REPORT_ID_SEQUENCE.nextval from dual' INTO REPORTID;
  EXECUTE IMMEDIATE 'INSERT INTO EMPLOYEE ( ID, NAME, HIREDATE, POSITION, SALARY ) VALUES ( :1, ''James Bond'', TO_DATE( ''2010-10-10'',''YYYY-MM-DD'' ), ''Java Developer'', 1200 )'
  USING EMPLOYEEID;
  EXECUTE IMMEDIATE 'INSERT INTO PROJECT ( ID, NAME, DESCRIPTION ) VALUES ( :1, ''Evaluating Competence'', ''Evaluate competence of employees'' )'
  USING PROJECTID;
  EXECUTE IMMEDIATE 'INSERT INTO EMPLOYEEPROJECT ( EMPLOYEEID, PROJECTID ) VALUES ( :1, :2 )'
  USING EMPLOYEEID, PROJECTID;
  EXECUTE IMMEDIATE 'INSERT INTO REPORT ( ID, EMPLOYEEID, PROJECTID, CREATEDATE, BODY ) VALUES ( :1, :2, :3, TO_DATE( ''2013-11-25'', ''YYYY-MM-DD'' ), ''We just started and our BA hard work on it!'' )'
  USING REPORTID, EMPLOYEEID, PROJECTID;

  EXECUTE IMMEDIATE 'select EMPLOYEE_ID_SEQUENCE.nextval from dual' INTO EMPLOYEEID;
  EXECUTE IMMEDIATE 'select PROJECT_ID_SEQUENCE.nextval from dual' INTO PROJECTID;
  EXECUTE IMMEDIATE 'select REPORT_ID_SEQUENCE.nextval from dual' INTO REPORTID;
  EXECUTE IMMEDIATE 'INSERT INTO EMPLOYEE ( ID, NAME, HIREDATE, POSITION, SALARY ) VALUES ( :1, ''Andrew Erlicson'', TO_DATE( ''2012-05-17'',''YYYY-MM-DD'' ), ''MondoDB DBA'', 1500 )'
  USING EMPLOYEEID;
  EXECUTE IMMEDIATE 'INSERT INTO PROJECT ( ID, NAME, DESCRIPTION ) VALUES ( :1, ''Blog post'', ''Make blog site for our employees'' )'
  USING PROJECTID;
  EXECUTE IMMEDIATE 'INSERT INTO EMPLOYEEPROJECT ( EMPLOYEEID, PROJECTID ) VALUES ( :1, :2 )'
  USING EMPLOYEEID, PROJECTID;
  EXECUTE IMMEDIATE 'INSERT INTO REPORT ( ID, EMPLOYEEID, PROJECTID, CREATEDATE, BODY ) VALUES ( :1, :2, :3, TO_DATE( ''2014-04-11'', ''YYYY-MM-DD'' ), ''It is really big project and i need somebody who can work with java driver for MongoDB!'' )'
  USING REPORTID, EMPLOYEEID, PROJECTID;

  EXECUTE IMMEDIATE 'select EMPLOYEE_ID_SEQUENCE.nextval from dual' INTO EMPLOYEEID;
  EXECUTE IMMEDIATE 'INSERT INTO EMPLOYEE ( ID, NAME, HIREDATE, POSITION, SALARY ) VALUES ( :1, ''John Hoffman'', TO_DATE( ''2014-07-22'',''YYYY-MM-DD'' ), ''Senior Java Developer'', 2000 )'
  USING EMPLOYEEID;
  EXECUTE IMMEDIATE 'INSERT INTO EMPLOYEEPROJECT ( EMPLOYEEID, PROJECTID ) VALUES ( :1, :2 )'
  USING EMPLOYEEID, PROJECTID;

  EXECUTE IMMEDIATE 'select REPORT_ID_SEQUENCE.nextval from dual' INTO REPORTID;
  EXECUTE IMMEDIATE 'INSERT INTO REPORT ( ID, EMPLOYEEID, PROJECTID, CREATEDATE, BODY ) VALUES ( :1, :2, :3, TO_DATE( ''2014-06-21'', ''YYYY-MM-DD'' ), ''Hello every one! I just start work on Blogpost project and i need db schema. Who can help me?'' )'
  USING REPORTID, EMPLOYEEID, PROJECTID;

  EXECUTE IMMEDIATE 'select EMPLOYEE_ID_SEQUENCE.nextval from dual' INTO EMPLOYEEID;
  EXECUTE IMMEDIATE 'select PROJECT_ID_SEQUENCE.nextval from dual' INTO PROJECTID;
  EXECUTE IMMEDIATE 'select REPORT_ID_SEQUENCE.nextval from dual' INTO REPORTID;
  EXECUTE IMMEDIATE 'INSERT INTO EMPLOYEE ( ID, NAME, HIREDATE, POSITION, SALARY ) VALUES ( :1, ''Alex Khromov'', TO_DATE( ''2014-08-04'',''YYYY-MM-DD'' ), ''Junior Java Developer'', 900 )'
  USING EMPLOYEEID;
  EXECUTE IMMEDIATE 'INSERT INTO PROJECT ( ID, NAME, DESCRIPTION ) VALUES ( :1, ''Reporting system'', ''Exchange information about project progress'' )'
  USING PROJECTID;
  EXECUTE IMMEDIATE 'INSERT INTO EMPLOYEEPROJECT ( EMPLOYEEID, PROJECTID ) VALUES ( :1, :2 )'
  USING EMPLOYEEID, PROJECTID;
  EXECUTE IMMEDIATE 'INSERT INTO REPORT ( ID, EMPLOYEEID, PROJECTID, CREATEDATE, BODY ) VALUES ( :1, :2, :3, TO_DATE( ''2014-08-07'', ''YYYY-MM-DD'' ), ''The DB schema is ready. Now i prepare test data for it.'' )'
  USING REPORTID, EMPLOYEEID, PROJECTID;
end;
/