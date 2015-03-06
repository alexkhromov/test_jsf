@echo off
set currentDirectory=%cd%

sqlplus / as sysdba @%currentDirectory%\userScript.sql 
exit|sqlplus scand1khromov/scand1khromov @%currentDirectory%\dbScript.sql
exit|sqlplus scand1khromov/scand1khromov @%currentDirectory%\insertScript.sql

mvn clean install
pause