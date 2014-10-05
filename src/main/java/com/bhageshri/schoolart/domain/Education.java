/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bhageshri.schoolart.domain;

import com.bhageshri.schoolart.util.EducationType;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

/**
 *
 * @author Mahavir Singh
 */
@Entity
@Table(name = "EDUCATION")
public class Education implements Serializable {
    
    @Id
    @TableGenerator(name = "educationIdGenerator", table = "ID_GENERATOR", pkColumnName = "PK_NAME", pkColumnValue = "EDUCATION_ID", valueColumnName = "PK_VALUE")
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "educationIdGenerator")
    private Long id;
    
    @Column(name = "NAME")
    private String name;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "TYPE")
    private EducationType type;
    
    @Column(name = "COLLEGE")
    private String college;
    
    @Column(name = "EDU_YEAR")
    private String year;
    
    @Column(name = "PERCENT")
    private String percent;
    
    @ManyToOne
    @JoinColumn(name = "SCHOOL_ID")
    private School school;

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

    public EducationType getType() {
        return type;
    }

    public void setType(EducationType type) {
        this.type = type;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getPercent() {
        return percent;
    }

    public void setPercent(String percent) {
        this.percent = percent;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    @Override
    public String toString() {
        return "Education{" + "id=" + id + ", name=" + name + ", type=" + type + ", college=" + college + ", year=" + year + ", percent=" + percent + '}';
    }
    
}
