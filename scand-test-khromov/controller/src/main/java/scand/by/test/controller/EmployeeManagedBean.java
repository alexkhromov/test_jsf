package scand.by.test.controller;

import org.primefaces.event.SelectEvent;
import scand.by.test.pojo.Employee;
import scand.by.test.pojo.Project;
import scand.by.test.service.employee.EmployeeFacadeImpl;
import scand.by.test.service.exceptions.ServiceException;

import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EmployeeManagedBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private EmployeeFacadeImpl employeeFacade;

    private String name;
    private Date hireDate;
    private String position;
    private Integer salary;

    private List< Project > projects;
    private List< Employee > employees;
    private Employee employeeSelected;

    public EmployeeFacadeImpl getEmployeeFacade() {

        return employeeFacade;
    }

    public void setEmployeeFacade( EmployeeFacadeImpl employeeFacade ) {

        this.employeeFacade = employeeFacade;
    }

    public String getName() {

        return name;
    }

    public void setName( String name ) {

        this.name = name;
    }

    public Date getHireDate() {

        return hireDate;
    }

    public void setHireDate( Date hireDate ) {

        this.hireDate = hireDate;
    }

    public String getPosition() {

        return position;
    }

    public void setPosition( String position ) {

        this.position = position;
    }

    public Integer getSalary() {

        return salary;
    }

    public void setSalary( Integer salary ) {

        this.salary = salary;
    }

    public List< Project > getProjects() {

        return projects;
    }

    public void setProjects( List< Project > projects ) {

        this.projects = projects;
    }

    public List< Employee > getEmployees() throws ServiceException {

        employees = new ArrayList< Employee >();
        employees.addAll( getEmployeeFacade().showEmployees() );

        return employees;
    }

    public void setEmployees( List< Employee > employees ) {

        this.employees = employees;
    }

    public Employee getEmployeeSelected() {

        return employeeSelected;
    }

    public void setEmployeeSelected( Employee employeeSelected ) {

        this.employeeSelected = employeeSelected;
    }

    public void addEmployee() throws ServiceException, IOException {

        Employee employee = new Employee();
        employee.setName( getName() );
        employee.setHireDate( getHireDate() );
        employee.setPosition( getPosition() );
        employee.setSalary( getSalary() );

        employee.setProjects( getProjects() );

        getEmployeeFacade().addEmployee( employee);

        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        FacesContext.getCurrentInstance().getExternalContext().redirect( "/scand-test-jsf/" );
    }

    public void deleteEmployee() throws ServiceException, IOException {

        getEmployeeFacade().deleteEmployee( employeeSelected );

        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        FacesContext.getCurrentInstance().getExternalContext().redirect( "/scand-test-jsf/" );

        employeeSelected = null;
    }

    public void editEmployee() throws ServiceException, IOException {

        employeeSelected.setProjects( getProjects() );

        getEmployeeFacade().updateEmployee( employeeSelected );

        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        FacesContext.getCurrentInstance().getExternalContext().redirect( "/scand-test-jsf/" );

        name = null;
        hireDate = null;
        position = null;
        salary = null;
        employeeSelected = null;
    }

    public void onRowSelect( SelectEvent event ) {

        this.employeeSelected = ( Employee ) event.getObject();
    }

    public void onProjectSelect( AjaxBehaviorEvent event ) {
    }

    public void onCloseDialog() throws IOException {

        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        FacesContext.getCurrentInstance().getExternalContext().redirect( "/scand-test-jsf/" );

        employeeSelected = null;
    }
}
