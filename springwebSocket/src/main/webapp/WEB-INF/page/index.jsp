<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html>
<head>
	<title>Java API for WebSocket (JSR-356)</title>  
</head>
<body>
<script type="text/javascript" src="http://localhost/springwebSocket/js/jquery-2.1.4.js"></script>
<script type="text/javascript" src="http://cdn.bootcss.com/sockjs-client/1.0.3/sockjs.min.js"></script>
<script type="text/javascript">
	var websocket = null;
	if ('WebSocket' in window) {
		websocket = new WebSocket("ws://localhost/springwebSocket/webSocketServer");
	} 
	else if ('MozWebSocket' in window) {
		websocket = new MozWebSocket("ws://localhost/springwebSocket/webSocketServer");
	} 
	else {
		websocket = new SockJS("http://localhost/springwebSocket/sockjs/webSocketServer");
	}
	websocket.onopen = onOpen;
	websocket.onmessage = onMessage;
	websocket.onerror = onError;
	websocket.onclose = onClose;
	      	
	function onOpen(openEvt) {
		//alert(openEvt.Data);
	}
	
	function onMessage(evt) {
		alert(evt.data);
	}
	function onError() {}
	function onClose() {}
	
	function doSend() {
		if (websocket.readyState == websocket.OPEN) {  		
            var msg = document.getElementById("inputMsg").value;  
            websocket.send(msg);//调用后台handleTextMessage方法
            alert("发送成功!");  
        } else {  
        	alert("连接失败!");  
        }  
	}
</script>
请输入：<textarea rows="5" cols="10" id="inputMsg" name="inputMsg"></textarea>
<button onclick="doSend();">发送</button>
</body>
</html>
