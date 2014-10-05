/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bhageshri.schoolart.dao.impl;

import com.bhageshri.schoolart.dao.UserDAO;
import com.bhageshri.schoolart.domain.User;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Mahavir Singh
 */
@Repository
public class UserDAOImpl extends GenericDAOImpl<Long, User> implements UserDAO {

    @Override
    public User findUser(String username, char[] password, Long schoolId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
