package scand.by.test.controller;

import scand.by.test.pojo.Employee;
import scand.by.test.service.employee.EmployeeFacadeImpl;
import scand.by.test.service.exceptions.ServiceException;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmployeeConverterManagedBean implements Converter {

    private EmployeeFacadeImpl employeeFacade;

    public EmployeeFacadeImpl getEmployeeFacade() {

        return employeeFacade;
    }

    public void setEmployeeFacade( EmployeeFacadeImpl employeeFacade ) {

        this.employeeFacade = employeeFacade;
    }

    @Override
    public Object getAsObject( FacesContext context, UIComponent component, String value ) {

        if ( value == null || ( value.trim().length() == 0 ) )
            return null;

        Pattern pattern = Pattern.compile( "id=\\d+" );
        Matcher matcher = pattern.matcher( value );

        try {

            if ( matcher.find() )
                return getEmployeeFacade().showEmployee( Long.parseLong( matcher.group().replaceAll( "id=", "" ) ) );
        } catch ( ServiceException e ) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public String getAsString ( FacesContext context, UIComponent component, Object value ){

        if ( value instanceof Employee )
            return value.toString();

        return "";
    }
}