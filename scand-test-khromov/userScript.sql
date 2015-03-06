DROP USER scand1khromov CASCADE;
CREATE USER scand1khromov IDENTIFIED BY scand1khromov;
grant connect, resource, dba to scand1khromov;
connect scand1khromov/scand1khromov;
exit;