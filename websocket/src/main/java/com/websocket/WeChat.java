package com.websocket;

import javax.websocket.EndpointConfig;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

/*
 * javax.websocket.Endpoint (can be published via the WebSocket server)
 * javax.websocket.server.ServerApplicationConfig
 * 实现Endpoint两种方式
 * 1.继承Endpoint 
 * 2.使用注解
 *   对应方法注解:javax.websocket.OnOpen
 *            javax.websocket.OnMessage
 *            javax.websocket.OnError
 *            javax.websocket.OnClose
 */
@ServerEndpoint(value="/ws/chat")
public class WeChat {
	
	
	public WeChat(){
		System.out.println("init");
	}

	
	@OnOpen
	public  void onOpen(Session session, EndpointConfig config){
		System.out.println("connect");
		
		/*try {
			session.getContainer().connectToServer(WeChatClient.class, new URI("ws://localhost:8080/websocket/ws/chat"));
		} catch (DeploymentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}
	
	@OnMessage
	public void OnMessage(String message){
		System.out.println(message);
		
	}
	
}

/*at org.apache.tomcat.websocket.pojo.PojoEndpointBase.doOnOpen(PojoEndpointBase.java:58)
at org.apache.tomcat.websocket.pojo.PojoEndpointServer.onOpen(PojoEndpointServer.java:64)
at org.apache.tomcat.websocket.server.WsHttpUpgradeHandler.init(WsHttpUpgradeHandler.java:133)
at org.apache.coyote.AbstractProtocol$ConnectionHandler.process(AbstractProtocol.java:907)
at org.apache.tomcat.util.net.NioEndpoint$SocketProcessor.doRun(NioEndpoint.java:1455)
at org.apache.tomcat.util.net.SocketProcessorBase.run(SocketProcessorBase.java:49)*/
