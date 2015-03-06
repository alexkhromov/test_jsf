package scand.by.test.service.report;

import scand.by.test.pojo.Report;
import scand.by.test.service.exceptions.ServiceException;

import java.util.List;

public interface ReportFacade {

    List showReports() throws ServiceException;

    Report showReport( Long id ) throws ServiceException;

    Report addReport( Report report ) throws ServiceException;

    void updateReport( Report report ) throws ServiceException;

    void deleteReport( Report report ) throws ServiceException;
}
