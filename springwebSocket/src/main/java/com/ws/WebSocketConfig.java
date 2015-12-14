package com.ws;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.server.standard.ServletServerContainerFactoryBean;

/*
 * Websocet服务端实现
 */
@Configuration
@EnableWebMvc
@EnableWebSocket
public class WebSocketConfig extends WebMvcConfigurerAdapter implements WebSocketConfigurer{

	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		// TODO Auto-generated method stub
		//用来注册websocket server实现类，第二个参数是访问websocket的地址 
		System.out.println("registerWebSocketHandlers");
		registry.addHandler(systemWebSocketHandler() , "/webSocketServer").addInterceptors(new   WebSocketHandshakeInterceptor());
		//这个是使用Sockjs的注册方法 
		registry.addHandler(systemWebSocketHandler(), "/sockjs/webSocketServer").addInterceptors(new   WebSocketHandshakeInterceptor()).withSockJS();
		 registry.addHandler(myHandler(), "/myHandler");
	}
	
	@Bean
    public WebSocketHandler systemWebSocketHandler(){
        return new SystemWebSocketHandler();
    }
	@Bean
	public WebSocketHandler myHandler() {
        return new MyHandler();
    }
	@Bean
	 public ServletServerContainerFactoryBean createWebSocketContainer() {
	        ServletServerContainerFactoryBean container = new ServletServerContainerFactoryBean();
	        container.setMaxTextMessageBufferSize(8192);
	        container.setMaxBinaryMessageBufferSize(8192);
	        return container;
	    }



}
