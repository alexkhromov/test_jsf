package scand.by.test.dao.exceptions;

public enum DaoErrorCode {

    SCAND_DAO_000( "Failed to get %s by id = %s" ),
    SCAND_DAO_001( "Failed to get list of < %s >" ),
    SCAND_DAO_002( "Failed to create object %s" ),
    SCAND_DAO_003( "Failed to update object %s" ),
    SCAND_DAO_004( "Failed to delete object %s" ),
    SCAND_DAO_005( "Failed to create criteria for type %s" ),
    SCAND_DAO_006( "Failed to create hql: %s" );

    private final String value;

    private DaoErrorCode( String s ) {

        value = s;
    }

    public boolean equalsValue( String value2 ) {

        return ( value2 != null ) && value.equals( value2 );
    }

    public String toString() {

        return value;
    }
}
