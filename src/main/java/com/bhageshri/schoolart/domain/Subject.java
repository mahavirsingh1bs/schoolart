/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bhageshri.schoolart.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

/**
 *
 * @author mahavir.singh
 */
@Entity
@Table(name = "SUBJECT")
public class Subject implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @TableGenerator(name = "subjectIdGenerator", table = "ID_GENERATOR", pkColumnName = "PK_NAME", pkColumnValue = "SUBJECT_ID", valueColumnName = "PK_VALUE")
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "subjectIdGenerator")
    private Long id;
    
    @Column(name = "NAME")
    private String name;
    
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_SUBJECT_ID")
    private Set<Exercise> exercises = new HashSet<>();
    
    @ManyToOne
    @JoinColumn(name = "FK_STU_CLASS_ID")
    private StuClass stuClass;

    @ManyToOne
    @JoinColumn(name = "SCHOOL_ID")
    private School school;
    
    public Subject() { }
    
    public Subject(String name, School school) {
        this.name = name;
        this.school = school;
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

    public Set<Exercise> getExercises() {
        return exercises;
    }

    public void addExercise(Exercise exercise) {
        this.exercises.add(exercise);
    }

    public StuClass getStuClass() {
        return stuClass;
    }

    public void setStuClass(StuClass stuClass) {
        this.stuClass = stuClass;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.id);
        hash = 89 * hash + Objects.hashCode(this.name);
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
        final Subject other = (Subject) obj;
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
        return "Subject{" + "id=" + id + ", name=" + name + '}';
    }
}
