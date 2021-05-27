package com.sapient.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.dao.MessageRequestDAO;
import com.sapient.entity.MessageRequest;
import com.sapient.interfaces.IMessageRequestDAO;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class MessageRequestController {

	private IMessageRequestDAO dao = new MessageRequestDAO();
	
	@GetMapping("/message-request")
	public List<MessageRequest> getAllMessage() {
		return dao.getAllMessages();
	}

//	@GetMapping("/message-request/{requestId}")
//	public MessageRequest getMessage(@PathVariable int requestId) {
//		return dao.getMessage(requestId);
//	}
	
	@GetMapping("/message-request/{senderId}/{receiverId}")
	public MessageRequest getMessage(@PathVariable String senderId, @PathVariable String receiverId) {
		return dao.getMessage(senderId, receiverId);
	}

	@GetMapping("/message-request/{receiverId}")
	public List<MessageRequest> getMessage( @PathVariable String receiverId) {
		return dao.getMessage(receiverId);
	}
	
	@PostMapping("/message-request")
	public String insertMessage(@RequestBody MessageRequest messageRequest) {
		return dao.saveMessage(messageRequest) ? "Inserted" : "Not Inserted";
	}

	@PutMapping("/message-request/{requestId}")
	public String changeRequest(@PathVariable int requestId, @RequestBody MessageRequest messageRequest) {
		return dao.updateRequest(requestId, messageRequest.getIsAccepted()) ? "updated" : "not updated";
	}

}