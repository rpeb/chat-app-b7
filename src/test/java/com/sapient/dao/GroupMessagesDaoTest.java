package com.sapient.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

import org.junit.jupiter.api.*;

import com.sapient.entity.MessagePod4;

class GroupMessagesDaoTest {
	private MessagePod4 messagePod4 = new MessagePod4();
	GroupMessagesDao groupMessage = new GroupMessagesDao();
	
	@Disabled
	@Test
	public void should_ReturnListOfMessagePod4s_With_SenderId_ReceiverId() {
		// given
		String senderId = "U5";
		int receiverId = 2;
		
		// when
		List<MessagePod4> expected = new ArrayList<MessagePod4>();
		messagePod4 = new MessagePod4(2,"U5",null,2,"2021-05-08T21:16:26","Hi, I am user five!",0,0,0);
		expected.add(messagePod4);
		messagePod4 = new MessagePod4(6,"U5",null,2,"2021-05-08T21:16:32","Hi group two, user five here!",0,0,0);
		expected.add(messagePod4);
		System.out.println("expected = "+ expected);
		
		// then
		List<MessagePod4> actual = groupMessage.getMessages(senderId, receiverId);
		System.out.println("actual = " + actual);
		assertEquals(actual.toString(), expected.toString());
	}
	
	@Test
	public void should_ReturnTrue_When_MessagePod4_Inserted() {
		// given
		messagePod4.setSenderId("U3");
		messagePod4.setGroupReceiverId(1);
		messagePod4.setMessageBody("Hello Group1 from Test!");
		
		assertTrue(groupMessage.saveNewMessage(messagePod4));
	}
	
	@Test
	public void should_Update_ReplyToAMessagePod4() {
		// given
		messagePod4.setSenderId("U2");
		messagePod4.setGroupReceiverId(1);
		messagePod4.setMessageBody("Hello Group1 from Test!");
		messagePod4.setReplyToAMessage(21);
		
		assertTrue(groupMessage.saveNewMessage(messagePod4));
	}
	
}
