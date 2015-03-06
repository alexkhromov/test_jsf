package scand.by.test.controller;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import scand.by.test.pojo.Employee;
import scand.by.test.pojo.Project;
import scand.by.test.pojo.Report;
import scand.by.test.service.employee.EmployeeFacadeImpl;
import scand.by.test.service.exceptions.ServiceException;
import scand.by.test.service.report.ReportFacadeImpl;

import java.util.ArrayList;
import java.util.Date;

public class TestConfig {

    public static void main( String[] args ) throws ServiceException {

        ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext(
                new String[] {"spring/Database.xml", "spring/Employee.xml", "spring/Project.xml", "spring/Report.xml"});

        //--------------------------------------------------------------------------------------------

        EmployeeFacadeImpl empImp = appContext.getBean( "employeeFacade", EmployeeFacadeImpl.class );

        Employee employee = empImp.showEmployee( 1L );

        System.out.println( employee.toString() );
        System.out.println( employee.getProjects() );
        System.out.println( employee.getReports() + "\n\n" );

        //--------------------------------------------------------------------------------------------

        scand.by.test.service.project.ProjectFacadeImpl projImpl = appContext.getBean( "projectFacade", scand.by.test.service.project.ProjectFacadeImpl.class );

        Project project = projImpl.showProject( 1L );

        System.out.println( project.toString() );
        System.out.println( project.getEmployees() );
        System.out.println( project.getReports() + "\n\n" );

        //--------------------------------------------------------------------------------------------

        ReportFacadeImpl repoImpl = appContext.getBean( "reportFacade", ReportFacadeImpl.class );

        Report report = repoImpl.showReport( 1L );

        System.out.println( report.toString() );
        System.out.println( report.getEmployee() );
        System.out.println( report.getProject() + "\n\n" );

        //--------------------------------------------------------------------------------------------

        Employee addEmp = new Employee();

        addEmp.setHireDate( new Date() );
        addEmp.setName( "James Bond" );
        addEmp.setPosition( "Java Developer" );
        addEmp.setSalary( 800 );
        addEmp.setProjects( new ArrayList< Project >() );
        addEmp.setReports( new ArrayList< Report >() );

        Project addProj = new Project();

        addProj.setName( "Evaluating Competence" );
        addProj.setDescription( "Evaluate competence of employees" );
        addProj.setEmployees( new ArrayList< Employee >() );
        addProj.setReports( new ArrayList< Report >() );

        Report addRepo = new Report();

        addRepo.setCreateDate( new Date() );
        addRepo.setBody( "We just started and our BA hard work on it!" );

        addEmp.getProjects().add( addProj );
        addEmp.getReports().add( addRepo );

        addProj.getEmployees().add( addEmp );
        addProj.getReports().add( addRepo );

        addRepo.setEmployee( addEmp );
        addRepo.setProject( addProj );

        projImpl.addProject( addProj );
        empImp.addEmployee( addEmp );
        repoImpl.addReport( addRepo );

        System.out.println( "\n" );

        //--------------------------------------------------------------------------------------------

        addEmp.getProjects().add( project );

        empImp.updateEmployee( addEmp );
    }
}
