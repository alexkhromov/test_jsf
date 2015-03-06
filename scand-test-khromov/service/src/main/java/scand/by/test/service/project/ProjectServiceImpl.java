package scand.by.test.service.project;

import org.apache.log4j.Logger;
import scand.by.test.dao.Dao;
import scand.by.test.dao.exceptions.DaoException;
import scand.by.test.pojo.Project;
import scand.by.test.service.exceptions.ServiceErrorCode;
import scand.by.test.service.exceptions.ServiceException;

import java.util.List;

public class ProjectServiceImpl implements ProjectService {

    private static Logger log = Logger.getLogger( ProjectServiceImpl.class );

    private Dao< Project, Long > projectDao;

    public void setProjectDao( Dao< Project, Long > projectDao ) {

        this.projectDao = projectDao;
    }

    @Override
    public List< Project > showProjects() throws ServiceException {

        List< Project > projects;

        try {
            log.debug( String.format( "Try to show list of projects." ) );
            projects = projectDao.getAll();
            log.debug( String.format( "Get list of projects size = %s.", projects.size() ) );

            return projects;
        } catch ( DaoException e) {
            throw new ServiceException( e, ServiceErrorCode.SCAND_SRVC_200 );
        }
    }

    @Override
    public Project showProject( Long id ) throws ServiceException {

        Project project;

        try {
            log.debug( String.format( "Try to show project with id = %s.", id ) );
            project = projectDao.get( id );
            log.debug( String.format( "Get project with id = %s.", project.getId() ) );

            return project;
        } catch ( DaoException e) {
            throw new ServiceException( e, ServiceErrorCode.SCAND_SRVC_201, id );
        }
    }

    @Override
    public Project addProject( Project project ) throws ServiceException {

        try {
            log.debug( String.format( "Try to add project with id = %s.", project.getId() ) );
            project = projectDao.add( project );
            log.debug( String.format( "Added project with id = %s.", project.getId() ) );

            return project;
        } catch ( DaoException e) {
            throw new ServiceException( e, ServiceErrorCode.SCAND_SRVC_202, project.getId() );
        }
    }

    @Override
    public void updateProject( Project project ) throws ServiceException {

        try {
            log.debug( String.format( "Try to update project with id = %s.", project.getId() ) );
            projectDao.update( project );
            log.debug( String.format( "Updated project with id = %s.", project.getId() ) );
        } catch ( DaoException e) {
            throw new ServiceException( e, ServiceErrorCode.SCAND_SRVC_203, project.getId() );
        }
    }

    @Override
    public void deleteProject( Project project ) throws ServiceException {

        try {
            log.debug( String.format( "Try to delete project with id = %s.", project.getId() ) );
            projectDao.delete( project );
            log.debug( String.format( "Deleted project with id = %s.", project.getId() ) );
        } catch ( DaoException e) {
            throw new ServiceException( e, ServiceErrorCode.SCAND_SRVC_204, project.getId() );
        }
    }
}