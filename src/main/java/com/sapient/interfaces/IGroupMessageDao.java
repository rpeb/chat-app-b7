package com.sapient.interfaces;

import java.util.List;

import com.sapient.entity.MessagePod4;

public interface IGroupMessageDao {
	public List<MessagePod4> getMessages(String userId, int groupReceiver);
	public boolean saveNewMessage(MessagePod4 message);
}
