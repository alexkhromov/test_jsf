package scand.by.test.service.report;

import org.apache.log4j.Logger;
import scand.by.test.dao.Dao;
import scand.by.test.dao.exceptions.DaoException;
import scand.by.test.pojo.Report;
import scand.by.test.service.exceptions.ServiceErrorCode;
import scand.by.test.service.exceptions.ServiceException;

import java.util.List;

public class ReportServiceImpl implements ReportService {

    private static Logger log = Logger.getLogger( ReportServiceImpl.class );

    private Dao< Report, Long > reportDao;

    public void setReportDao( Dao< Report, Long > reportDao ) {

        this.reportDao = reportDao;
    }

    @Override
    public List< Report > showReports() throws ServiceException {

        List< Report > reports;

        try {
            log.debug( String.format( "Try to show list of reports." ) );
            reports = reportDao.getAll();
            log.debug( String.format( "Get list of reports size = %s.", reports.size() ) );

            return reports;
        } catch ( DaoException e) {
            throw new ServiceException( e, ServiceErrorCode.SCAND_SRVC_300 );
        }
    }

    @Override
    public Report showReport( Long id ) throws ServiceException {

        Report report;

        try {
            log.debug( String.format( "Try to show report with id = %s.", id ) );
            report = reportDao.get( id );
            log.debug( String.format( "Get report with id = %s.", report.getId() ) );

            return report;
        } catch ( DaoException e) {
            throw new ServiceException( e, ServiceErrorCode.SCAND_SRVC_301, id );
        }
    }

    @Override
    public Report addReport( Report report ) throws ServiceException {

        try {
            log.debug( String.format( "Try to add report with id = %s.", report.getId() ) );
            report = reportDao.add( report );
            log.debug( String.format( "Added report with id = %s.", report.getId() ) );

            return report;
        } catch ( DaoException e) {
            throw new ServiceException( e, ServiceErrorCode.SCAND_SRVC_302, report.getId() );
        }
    }

    @Override
    public void updateReport( Report report ) throws ServiceException {

        try {
            log.debug( String.format( "Try to update report with id = %s.", report.getId() ) );
            reportDao.update( report );
            log.debug( String.format( "Updated report with id = %s.", report.getId() ) );
        } catch ( DaoException e) {
            throw new ServiceException( e, ServiceErrorCode.SCAND_SRVC_303, report.getId() );
        }
    }

    @Override
    public void deleteReport( Report report ) throws ServiceException {

        try {
            log.debug( String.format( "Try to delete report with id = %s.", report.getId() ) );
            reportDao.delete( report );
            log.debug( String.format( "Deleted report with id = %s.", report.getId() ) );
        } catch ( DaoException e) {
            throw new ServiceException( e, ServiceErrorCode.SCAND_SRVC_304, report.getId() );
        }
    }
}