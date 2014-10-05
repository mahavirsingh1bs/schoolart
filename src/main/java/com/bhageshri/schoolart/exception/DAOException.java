/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bhageshri.schoolart.exception;

/**
 *
 * @author mahavir.singh
 */
public class DAOException extends Exception {

    public DAOException() {
    }

    public DAOException(String msg) {
        super(msg);
    }

    public DAOException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public DAOException(Throwable cause) {
        super(cause);
    }
}
