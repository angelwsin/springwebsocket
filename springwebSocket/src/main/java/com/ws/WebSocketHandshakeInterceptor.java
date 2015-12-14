package com.ws;

import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;

public class WebSocketHandshakeInterceptor extends HttpSessionHandshakeInterceptor /*implements HandshakeInterceptor*/{
	private static final Logger LOGGER = LogManager.getLogger(WebSocketHandshakeInterceptor.class);
	      @Override
	    public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler,
	    		Map<String, Object> attributes) throws Exception {
	    	// TODO Auto-generated method stub
	    	  LOGGER.debug("beforeHandshake ");
	    	  System.out.println("beforeHandshake");
	 		/* if (request instanceof ServletServerHttpRequest) {
	 	            ServletServerHttpRequest servletRequest = (ServletServerHttpRequest) request;
	 	            HttpSession session = servletRequest.getServletRequest().getSession(false);
	 	            if (session != null) {
	 	                //使用userName区分WebSocketHandler，以便定向发送消息
	 	                String userName = (String) session.getAttribute(Constants.SESSION_USERNAME);
	 	                LOGGER.debug("attributes ");
	 	                attributes.put(Constants.WEBSOCKET_USERNAME,userName);
	 	            }
	 	        }*/
	    	return super.beforeHandshake(request, response, wsHandler, attributes);
	    }
       @Override
    public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler,
    		Exception ex) {
    	// TODO Auto-generated method stub
    	super.afterHandshake(request, response, wsHandler, ex);
    }
}
