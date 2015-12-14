package com.ws;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;

public class SystemWebSocketHandler implements WebSocketHandler{
	private static final Logger LOGGER = LogManager.getLogger(SystemWebSocketHandler.class);
	 private static final ArrayList<WebSocketSession> users;
	 
	 static {
	        users = new ArrayList<WebSocketSession>();
	    }
	/* @Autowired
	    private WebSocketSession webSocketService;*/
	 /**
		 * 连接成功时候，会触发UI上onopen方法
		 */
	public void afterConnectionClosed(WebSocketSession session, CloseStatus arg1) throws Exception {
		// TODO Auto-generated method stub
		LOGGER.debug("websocket connection closed......");
	        users.remove(session);
	}

	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		// TODO Auto-generated method stub
		LOGGER.debug("connect to the websocket success......");
	        users.add(session);
	      //这块会实现自己业务，比如，当用户登录后，会把离线消息推送给用户
	        //TextMessage returnMessage = new TextMessage("你将收到的离线");
		//session.sendMessage(returnMessage);
	}

	/**
	 * 在UI在用js调用websocket.send()时候，会调用该方法
	 */
	public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
		// TODO Auto-generated method stub
		 // System.out.println(message.getPayload());
		System.out.println("发送:"+message.getPayload());
	}

	public void handleTransportError(WebSocketSession session, Throwable arg1) throws Exception {
		// TODO Auto-generated method stub
		 if(session.isOpen()){
	            session.close();
	        }
		 LOGGER.debug("websocket connection closed......");
	        users.remove(session);
	}

	public boolean supportsPartialMessages() {
		// TODO Auto-generated method stub
		return false;
	}
	
	/**
     * 给所有在线用户发送消息
     *
     * @param message
     */
    public void sendMessageToUsers(TextMessage message) {
        for (WebSocketSession user : users) {
            try {
                if (user.isOpen()) {
                    user.sendMessage(message);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
 
    /**
     * 给某个用户发送消息
     *
     * @param userName
     * @param message
     */
    public void sendMessageToUser(String userName, TextMessage message) {
        for (WebSocketSession user : users) {
            if (user.getAttributes().get(Constants.WEBSOCKET_USERNAME).equals(userName)) {
                try {
                    if (user.isOpen()) {
                        user.sendMessage(message);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            }
        }
    }

}
