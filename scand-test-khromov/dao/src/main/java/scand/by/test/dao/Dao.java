package scand.by.test.dao;

import scand.by.test.dao.exceptions.DaoException;
import org.hibernate.Criteria;
import org.hibernate.Query;

import java.io.Serializable;
import java.util.List;

public interface Dao< T, PK extends Serializable > {

    List< T > getAll() throws DaoException;

    T get( PK id ) throws DaoException;

    T add( T object ) throws DaoException;

    void update( T object ) throws DaoException;

    void delete( T object ) throws DaoException;

    Criteria getCriteria() throws DaoException;

    Query getQuery( String hql ) throws DaoException;
}