/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bhageshri.schoolart.database;

import java.io.FileInputStream;
import org.dbunit.DBTestCase;
import org.dbunit.PropertiesBasedJdbcDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;

/**
 *
 * @author mahavir.singh
 */
public class DatabaseInit extends DBTestCase {

    public DatabaseInit() {
        super("Database Setup Test");

        System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_DRIVER_CLASS, "com.mysql.jdbc.Driver");
        System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_CONNECTION_URL, "jdbc:mysql://localhost:3306/schoolart");
        System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_USERNAME, "root");
        System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_PASSWORD, "root");
        
        /**
        System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_DRIVER_CLASS, "com.mysql.jdbc.Driver");
        System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_CONNECTION_URL, "jdbc:mysql://ec2-50-19-213-178.compute-1.amazonaws.com:3306/surveymobile");
        System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_USERNAME, "surveymobile");
        System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_PASSWORD, "b025327e4fd04b0492ddf30f950368ee");
        */
    }

    @Override
    protected IDataSet getDataSet() throws Exception {
        return new FlatXmlDataSet(new FileInputStream("src/main/resources/com/bhageshri/schoolart/data/schoolart_data.xml"));
    }

    public void testMe() {
        System.out.println("Text Me");
    }
}
