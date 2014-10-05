package com.bhageshri.schoolart.domain;

import com.bhageshri.schoolart.util.QuestionType;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name = "QUESTION")
public class Question implements Serializable {

    @Id
    @TableGenerator(name = "questionIdGenerator", table = "ID_GENERATOR", pkColumnName = "PK_NAME", pkColumnValue = "QUESTION_ID", valueColumnName = "PK_VALUE")
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "questionIdGenerator")
    @Column(name = "ID")
    private Long id;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "QUESTION_TYPE")
    private QuestionType questionType;
    
    @Column(name = "QUESTION")
    private String question;
    
    @Column(name = "OPTIONS")
    private String options;
    
    @Column(name = "ANSWER")
    private String answer;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_EXERCISE_ID")
    private Exercise exercise;
    
    @ManyToOne
    @JoinColumn(name = "SCHOOL_ID")
    private School school;

    public Question() {
    }

    public Question(QuestionType questionType, String question, String answer, School school) {
        this.questionType = questionType;
        this.question = question;
        this.answer = answer;
        this.school = school;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public QuestionType getQuestionType() {
        return questionType;
    }

    public void setQuestionType(QuestionType questionType) {
        this.questionType = questionType;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Exercise getExercise() {
        return exercise;
    }

    public void setExercise(Exercise exercise) {
        this.exercise = exercise;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.id);
        hash = 71 * hash + Objects.hashCode(this.questionType);
        hash = 71 * hash + Objects.hashCode(this.question);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Question other = (Question) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.questionType, other.questionType)) {
            return false;
        }
        if (!Objects.equals(this.question, other.question)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Question{" + "id=" + id + ", questionType=" + questionType + ", question=" + question + ", answer=" + answer + ", exercise=" + exercise + '}';
    }
}
