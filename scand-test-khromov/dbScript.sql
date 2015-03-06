begin
  EXECUTE IMMEDIATE 'create table EMPLOYEE( ID NUMBER PRIMARY KEY, NAME VARCHAR2( 255 CHAR ), HIREDATE DATE, POSITION VARCHAR2( 255 CHAR ), SALARY NUMBER )';
  EXECUTE IMMEDIATE 'create table PROJECT( ID NUMBER PRIMARY KEY, NAME VARCHAR2( 255 CHAR ), DESCRIPTION VARCHAR2( 500 CHAR ) )';
  EXECUTE IMMEDIATE 'create table REPORT( ID NUMBER PRIMARY KEY, EMPLOYEEID NUMBER, PROJECTID NUMBER, CREATEDATE DATE, BODY VARCHAR2( 1000 CHAR ) )';
  EXECUTE IMMEDIATE 'create table EMPLOYEEPROJECT( EMPLOYEEID NUMBER, PROJECTID NUMBER )';
  
  EXECUTE IMMEDIATE 'create sequence EMPLOYEE_ID_SEQUENCE start with 1 increment by 1';
  EXECUTE IMMEDIATE 'create sequence PROJECT_ID_SEQUENCE start with 1 increment by 1';
  EXECUTE IMMEDIATE 'create sequence REPORT_ID_SEQUENCE start with 1 increment by 1';
  
  EXECUTE IMMEDIATE 'alter table REPORT add foreign key( EMPLOYEEID ) references EMPLOYEE( ID ) on delete cascade';
  EXECUTE IMMEDIATE 'alter table REPORT add foreign key( PROJECTID ) references PROJECT( ID ) on delete cascade';
  EXECUTE IMMEDIATE 'alter table EMPLOYEEPROJECT add foreign key ( EMPLOYEEID ) references EMPLOYEE( ID ) on delete cascade';
  EXECUTE IMMEDIATE 'alter table EMPLOYEEPROJECT add foreign key ( PROJECTID ) references PROJECT( ID ) on delete cascade';
end;
/