package com.sapient.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.sapient.dao.GroupMessagesDao;
import com.sapient.entity.MessagePod4;

//GET /api/messages/group/U1/1 
//POST /api/messages/group/U1/1
//POST /api/messages/group/U1/1/7

@RestController
@RequestMapping("/api/messages/group")
public class GroupMessageController {
	GroupMessagesDao groupMessages = new GroupMessagesDao();
	
	@GetMapping("/{senderId}/{receiverId}")
	public List<MessagePod4> getMessages(@PathVariable String senderId, @PathVariable int receiverId) {
		return groupMessages.getMessages(senderId, receiverId);
	}
	
	@PostMapping("/{senderId}/{receiverId}")
	public boolean saveMessage(@PathVariable String senderId, @PathVariable int receiverId, @RequestBody String messageBody) {
		MessagePod4 message = new MessagePod4();
		message.setSenderId(senderId);
		message.setGroupReceiverId(receiverId);
		message.setMessageBody(messageBody);
		return groupMessages.saveNewMessage(message);
	}
	
	@PostMapping("/{senderId}/{receiverId}/{messageId}")
	public boolean replyToAMessage(@PathVariable int messageId, @PathVariable String senderId, @PathVariable int receiverId, @RequestBody String messageBody) {
		MessagePod4 message = new MessagePod4();
		message.setSenderId(senderId);
		message.setGroupReceiverId(receiverId);
		message.setMessageBody(messageBody);
		message.setReplyToAMessage(messageId);
		return groupMessages.saveNewMessage(message);
	}
}
