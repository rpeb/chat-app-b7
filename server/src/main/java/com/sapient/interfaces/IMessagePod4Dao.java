package com.sapient.interfaces;

import java.util.List;

import com.sapient.entity.MessagePod4;

public interface IMessagePod4Dao {
	public List<MessagePod4> getMessagesOfAConversation(String senderId, String userReceiverId, int groupReceiverId);
	public boolean saveNewMessage(MessagePod4 message);
}
