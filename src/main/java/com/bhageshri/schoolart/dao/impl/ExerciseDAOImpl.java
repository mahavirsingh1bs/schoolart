/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bhageshri.schoolart.dao.impl;

import com.bhageshri.schoolart.dao.ExerciseDAO;
import com.bhageshri.schoolart.domain.Exercise;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author mahavir.singh
 */
@Repository
public class ExerciseDAOImpl extends GenericDAOImpl<Long, Exercise> implements ExerciseDAO {

    @Override
    public Exercise findExerciseByName(String name) {
        Query query = entityManager.createQuery("SELECT e FROM Exercise e WHERE e.name = :name");
        query.setParameter("name", name);
        return (Exercise)query.getSingleResult();
    }
    
}
