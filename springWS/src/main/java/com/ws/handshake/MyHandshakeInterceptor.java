package com.ws.handshake;

import java.util.Map;

import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;
/*
 * 握手
 */
public class MyHandshakeInterceptor extends HttpSessionHandshakeInterceptor{

	   @Override
	public boolean beforeHandshake(ServerHttpRequest arg0, ServerHttpResponse arg1, WebSocketHandler arg2,
			Map<String, Object> arg3) throws Exception {
		// TODO Auto-generated method stub
		   System.out.println("beforeHandshake ..");
		return super.beforeHandshake(arg0, arg1, arg2, arg3);
	}
	   
	   @Override
	public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler,
			Exception ex) {
		// TODO Auto-generated method stub
		   System.out.println("beforeHandshake ..");
		super.afterHandshake(request, response, wsHandler, ex);
	}
}
