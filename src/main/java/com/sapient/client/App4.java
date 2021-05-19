package com.sapient.client;

import java.util.ArrayList;
import java.util.List;

import com.sapient.dao.*;
import com.sapient.entity.MessagePod4;

public class App4 {
	public static void main(String[] args) {
//		UserMessagesDao userMessageObject = new UserMessagesDao();
//		List<Message> res = userMessageObject.getMessages("U1", "U2");
		GroupMessagesDao groupMessageObject = new GroupMessagesDao();
		List<MessagePod4> res = groupMessageObject.getMessages("U1", 1);
		System.out.println(res);
//		Message message = new Message();
//		message.setSenderId("U3");
//		message.setGroupReceiverId(1);
//		message.setMessageBody("Reply to a message");
//		message.setReplyToAMessage(7);
//		System.out.println(groupMessageObject.saveNewMessage(message));
//		System.out.println(userMessageObject.deleteSenderMessage(22));
		
	}
}
