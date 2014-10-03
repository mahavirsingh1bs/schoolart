/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bhageshri.schoolart.dao;

import com.bhageshri.schoolart.exception.DAOException;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author mahavir.singh
 */
public interface GenericDAO<ID extends Serializable, T> {

    /**
     * This is a method to create a T.
     *
     * @param t
     * @return
     */
    T create(T t) throws DAOException;

    /**
     * This is to find an entity with given ID.
     *
     * @param id
     * @return
     */
    T find(ID id) throws DAOException;
    
    List<T> findAll() throws DAOException;
}
