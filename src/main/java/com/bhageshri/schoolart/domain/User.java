/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bhageshri.schoolart.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Transient;

/**
 *
 * @author Mahavir Singh
 */
@Entity
@Table(name = "USER_DETAIL")
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @TableGenerator(
            name = "userIdGenerator", 
            table = "ID_GENERATOR", 
            pkColumnName = "PK_NAME", 
            pkColumnValue = "USER_ID", 
            valueColumnName = "PK_VALUE")
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "userIdGenerator")
    private Long id;

    @Column(name = "USERNAME")
    private String username;
    
    @Column(name = "PASSWORD")
    private char[] password;
    
    @ManyToMany
    @JoinTable(name = "USER_ROLE", 
            joinColumns = @JoinColumn(name = "FK_USER_ID"), 
            inverseJoinColumns = @JoinColumn(name = "FK_ROLE_ID"))
    private Set<Role> roles = new HashSet<>();
    
    @ManyToOne
    @JoinColumn(name = "SCHOOL_ID")
    private School school;
    
    @Transient
    private boolean loggedIn;
    
    public User() { }
    
    public User(String username, char[] password, School school) {
        this.username = username;
        this.password = password;
        this.school = school;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public char[] getPassword() {
        return password;
    }

    public void setPassword(char[] password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bhageshri.schoolart.domain.User[ id=" + id + " ]";
    }
    
}
