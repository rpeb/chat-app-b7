package com.sapient.entity;

public class MessageRequest {
	private int requestId;
	private String senderId;
	private String receiverId;
	private String messageBody;
	private int isAccepted;

	public MessageRequest() {

	}

	public MessageRequest(int requestId, String senderId, String receiverId, String messageBody, int isAccepted) {
		this.requestId = requestId;
		this.senderId = senderId;
		this.receiverId = receiverId;
		this.messageBody = messageBody;
		this.isAccepted = isAccepted;
	}

	public int getRequestId() {
		return requestId;
	}

	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}

	public String getSenderId() {
		return senderId;
	}

	public void setSenderId(String senderId) {
		this.senderId = senderId;
	}

	public String getReceiverId() {
		return receiverId;
	}

	public void setReceiverId(String receiverId) {
		this.receiverId = receiverId;
	}

	public String getMessageBody() {
		return messageBody;
	}

	public void setMessageBody(String messageBody) {
		this.messageBody = messageBody;
	}

	public int getIsAccepted() {
		return isAccepted;
	}

	public void setIsAccepted(int isAccepted) {
		this.isAccepted = isAccepted;
	}

	@Override
	public String toString() {
		return "MessageRequest [requestId=" + requestId + ", senderId=" + senderId + ", receiverId=" + receiverId
				+ ", messageBody=" + messageBody + ", isAccepted=" + isAccepted + "]";
	}

}
