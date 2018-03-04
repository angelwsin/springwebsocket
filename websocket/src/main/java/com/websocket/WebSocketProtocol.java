package com.websocket;

public class WebSocketProtocol {
	
	

/*websocket 协议 基于http 协议


请求头中加入
Upgrade: websocket
Connection: Upgrade


然后服务器会返回下列东西，表示已经接受到请求， 成功建立Websocket啦！
HTTP/1.1 101 Switching Protocols
Upgrade: websocket
Connection: Upgrade
Sec-WebSocket-Accept: HSmrc0sMlYUkAGmm5OPpG2HaGWk=
Sec-WebSocket-Protocol: chat

这里开始就是HTTP最后负责的区域了，告诉客户，我已经成功切换协议啦~

Upgrade: websocket
Connection: Upgrade
依然是固定的，告诉客户端即将升级的是Websocket协议，而不是mozillasocket，lurnarsocket或者shitsocket。
然后，Sec-WebSocket-Accept 这个则是经过服务器确认，并且加密过后的 Sec-WebSocket-Key。服务器：好啦好啦，知道啦，给你看我的ID CARD来证明行了吧。。
后面的，Sec-WebSocket-Protocol 则是表示最终使用的协议。至此，HTTP已经完成它所有工作了，接下来就是完全按照Websocket协议进行了*/
	
	
	/**
	 * javaServlet 3.0 
	 * 
	 * 添加注解
	 * HandlesTypes 
	 * 
	 * 
	 * apache 
	 * 利用  HandlesTypes 启动websocket容器 org.apache.tomcat.websocket.server.WsSci
	 */

}
