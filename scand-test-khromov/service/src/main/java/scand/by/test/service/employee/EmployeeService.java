package scand.by.test.service.employee;

import scand.by.test.pojo.Employee;
import scand.by.test.service.exceptions.ServiceException;

import java.util.List;

public interface EmployeeService {

    List showEmployees() throws ServiceException;

    Employee showEmployee( Long id ) throws ServiceException;

    Employee addEmployee( Employee employee ) throws ServiceException;

    void updateEmployee( Employee employee ) throws ServiceException;

    void deleteEmployee( Employee employee ) throws ServiceException;
}
