/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bhageshri.schoolart.service;

import com.bhageshri.schoolart.context.SessionHolder;
import com.bhageshri.schoolart.dao.SchoolDAO;
import com.bhageshri.schoolart.dao.UserDAO;
import com.bhageshri.schoolart.domain.School;
import com.bhageshri.schoolart.domain.User;
import com.bhageshri.schoolart.exception.DAOException;
import com.bhageshri.schoolart.service.impl.UserServiceImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


/**
 *
 * @author Mahavir Singh
 */
public class UserServiceTest {
    
    private UserDAO userDAO;
    private SchoolDAO schoolDAO;
    private UserServiceImpl userService;
    
    public UserServiceTest() {
    }
    
    @Before
    public void setUp() {
        userDAO = mock(UserDAO.class);
        schoolDAO = mock(SchoolDAO.class);
        userService = new UserServiceImpl();
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void testUserLogin() throws DAOException {
        School school = new School("New Green Lawns", "UGC");
        String username = "ST61"; Long schoolId = 1l;
        char[] password = {'s', 'c', 'h', 'o', 'o', 'l', '@', '1', '2', '3'}; 
        User user = new User(username, password, school);
        user.setId(1l);
        when(schoolDAO.find(1l)).thenReturn(school);
        when(userDAO.findUser(username, password, schoolId)).thenReturn(user);
        userService.setSchoolDAO(schoolDAO);
        userService.setUserDAO(userDAO);
        userService.login(username, password, schoolId);
        assert user.isLoggedIn() == true;
        verify(userDAO).findUser(username, password, schoolId);
    }
    
    @Test
    public void testLogout() {
        Long userId = 1l;
        assertNotNull(SessionHolder.getInstance().getSession(userId));
        userService.logout(userId);
        assertNull(SessionHolder.getInstance().getSession(userId));
    }
}