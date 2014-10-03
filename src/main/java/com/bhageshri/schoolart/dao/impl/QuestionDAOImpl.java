/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bhageshri.schoolart.dao.impl;

import com.bhageshri.schoolart.dao.QuestionDAO;
import com.bhageshri.schoolart.domain.Exercise;
import com.bhageshri.schoolart.domain.Question;
import com.bhageshri.schoolart.util.QuestionType;
import java.util.List;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author mahavir.singh
 */
@Repository
public class QuestionDAOImpl extends GenericDAOImpl<Long, Question> implements QuestionDAO {

    @Override
    public List<Question> findQuestionByType(QuestionType type) {
        Query query = entityManager.createQuery("SELECT q FROM Question q WHERE q.questionType = :type");
        query.setParameter("type", type);
        return (List<Question>) query.getResultList();
    }

    @Override
    public List<Question> findQuestionByExerciseAndType(Exercise exercise, QuestionType type) {
        Query query = entityManager.createQuery("SELECT q FROM Question q WHERE q.exercise = :exercise AND q.questionType = :type");
        query.setParameter("exercise", exercise);
        query.setParameter("type", type);
        return (List<Question>) query.getResultList();
    }

    @Override
    public List<Question> findQuestionByExerciseId(Long id) {
        Query query = entityManager.createQuery("SELECT q FROM Question q WHERE q.exercise.id = :exerciseId");
        query.setParameter("exerciseId", id);
        return (List<Question>) query.getResultList();
    }
    
}
