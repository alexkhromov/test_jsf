package scand.by.test.dao;

import org.apache.log4j.Logger;
import org.hibernate.*;
import scand.by.test.dao.exceptions.DaoErrorCode;
import scand.by.test.dao.exceptions.DaoException;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

public class DaoImpl< T, PK extends Serializable > implements Dao< T, PK > {

    private static Logger log = Logger.getLogger( DaoImpl.class );

    private SessionFactory sessionFactory;
    private Class< T > type;
    private String typeName;

    public void setType( Class< T > type ) {

        this.type = type;
        typeName = type.getSimpleName();
    }

    public void setSessionFactory( SessionFactory sessionFactory ) {

        this.sessionFactory = sessionFactory;
    }

    @Override
    public List< T > getAll() throws DaoException {

        log.debug( String.format( "Get all < %s >.", typeName ) );

        try {
            List< T > list = getSession().createCriteria( type ).list();
            log.debug( String.format( "Got %d items", list == null ? 0 : list.size() ) );

            return list;
        } catch ( HibernateException e ) {
            throw new DaoException( e, DaoErrorCode.SCAND_DAO_001, typeName );
        }
    }

    @Override
    public T get( PK id ) throws DaoException {

        try {
            log.debug( String.format( "Get %s with id = %s.", typeName, id ) );
            T object = ( T ) getSession().get( type, id );
            log.debug( String.format( "Got %s: %s.", typeName, object ) );

            return object;
        } catch ( HibernateException e ) {
            throw new DaoException( e, DaoErrorCode.SCAND_DAO_000, typeName, id );
        }
    }

    @Override
    public T add( T object ) throws DaoException {

        try {
            log.info( String.format( "Create %s: %s.", typeName, object ) );
            PK id = ( PK ) getSession().save( object );
            log.info( String.format( "Created %s with id = %s.", typeName, id ) );

            return get( id );
        } catch ( HibernateException e ) {
            throw new DaoException( e, DaoErrorCode.SCAND_DAO_002, object );
        }
    }

    @Override
    public void update( T object ) throws DaoException {

        try {
            log.debug( String.format( "Update %s: %s.", typeName, object ) );
            getSession().update( object );
            log.debug(String.format( "Updated %s: %s.", typeName, object ) );
        } catch ( HibernateException e ) {
            throw new DaoException( e, DaoErrorCode.SCAND_DAO_003, object );
        }
    }

    @Override
    public void delete( T object ) throws DaoException {

        try {
            log.debug( String.format( "Delete %s: %s.", typeName, object ) );

            if ( object != null ) {

                getSession().delete( object );
                log.debug(String.format( "Deleted %s: %s.", typeName, object ) );
            }
        } catch ( HibernateException e ) {
            throw new DaoException( e, DaoErrorCode.SCAND_DAO_004, object );
        }
    }

    @Override
    public Criteria getCriteria() throws DaoException {

        try {
            Criteria criteria = getSession().createCriteria( type );
            log.debug( String.format( "Created criteria for type %s.", typeName ) );

            return criteria;
        } catch ( HibernateException e ) {
            throw new DaoException( e, DaoErrorCode.SCAND_DAO_005, typeName );
        }
    }

    @Override
    public Query getQuery( String hql ) throws DaoException {

        try {
            Query query = getSession().createQuery( hql );
            log.debug( String.format( "Created query: %s.", hql ) );

            return query;
        } catch ( HibernateException e ) {
            throw new DaoException( e, DaoErrorCode.SCAND_DAO_006, hql );
        }
    }

    private Session getSession() {

        Session session = sessionFactory.getCurrentSession();

        log.debug( String.format( "Got current session for %s: %s.", typeName, session ) );

        return session;
    }
}