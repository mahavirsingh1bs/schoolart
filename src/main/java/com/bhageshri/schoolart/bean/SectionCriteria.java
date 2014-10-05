/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bhageshri.schoolart.bean;

import com.bhageshri.schoolart.util.QuestionType;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 *
 * @author Mahavir Singh
 */
public class SectionCriteria implements Serializable {
    private QuestionType type;
    private int noOfQuestions;
    private BigDecimal marksPerQuestion;

    public SectionCriteria() { }
    
    public SectionCriteria(QuestionType type, int noOfQuestions, 
            BigDecimal marksPerQuestion) {
        this.type = type;
        this.noOfQuestions = noOfQuestions;
        this.marksPerQuestion = marksPerQuestion;
    }
    
    public QuestionType getType() {
        return type;
    }

    public void setType(QuestionType type) {
        this.type = type;
    }

    public int getNoOfQuestions() {
        return noOfQuestions;
    }

    public void setNoOfQuestions(int noOfQuestions) {
        this.noOfQuestions = noOfQuestions;
    }

    public BigDecimal getMarksPerQuestion() {
        return marksPerQuestion;
    }

    public void setMarksPerQuestion(BigDecimal marksPerQuestion) {
        this.marksPerQuestion = marksPerQuestion;
    }
    
}
