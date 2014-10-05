/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bhageshri.schoolart.service.impl;

import com.bhageshri.schoolart.bean.SectionCriteria;
import com.bhageshri.schoolart.dao.QuestionDAO;
import com.bhageshri.schoolart.domain.Question;
import com.bhageshri.schoolart.service.ExamService;
import com.bhageshri.schoolart.util.QuestionType;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Mahavir Singh
 */
public class ExamServiceImpl implements ExamService {
    
    @Autowired
    private QuestionDAO questionDAO;

    public void setQuestionDAO(QuestionDAO questionDAO) {
        this.questionDAO = questionDAO;
    }

    public Map<QuestionType, List<Question>> createExam(List<SectionCriteria> criteria, Long subjectId) {
        Map<QuestionType, List<Question>> examPaper = new HashMap<>();
        for (SectionCriteria sectionCriteria : criteria) {
            List<Question> questions = questionDAO.findQuestionByTypeAndSubject(sectionCriteria.getType(), subjectId);
            examPaper.put(sectionCriteria.getType(), questions);
        }
        return examPaper;
    }
    
}
