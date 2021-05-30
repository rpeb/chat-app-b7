package com.sapient.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

import com.sapient.entity.MessageRequest;
import com.sapient.interfaces.IMessageRequestDAO;

class MessageRequestDAOTest {
	private MessageRequest messageRequest = null;
	private IMessageRequestDAO messageRequestDao = null;
	@BeforeEach
	public void setUpMessageRequestDao() {
		messageRequestDao = new MessageRequestDAO();
	}
	
	@Disabled
	@Test
	@DisplayName("Should Return True When Message Saved to Database.")
	public void should_ReturnTrue_When_MessageSaved() {
		messageRequest = new MessageRequest();
		messageRequest.setSenderId("U5");
		messageRequest.setReceiverId("U3");
		messageRequest.setMessageBody("Hi From Message Request DAO Test");
		messageRequest.setIsAccepted(1);
		
		boolean expected = true;
		boolean actual = messageRequestDao.saveMessage(messageRequest);
		
		assertEquals(expected, actual);
	}
	
	@Disabled
	@Test
	@DisplayName("Should Return More Than 0 When All message is Requested.")
	public void should_ReturnMoreThan0_When_AllMessageRequested() {
		int notExpected = 0;
		int actual = messageRequestDao.getAllMessages().size();
		
		assertNotEquals(notExpected, actual);
	}
}
