package com.websocket.listenner;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class WsListenner implements ServletContextListener{

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		Object x = event.getServletContext().getAttribute("javax.websocket.server.ServerContainer");
		System.out.println(x);
		
	}

}
