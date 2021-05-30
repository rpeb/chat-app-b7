package com.sapient.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.sapient.dao.UserMessagesDao;
import com.sapient.entity.MessagePod4;

//GET /api/messages/U1/U2
//POST /api/messages/U1/U2
//POST /api/messages/U3/U4/
//PATCH /api/messages/83/U4

@RestController
@RequestMapping("/api/messages")
public class UserMessageController {
	
	private UserMessagesDao userMessages = new UserMessagesDao();
	
	@CrossOrigin(origins = "*")
	@GetMapping("/{userId}")
	public List<MessagePod4> getMessagesForAUser(@PathVariable String userId) {
		return userMessages.getMessagesForASender(userId);
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping("/{senderId}/{receiverId}")
	public List<MessagePod4> getMessages(@PathVariable String senderId, @PathVariable String receiverId) {
		return userMessages.getMessages(senderId, receiverId);
	}
	
	@CrossOrigin(origins = "*")
	@PostMapping("/{senderId}/{receiverId}")
	public boolean saveMessage(@PathVariable String senderId, @PathVariable String receiverId, @RequestBody String messageBody) {
		MessagePod4 message = new MessagePod4();
		message.setSenderId(senderId);
		message.setUserReceiverId(receiverId);
		message.setMessageBody(messageBody);
		return userMessages.saveNewMessage(message);
	}
	
	@CrossOrigin(origins = "*")
	@PostMapping("/{senderId}/{receiverId}/{messageId}")
	public boolean replyToAMessage(@PathVariable int messageId, @PathVariable String senderId, @PathVariable String receiverId, @RequestBody String messageBody) {
		MessagePod4 message = new MessagePod4();
		message.setSenderId(senderId);
		message.setUserReceiverId(receiverId);
		message.setMessageBody(messageBody);
		message.setReplyToAMessage(messageId);
		return userMessages.saveNewMessage(message);
	}
	
	@CrossOrigin(origins = "*")
	@PatchMapping("/{messageId}/{userId}")
	public boolean updateMessageDeletion(@PathVariable int messageId, @PathVariable String userId) {
		MessagePod4 message = userMessages.getMessageById(messageId);
		boolean sender = (message.getSenderId().equals(userId));
		if (sender) {
			return userMessages.deleteSenderMessage(messageId);
		} else {
			return userMessages.deleteReceiverMessage(messageId);
		}
	}
}
