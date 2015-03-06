package scand.by.test.controller;

import org.primefaces.event.SelectEvent;
import scand.by.test.pojo.Employee;
import scand.by.test.pojo.Project;
import scand.by.test.pojo.Report;
import scand.by.test.service.report.ReportFacadeImpl;
import scand.by.test.service.exceptions.ServiceException;

import javax.faces.component.UIOutput;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReportManagedBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private ReportFacadeImpl reportFacade;

    private Date createDate;
    private Employee employee;
    private Project project;
    private String body;

    private List< Report > reports;
    private Report reportSelected;

    private List< Employee > availableEmployees;

    public ReportFacadeImpl getReportFacade() {

        return reportFacade;
    }

    public void setReportFacade( ReportFacadeImpl reportFacade ) {

        this.reportFacade = reportFacade;
    }

    public Date getCreateDate() {

        createDate = new Date();

        return createDate;
    }

    public void setCreateDate( Date createDate ) {

        this.createDate = createDate;
    }

    public Employee getEmployee() {

        return employee;
    }

    public void setEmployee( Employee employee ) {

        this.employee = employee;
    }

    public Project getProject() {

        return project;
    }

    public void setProject( Project project ) {

        this.project = project;
    }

    public String getBody() {

        return body;
    }

    public void setBody( String body ) {

        this.body = body;
    }

    public List getReports() throws ServiceException {

        reports = new ArrayList< Report >();
        reports.addAll( getReportFacade().showReports() );

        return reports;
    }

    public void addReport() throws ServiceException, IOException {

        Report report = new Report();
        report.setCreateDate( getCreateDate() );
        report.setEmployee( getEmployee() );
        report.setProject( getProject() );
        report.setBody( getBody() );

        getReportFacade().addReport( report );

        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        FacesContext.getCurrentInstance().getExternalContext().redirect( "/scand-test-jsf/" );
    }

    public void deleteReport() throws ServiceException, IOException {

        getReportFacade().deleteReport( reportSelected );

        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        FacesContext.getCurrentInstance().getExternalContext().redirect( "/scand-test-jsf/" );

        reportSelected = null;
    }

    public void editReport() throws ServiceException, IOException {

        reportSelected.setCreateDate( getCreateDate() );
        reportSelected.setEmployee( getEmployee() );
        reportSelected.setProject( getProject() );

        getReportFacade().updateReport( reportSelected );

        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        FacesContext.getCurrentInstance().getExternalContext().redirect( "/scand-test-jsf/" );

        createDate = null;
        employee = null;
        project = null;
        body = null;
        availableEmployees = null;
        reportSelected = null;
    }

    public Report getReportSelected() {

        return reportSelected;
    }

    public void setReportSelected( Report reportSelected ) {

        this.reportSelected = reportSelected;
    }

    public void onRowSelect( SelectEvent event ) {

        this.reportSelected = ( Report ) event.getObject();
    }

    public List< Employee > getAvailableEmployees() {

        return availableEmployees;
    }

    public void onProjectSelect( AjaxBehaviorEvent event ) {

        availableEmployees = project.getEmployees();
    }

    public void onEditProjectSelect( AjaxBehaviorEvent event ) {

        project = ( Project ) ( ( UIOutput )event.getSource() ).getValue();
        availableEmployees = project.getEmployees();
    }

    public void onEmployeeSelect( AjaxBehaviorEvent event ) {
    }

    public void onEditEmployeeSelect( AjaxBehaviorEvent event ) {

        employee = ( Employee ) ( ( UIOutput )event.getSource() ).getValue();
    }

    public void onCloseDialog() throws IOException {

        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        FacesContext.getCurrentInstance().getExternalContext().redirect( "/scand-test-jsf/" );

        createDate = null;
        employee = null;
        project = null;
        body = null;
        availableEmployees = null;
        reportSelected = null;
    }
}
