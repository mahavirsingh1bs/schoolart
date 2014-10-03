package com.bhageshri.schoolart.domain;

import com.bhageshri.schoolart.util.QuestionType;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name = "EXERCISE")
public class Exercise implements Serializable {

    @Id
    @TableGenerator(name = "exerciseIdGenerator", table = "ID_GENERATOR", pkColumnName = "PK_NAME", pkColumnValue = "EXERCISE_ID", valueColumnName = "PK_VALUE")
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "exerciseIdGenerator")
    @Column(name = "ID")
    private Long id;
    @Column(name = "NAME")
    private String name;
    @OneToMany(fetch = FetchType.EAGER)
    private Set<Question> questions = new HashSet();

    public Exercise() {
    }

    public Exercise(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addQuestion(Question question) {
        question.setExercise(this);
        this.questions.add(question);
    }
    
    public Set<Question> getQuestions() {
        return questions;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + Objects.hashCode(this.id);
        hash = 31 * hash + Objects.hashCode(this.name);
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
        final Exercise other = (Exercise) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Exercise{" + "id=" + id + ", name=" + name + '}';
    }
}
