/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bhageshri.schoolart.exception;

/**
 *
 * @author mahavir.singh
 */
public class ServiceException extends RuntimeException {
    
    public ServiceException() { }
    
    public ServiceException(String msg) {
        super(msg);
    }
    
    public ServiceException(String msg, Throwable cause) {
        super(msg, cause);
    }
    
    public ServiceException(Throwable cause) {
        super(cause);
    }
}
