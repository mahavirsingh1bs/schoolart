/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bhageshri.schoolart.domain;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

/**
 *
 * @author Mahavir Singh
 */
@Entity
@Table(name = "SCHOOL")
public class School implements Serializable {
    
    @Id
    @TableGenerator(name = "schoolIdGenerator", table = "ID_GENERATOR", pkColumnName = "PK_NAME", pkColumnValue = "SCHOOL_ID", valueColumnName = "PK_VALUE")
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "schoolIdGenerator")
    private Long id;
    
    @Column(name = "NAME")
    private String name;
    
    @Embedded
    private Address address;
    
    @Column(name = "AFFILIATION")
    private String affiliation;

    public School() { }
    
    public School(String name, String affiliation) {
        this.name = name;
        this.affiliation = affiliation;
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getAffiliation() {
        return affiliation;
    }

    public void setAffiliation(String affiliation) {
        this.affiliation = affiliation;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.name);
        hash = 97 * hash + Objects.hashCode(this.address);
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
        final School other = (School) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.address, other.address)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "School{" + "id=" + id + ", name=" + name + ", address=" + address + ", affiliation=" + affiliation + '}';
    }
    
    
}
