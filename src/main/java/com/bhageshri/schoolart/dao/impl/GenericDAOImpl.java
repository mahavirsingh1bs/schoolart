/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bhageshri.schoolart.dao.impl;

import com.bhageshri.schoolart.dao.GenericDAO;
import com.bhageshri.schoolart.exception.DAOException;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author mahavir.singh
 */
public class GenericDAOImpl<ID extends Serializable, T> implements GenericDAO<ID, T> {

    @PersistenceContext
    protected EntityManager entityManager;
    /**
     * type
     */
    private Class<T> type;

    /**
     * Constructor default
     */
    public GenericDAOImpl() {
        Type t = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) t;
        type = (Class) pt.getActualTypeArguments()[1];
    }

    /**
     * This is a method to create a T.
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public T create(T t) throws DAOException {
        try {
            entityManager.persist(t);
            return t;
        } catch (PersistenceException exception) {
            // throw PersistenceExceptionUtil.convertPersistenceException(exception);
            throw new DAOException(exception);
        }
    }

    /**
     * This is to find an entity with given ID.
     */
    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public T find(ID id) throws DAOException {
        try {
            return (T) entityManager.find(type, id);
        } catch (PersistenceException exception) {
            //throw PersistenceExceptionUtil.convertPersistenceException(exception);
            throw new DAOException(exception);
        }
    }

    @Override
    public List<T> findAll() throws DAOException {
        Query query = entityManager.createQuery("SELECT t FROM " + type.getSimpleName() + " t");
        return query.getResultList();
    }
}
