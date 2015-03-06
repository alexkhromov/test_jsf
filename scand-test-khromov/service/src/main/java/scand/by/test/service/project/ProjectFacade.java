package scand.by.test.service.project;

import scand.by.test.pojo.Project;
import scand.by.test.service.exceptions.ServiceException;

import java.util.List;

public interface ProjectFacade {

    List showProjects() throws ServiceException;

    Project showProject( Long id ) throws ServiceException;

    Project addProject( Project project ) throws ServiceException;

    void updateProject( Project project ) throws ServiceException;

    void deleteProject( Project project ) throws ServiceException;
}
