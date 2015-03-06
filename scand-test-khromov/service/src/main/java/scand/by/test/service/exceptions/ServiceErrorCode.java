package scand.by.test.service.exceptions;

public enum ServiceErrorCode {

    SCAND_SRVC_100( "Failed to get list of employees." ),
    SCAND_SRVC_101( "Failed to get employee, id = %d." ),
    SCAND_SRVC_102( "Failed to add employee, id = %d." ),
    SCAND_SRVC_103( "Failed to update employee, id = %d." ),
    SCAND_SRVC_104( "Failed to delete employee, id = %d." ),

    SCAND_SRVC_200( "Failed to get list of projects." ),
    SCAND_SRVC_201( "Failed to get project, id = %d." ),
    SCAND_SRVC_202( "Failed to add project, id = %d." ),
    SCAND_SRVC_203( "Failed to update project, id = %d." ),
    SCAND_SRVC_204( "Failed to delete project, id = %d." ),

    SCAND_SRVC_300( "Failed to get list of reports." ),
    SCAND_SRVC_301( "Failed to get report, id = %d." ),
    SCAND_SRVC_302( "Failed to add report, id = %d." ),
    SCAND_SRVC_303( "Failed to update report, id = %d." ),
    SCAND_SRVC_304( "Failed to delete report, id = %d." );

    private final String value;

    private ServiceErrorCode( String s ) {

        value = s;
    }

    public boolean equalsValue( String value2 ) {

        return ( value2 == null ) ? false : value.equals( value2 );
    }

    public String toString() {

        return value;
    }
}