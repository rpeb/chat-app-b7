package com.sapient.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.sapient.dao.MessageRequestDAO;
import com.sapient.entity.MessageRequest;
import com.sapient.interfaces.IMessageRequestDAO;

@RestController
@RequestMapping("/api")
public class MessageRequestController {

	private IMessageRequestDAO dao = new MessageRequestDAO();
	@CrossOrigin(origins = "*")
	@GetMapping("/message-request")
	public List<MessageRequest> getAllMessage() {
		return dao.getAllMessages();
	}
	@CrossOrigin(origins = "*")
	@GetMapping("/message-request/{requestId}")
	public MessageRequest getMessage(@PathVariable int requestId) {
		return dao.getMessage(requestId);
	}
	@CrossOrigin(origins = "*")
	@PostMapping("/message-request")
	public String insertMessage(@RequestBody MessageRequest messageRequest) {
		return dao.saveMessage(messageRequest) ? "Inserted" : "Not Inserted";
	}
	@CrossOrigin(origins = "*")
	@PutMapping("/message-request/{requestId}")
	public String changeRequest(@PathVariable int requestId, @RequestBody MessageRequest messageRequest) {
		return dao.updateRequest(requestId, messageRequest.getIsAccepted()) ? "updated" : "not updated";
	}

}