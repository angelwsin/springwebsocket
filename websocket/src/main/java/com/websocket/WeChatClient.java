package com.websocket;

import javax.websocket.ClientEndpoint;
import javax.websocket.EndpointConfig;
import javax.websocket.OnOpen;
import javax.websocket.Session;

@ClientEndpoint
public class WeChatClient {
	
	
	@OnOpen
	public  void onOpen(Session session, EndpointConfig config){
		System.out.println("client connect");
	}

}
