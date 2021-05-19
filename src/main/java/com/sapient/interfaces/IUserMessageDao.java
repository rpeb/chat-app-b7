package com.sapient.interfaces;

import java.util.List;

import com.sapient.entity.MessagePod4;

public interface IUserMessageDao {
	public List<MessagePod4> getMessages(String userId, String userReceiver);
	public boolean saveNewMessage(MessagePod4 message);
	public boolean deleteSenderMessage(int messageId);
	public boolean deleteReceiverMessage(int messageId);
	public MessagePod4 getMessageById(int messageId);
}
