package scand.by.test.controller;

import scand.by.test.pojo.Project;
import scand.by.test.service.exceptions.ServiceException;
import scand.by.test.service.project.ProjectFacadeImpl;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProjectConverterManagedBean implements Converter {

    private ProjectFacadeImpl projectFacade;

    public ProjectFacadeImpl getProjectFacade() {

        return projectFacade;
    }

    public void setProjectFacade( ProjectFacadeImpl projectFacade ) {

        this.projectFacade = projectFacade;
    }

    @Override
    public Object getAsObject( FacesContext context, UIComponent component, String value ) {

        if ( value == null || ( value.trim().length() == 0 ) )
            return null;

        Pattern pattern = Pattern.compile( "id=\\d+" );
        Matcher matcher = pattern.matcher( value );

        try {

            if ( matcher.find() )
                return getProjectFacade().showProject( Long.parseLong( matcher.group().replaceAll( "id=", "" ) ) );
        } catch ( ServiceException e ) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public String getAsString ( FacesContext context, UIComponent component, Object value ){

        if ( value instanceof Project )
            return value.toString();

        return "";
    }
}