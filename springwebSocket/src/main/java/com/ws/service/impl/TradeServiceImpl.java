package com.ws.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;

import com.ws.service.TradeService;

public class TradeServiceImpl  implements TradeService{
	@Autowired
	 private SimpMessagingTemplate messagingTemplate;

}
