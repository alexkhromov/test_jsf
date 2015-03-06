package scand.by.test.service.employee;

import scand.by.test.dao.Dao;
import scand.by.test.dao.exceptions.DaoException;
import scand.by.test.pojo.Employee;
import scand.by.test.service.exceptions.ServiceErrorCode;
import scand.by.test.service.exceptions.ServiceException;

import org.apache.log4j.Logger;
import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {

    private static Logger log = Logger.getLogger( EmployeeServiceImpl.class );

    private Dao< Employee, Long > employeeDao;

    public void setEmployeeDao( Dao< Employee, Long > employeeDao ) {

        this.employeeDao = employeeDao;
    }

    @Override
    public List< Employee > showEmployees() throws ServiceException {

        List< Employee > employees;

        try {
            log.debug( String.format( "Try to show list of employees." ) );
            employees = employeeDao.getAll();
            log.debug( String.format( "Get list of employees size = %s.", employees.size() ) );

            return employees;
        } catch ( DaoException e) {
            throw new ServiceException( e, ServiceErrorCode.SCAND_SRVC_100 );
        }
    }

    @Override
    public Employee showEmployee( Long id ) throws ServiceException {

        Employee employee;

        try {
            log.debug( String.format( "Try to show employee with id = %s.", id ) );
            employee = employeeDao.get( id );
            log.debug( String.format( "Get employee with id = %s.", employee.getId() ) );

            return employee;
        } catch ( DaoException e) {
            throw new ServiceException( e, ServiceErrorCode.SCAND_SRVC_101, id );
        }
    }

    @Override
    public Employee addEmployee( Employee employee ) throws ServiceException {

        try {
            log.debug( String.format( "Try to add employee with id = %s.", employee.getId() ) );
            employee = employeeDao.add( employee );
            log.debug( String.format( "Added employee with id = %s.", employee.getId() ) );

            return employee;
        } catch ( DaoException e) {
            throw new ServiceException( e, ServiceErrorCode.SCAND_SRVC_102, employee.getId() );
        }
    }

    @Override
    public void updateEmployee( Employee employee ) throws ServiceException {

        try {
            log.debug( String.format( "Try to update employee with id = %s.", employee.getId() ) );
            employeeDao.update( employee );
            log.debug( String.format( "Updated employee with id = %s.", employee.getId() ) );
        } catch ( DaoException e) {
            throw new ServiceException( e, ServiceErrorCode.SCAND_SRVC_103, employee.getId() );
        }
    }

    @Override
    public void deleteEmployee( Employee employee ) throws ServiceException {

        try {
            log.debug( String.format( "Try to delete employee with id = %s.", employee.getId() ) );
            employeeDao.delete( employee );
            log.debug( String.format( "Deleted employee with id = %s.", employee.getId() ) );
        } catch ( DaoException e) {
            throw new ServiceException( e, ServiceErrorCode.SCAND_SRVC_104, employee.getId() );
        }
    }
}