/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bhageshri.schoolart.dao;

import com.bhageshri.schoolart.domain.Exercise;
import java.util.List;

/**
 *
 * @author mahavir.singh
 */
public interface ExerciseDAO extends GenericDAO<Long, Exercise> {

    Exercise findExerciseByName(String name);
    List<Exercise> findExerciseByClassAndSubject(Long classId, Long subjectId);
}
