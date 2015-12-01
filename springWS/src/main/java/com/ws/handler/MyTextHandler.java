package com.ws.handler;

import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;


public class MyTextHandler extends TextWebSocketHandler{
        
	    @Override
	    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
	    	// TODO Auto-generated method stub
	    	System.out.println("handleTextMessage invoke ...........");
	    }
}
