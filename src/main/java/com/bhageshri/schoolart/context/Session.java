/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bhageshri.schoolart.context;

import com.bhageshri.schoolart.domain.Permission;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * class for representing session object.
 * 
 * @author Mahavir Singh
 */
public class Session implements Serializable {
    private Long userId;
    private String username;
    private List<Permission> permission = new ArrayList<>();
    
    public Session() { }
    
    public Session(Long userId, String username) {
        this.userId = userId;
        this.username = username;
    }
    
    public Long getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public List<Permission> getPermission() {
        return permission;
    }

    public void setPermission(List<Permission> permission) {
        this.permission = permission;
    }
    
}
