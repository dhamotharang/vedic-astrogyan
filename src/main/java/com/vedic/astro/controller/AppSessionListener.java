package com.vedic.astro.controller;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * This listener class would listen to the session activate and passivate
 * events. It would be useful for keeping track of the active sessions.
 * 
 * @author Saxena_s
 * 
 */
public class AppSessionListener implements HttpSessionListener, Serializable {

	public static final Map<String, HttpSession> ACTIVE_SESSIONS = new HashMap<String, HttpSession>();

	public void sessionCreated(HttpSessionEvent event) {

		HttpSession session = event.getSession();
		ACTIVE_SESSIONS.put(session.getId(), session);

	}

	public void sessionDestroyed(HttpSessionEvent event) {
		HttpSession session = event.getSession();
		ACTIVE_SESSIONS.remove(session.getId());
	}

}
