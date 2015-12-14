package com.ws.mq;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketMsgConfig extends  AbstractWebSocketMessageBrokerConfigurer {

	public void registerStompEndpoints(StompEndpointRegistry registry) {
		// TODO Auto-generated method stub
		registry.addEndpoint("/add").withSockJS();

	}
	
	@Override
	public void configureMessageBroker(MessageBrokerRegistry config) 
{
		config.enableSimpleBroker("/topic");
		
config.setApplicationDestinationPrefixes("/calcApp");
	}



	
	}

