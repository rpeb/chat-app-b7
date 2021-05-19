package com.sapient.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

import org.junit.jupiter.api.*;

import com.sapient.entity.MessagePod4;

public class UserMessagesDaoTest {
	private MessagePod4 message = new MessagePod4();
	UserMessagesDao userMessages = new UserMessagesDao();
	GroupMessagesDao groupMessage = new GroupMessagesDao();
	
	// TODO : Write display names on tests
	@Disabled
	@Test
	public void should_ReturnListOfMessages_With_SenderId_ReceiverId() {
		// given
		String senderId = "U1";
		String receiverId = "U2";
		
		// when
		List<MessagePod4> expected = new ArrayList<MessagePod4>();
		message = new MessagePod4(1,"U1","U2",0,"2021-05-08T21:16:25","Hi, how are you?",0,0,0);
		expected.add(message);
		message = new MessagePod4(11,"U2","U1",0,"2021-05-08T21:16:38","I am fine user one!",0,0,1);
		expected.add(message);
		System.out.println(expected);
		
		// then
		List<MessagePod4> actual = userMessages.getMessages(senderId, receiverId);
		System.out.println(actual);
		assertEquals(actual.toString(), expected.toString());
	}
	
	@Disabled
	@Test
	public void should_ReturnTrue_When_UserMessage_Inserted() {
		// given
		message.setSenderId("U2");
		message.setUserReceiverId("U3");
		message.setMessageBody("Hello Group1 from Test!");
		
		assertTrue(userMessages.saveNewMessage(message));
	}
	
	@Disabled
	@Test
	public void should_DeleteAMessage_OnDeleteSender() {
		// given
		int messageId = 22;
		
		assertTrue(userMessages.deleteSenderMessage(messageId));
	}
	
	@Test
	public void should_ReturnFalse_When_DeletionNotValid() {
		// given
		int messageId = 23;
		
		assertFalse(userMessages.deleteReceiverMessage(messageId));
	}
}
