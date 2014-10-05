/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bhageshri.schoolart.dao;

import com.bhageshri.schoolart.domain.User;

/**
 *
 * @author Mahavir Singh
 */
public interface UserDAO extends GenericDAO<Long, User> {
    User findUser(String username, char[] password, Long schoolId);
}
