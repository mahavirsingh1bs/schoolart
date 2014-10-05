/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bhageshri.schoolart.service.impl;

import com.bhageshri.schoolart.context.Session;
import com.bhageshri.schoolart.context.SessionHolder;
import com.bhageshri.schoolart.dao.SchoolDAO;
import com.bhageshri.schoolart.dao.UserDAO;
import com.bhageshri.schoolart.domain.User;
import com.bhageshri.schoolart.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Mahavir Singh
 */
@Service
public class UserServiceImpl implements UserService {
    
    @Autowired
    private SchoolDAO schoolDAO;
    
    @Autowired
    private UserDAO userDAO;

    @Override
    public boolean login(String username, char[] password, Long schoolId) {
        User user = userDAO.findUser(username, password, schoolId);
        if (user != null) {
            Session session = new Session(user.getId(), user.getUsername());
            SessionHolder.getInstance().newSession(user.getId(), session);
            user.setLoggedIn(true);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void logout(Long userId) {
        SessionHolder.getInstance().removeSession(userId);
    }

    public void setSchoolDAO(SchoolDAO schoolDAO) {
        this.schoolDAO = schoolDAO;
    }

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }
    
}
