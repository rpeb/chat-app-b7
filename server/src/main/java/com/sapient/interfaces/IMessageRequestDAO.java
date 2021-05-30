package com.sapient.interfaces;

import java.util.List;

import com.sapient.entity.MessageRequest;

public interface IMessageRequestDAO {
	//save
	public boolean saveMessage(MessageRequest messageRequest );
	
	//getMessage
	public MessageRequest getMessage(String senderId, String receiverId);
	
	//get all messages
	public List<MessageRequest> getAllMessages();
	
	//update a request
	public boolean updateRequest(int request_id, int is_accepted);
}
