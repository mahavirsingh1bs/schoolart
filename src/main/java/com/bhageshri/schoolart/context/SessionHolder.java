/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bhageshri.schoolart.context;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * A singleton class for holding all active sessions.
 * 
 * @author Mahavir Singh
 */
public class SessionHolder {
    private static final SessionHolder INSTANCE = new SessionHolder();
    
    private Map<Long, Session> sessions = new ConcurrentHashMap<>();
    
    public static SessionHolder getInstance() {
        return INSTANCE;
    }
    
    public void newSession(Long userId, Session session) {
        sessions.put(userId, session);
    }
    
    public Session getSession(Long userId) {
        return sessions.get(userId);
    }
    
    public void removeSession(Long userId) {
        sessions.remove(userId);
    }
}
