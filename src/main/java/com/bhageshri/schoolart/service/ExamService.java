/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bhageshri.schoolart.service;

import com.bhageshri.schoolart.bean.SectionCriteria;
import com.bhageshri.schoolart.domain.Question;
import com.bhageshri.schoolart.util.QuestionType;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Mahavir Singh
 */
public interface ExamService {
    Map<QuestionType, List<Question>> createExam(List<SectionCriteria> criteria, Long subjectId);
}
