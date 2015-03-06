package scand.by.test.service.report;

import scand.by.test.pojo.Report;
import scand.by.test.service.exceptions.ServiceException;

import java.util.List;

public class ReportFacadeImpl implements ReportFacade {

    private ReportService reportService;

    public void setReportService( ReportService reportService ) {

        this.reportService = reportService;
    }

    @Override
    public List showReports() throws ServiceException {

        return this.reportService.showReports();
    }

    @Override
    public Report showReport( Long id ) throws ServiceException {

        return this.reportService.showReport( id );
    }

    @Override
    public Report addReport( Report report ) throws ServiceException {

        return this.reportService.addReport( report );
    }

    @Override
    public void updateReport(Report report) throws ServiceException {

        this.reportService.updateReport( report );
    }

    @Override
    public void deleteReport(Report report) throws ServiceException {

        this.reportService.deleteReport( report );
    }
}
