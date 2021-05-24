package com.sapient.client;

import java.util.ArrayList;
import java.util.List;

import com.sapient.dao.*;
import com.sapient.entity.MessagePod4;

public class App4 {
	public static void main(String[] args) {
		UserMessagesDao userMessages = new UserMessagesDao();
		List<MessagePod4> list = new ArrayList<MessagePod4>();
		list = userMessages.getMessagesForASender("U1");
		for (MessagePod4 mp: list) {
			System.out.println(mp.getNameOfUser());
			System.out.println(mp.getUserReceiverId());
			System.out.println(mp.getGroupReceiverId());
		}
	}
}
