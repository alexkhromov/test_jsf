package scand.by.test.controller;

import org.primefaces.event.SelectEvent;
import scand.by.test.pojo.Employee;
import scand.by.test.pojo.Project;
import scand.by.test.service.employee.EmployeeFacadeImpl;
import scand.by.test.service.project.ProjectFacadeImpl;
import scand.by.test.service.exceptions.ServiceException;

import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ProjectManagedBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private ProjectFacadeImpl projectFacade;
    private EmployeeFacadeImpl employeeFacade;

    private String name;
    private String description;

    private List< Project > projects;
    private List< Employee > employees;
    private Project projectSelected;

    public ProjectFacadeImpl getProjectFacade() {

        return projectFacade;
    }

    public void setProjectFacade( ProjectFacadeImpl projectFacade ) {

        this.projectFacade = projectFacade;
    }

    public String getName() {

        return name;
    }

    public EmployeeFacadeImpl getEmployeeFacade() {

        return employeeFacade;
    }

    public void setEmployeeFacade( EmployeeFacadeImpl employeeFacade ) {

        this.employeeFacade = employeeFacade;
    }

    public void setName( String name ) {

        this.name = name;
    }

    public String getDescription() {

        return description;
    }

    public void setDescription( String description ) {

        this.description = description;
    }

    public List getProjects() throws ServiceException {

        projects = new ArrayList< Project >();
        projects.addAll( getProjectFacade().showProjects() );

        if ( projectSelected ==  null && projects.size() > 0 )
            setProjectSelected( projects.get(  0 ) );

        return projects;
    }

    public void setProjects( List< Project > projects ) {

        this.projects = projects;
    }

    public List< Employee > getEmployees() {

        return employees;
    }

    public void setEmployees( List< Employee > employees ) {

        this.employees = employees;
    }

    public Project getProjectSelected() {

        return projectSelected;
    }

    public void setProjectSelected( Project projectSelected ) {

        this.projectSelected = projectSelected;
    }

    public void addProject() throws ServiceException, IOException {

        Project project = new Project();
        project.setName( getName() );
        project.setDescription(getDescription());

        project.setEmployees( getEmployees() );

        getProjectFacade().addProject( project );

        for ( int i = 0; i < employees.size(); i++ ) {

            Employee emp = employees.get( i );
            emp.getProjects().add( project );
            getEmployeeFacade().updateEmployee( emp );
        }

        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        FacesContext.getCurrentInstance().getExternalContext().redirect( "/scand-test-jsf/" );
    }

    public void deleteProject() throws ServiceException, IOException {

        getProjectFacade().deleteProject( projectSelected );

        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        FacesContext.getCurrentInstance().getExternalContext().redirect( "/scand-test-jsf/" );

        projectSelected = null;
    }

    public void editProject() throws ServiceException, IOException {

        projectSelected.setEmployees( getEmployees() );

        getProjectFacade().updateProject( projectSelected );

        List< Employee > employeeList = employeeFacade.showEmployees();

        for ( int i = 0; i < employeeList.size(); i++ ) {

            List< Project > projectList = employeeList.get( i ).getProjects();

            if ( projectList.contains( projectSelected ) ) {

                projectList.remove( projectSelected );
                getEmployeeFacade().updateEmployee( employeeList.get( i ) );
            }
        }

        for ( int i = 0; i < employees.size(); i++ ) {

            Employee emp = employees.get( i );
            emp.getProjects().add( projectSelected );
            getEmployeeFacade().updateEmployee( emp );
        }

        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        FacesContext.getCurrentInstance().getExternalContext().redirect("/scand-test-jsf/");

        name = null;
        description = null;
        projectSelected = null;
    }

    public void onRowSelect( SelectEvent event ) {

        this.projectSelected = ( Project ) event.getObject();
    }

    public void onEmployeeSelect( AjaxBehaviorEvent event ) {
    }

    public void onCloseDialog() throws IOException {

        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        FacesContext.getCurrentInstance().getExternalContext().redirect( "/scand-test-jsf/" );

        projectSelected = null;
    }
}
