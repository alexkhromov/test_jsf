package scand.by.test.service.project;

import scand.by.test.pojo.Project;
import scand.by.test.service.exceptions.ServiceException;

import java.util.List;

public class ProjectFacadeImpl implements ProjectFacade {

    private ProjectService projectService;

    public void setProjectService( ProjectService projectService ) {

        this.projectService = projectService;
    }

    @Override
    public List showProjects() throws ServiceException {

        return this.projectService.showProjects();
    }

    @Override
    public Project showProject( Long id ) throws ServiceException {

        return this.projectService.showProject( id );
    }

    @Override
    public Project addProject( Project project ) throws ServiceException {

        return this.projectService.addProject( project );
    }

    @Override
    public void updateProject( Project project ) throws ServiceException {

        this.projectService.updateProject( project );
    }

    @Override
    public void deleteProject( Project project ) throws ServiceException {

        this.projectService.deleteProject( project );
    }
}
