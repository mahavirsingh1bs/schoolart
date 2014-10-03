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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

/**
 *
 * @author mahavir.singh
 */
@Entity
@Table(name = "STU_CLASS")
public class StuClass implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @TableGenerator(name = "classIdGenerator", table = "ID_GENERATOR", pkColumnName = "PK_NAME", pkColumnValue = "CLASS_ID", valueColumnName = "PK_VALUE")
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "classIdGenerator")
    private Long id;

    @Column(name = "NAME")
    private String name;
    
    @OneToMany(fetch = FetchType.LAZY)
    private Set<Subject> subjects = new HashSet<>();
    
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

    public Set<Subject> getSubjects() {
        return subjects;
    }

    public void addSubject(Subject subject) {
        this.subjects.add(subject);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + Objects.hashCode(this.id);
        hash = 23 * hash + Objects.hashCode(this.name);
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
        final StuClass other = (StuClass) obj;
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
        return "StuClass{" + "id=" + id + ", name=" + name + '}';
    }

}
