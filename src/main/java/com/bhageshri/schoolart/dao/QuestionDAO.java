/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bhageshri.schoolart.dao;

import com.bhageshri.schoolart.domain.Exercise;
import com.bhageshri.schoolart.domain.Question;
import com.bhageshri.schoolart.util.QuestionType;
import java.util.List;

/**
 *
 * @author mahavir.singh
 */
public interface QuestionDAO extends GenericDAO<Long, Question> {

    /**
     * find the questions by question types
     *
     * @param type question type
     * @return questions of this type
     */
    List<Question> findQuestionByType(QuestionType type);

    /**
     * find the questions by exercise and type
     *
     * @param exercise exercise
     * @param type question type
     * @return question of this exercise and of this type
     */
    List<Question> findQuestionByExerciseAndType(Exercise exercise,
            QuestionType type);

    /**
     *
     * @param id
     * @return
     */
    List<Question> findQuestionByExerciseId(Long id);
    
    /**
     * 
     * @param type
     * @param subjectId
     * @return 
     */
    List<Question> findQuestionByTypeAndSubject(QuestionType type, Long subjectId);
}
