/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bhageshri.schoolart;

import com.bhageshri.schoolart.dao.StuClassDAO;
import com.bhageshri.schoolart.exception.DAOException;
import com.bhageshri.schoolart.util.BeanResolverUtil;

/**
 *
 * @author Mahavir Singh
 */
public class SchoolartClasses {
    public static void main(String...args) throws DAOException {
        StuClassDAO classDAO = (StuClassDAO)BeanResolverUtil.getBean("stuClassDAO");
        System.out.println(classDAO.findAll());
    }
}
