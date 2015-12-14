package com.ws;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.handler.TextWebSocketHandler;

/*
 * Creating a WebSocket server is as simple as implementing
 *  WebSocketHandler or more likely extending either 
 * TextWebSocketHandler or BinaryWebSocketHandler:
 */

@Configuration
@EnableWebSocket
public class MyHandler  extends TextWebSocketHandler {

	
	  @Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		// TODO Auto-generated method stub
		    System.out.println(message.getPayload());
	}
}
