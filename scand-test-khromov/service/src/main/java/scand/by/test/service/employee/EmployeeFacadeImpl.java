package scand.by.test.service.employee;

import scand.by.test.pojo.Employee;
import scand.by.test.service.exceptions.ServiceException;

import java.util.List;

public class EmployeeFacadeImpl implements EmployeeFacade {

    private EmployeeService employeeService;

    public void setEmployeeService( EmployeeService employeeService ) {

        this.employeeService = employeeService;
    }

    @Override
    public List showEmployees() throws ServiceException {

        return this.employeeService.showEmployees();
    }

    @Override
    public Employee showEmployee( Long id ) throws ServiceException {

        return this.employeeService.showEmployee( id );
    }

    @Override
    public Employee addEmployee( Employee employee ) throws ServiceException {

        return this.employeeService.addEmployee( employee );
    }

    @Override
    public void updateEmployee( Employee employee ) throws ServiceException {

        this.employeeService.updateEmployee( employee );
    }

    @Override
    public void deleteEmployee( Employee employee ) throws ServiceException {

        this.employeeService.deleteEmployee( employee );
    }
}
