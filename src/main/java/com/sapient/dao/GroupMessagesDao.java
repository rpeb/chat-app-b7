package com.sapient.dao;

import java.sql.*;
import java.util.*;

import com.sapient.entity.MessagePod4;
import com.sapient.interfaces.IGroupMessageDao;
import com.sapient.utils.GetConnection;

public class GroupMessagesDao implements IGroupMessageDao {
	public List<MessagePod4> getMessages(String userId, int groupReceiver) {
		String sqlGroupSender = "SELECT * FROM messages WHERE sender_id = ? AND group_receiver_id = ? ORDER BY time_of_messaging";
		String sqlGroupReceiver = "SELECT * FROM messages WHERE group_receiver_id = ? ORDER BY time_of_messaging";
		try {
			PreparedStatement psGroupSender = GetConnection.getPreparedStatement(sqlGroupSender);
			PreparedStatement psGroupReceiver = GetConnection.getPreparedStatement(sqlGroupReceiver);
			psGroupSender.setString(1, userId);
			psGroupSender.setInt(2, groupReceiver);
			psGroupReceiver.setInt(1, groupReceiver);
			ResultSet senderMessages = psGroupSender.executeQuery();
			ResultSet receiverMessages = psGroupReceiver.executeQuery();
			List<MessagePod4> list = new ArrayList<MessagePod4>();
			
			while (senderMessages.next()) {
				MessagePod4 message = new MessagePod4();
				message.setMessageId(senderMessages.getInt("message_id"));
				message.setMessageBody(senderMessages.getString("message_body"));
				String dateOfMessage = senderMessages.getDate("time_of_messaging").toString();
				String timeOfMessage = senderMessages.getTime("time_of_messaging").toString();
				message.setTimeOfMessaging(dateOfMessage + "T" + timeOfMessage);
				message.setSenderId(userId);
				message.setMessageId(senderMessages.getInt("message_id"));
				message.setDeletedSender(senderMessages.getInt("deleted_sender"));
				message.setDeletedReceiver(senderMessages.getInt("deleted_receiver"));
				message.setReplyToAMessage(senderMessages.getInt("reply_to_a_message"));
				list.add(message);
			}
			
			while (receiverMessages.next()) {
				MessagePod4 message = new MessagePod4();
				message.setMessageId(receiverMessages.getInt("message_id"));
				message.setMessageBody(receiverMessages.getString("message_body"));
				String dateOfMessage = receiverMessages.getDate("time_of_messaging").toString();
				String timeOfMessage = receiverMessages.getTime("time_of_messaging").toString();
				message.setTimeOfMessaging(dateOfMessage + "T" + timeOfMessage);
				message.setSenderId(receiverMessages.getString("sender_id"));
				message.setMessageId(receiverMessages.getInt("message_id"));
				message.setDeletedSender(receiverMessages.getInt("deleted_sender"));
				message.setDeletedReceiver(receiverMessages.getInt("deleted_receiver"));
				message.setReplyToAMessage(receiverMessages.getInt("reply_to_a_message"));
				list.add(message);
			}
			
			return list;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public MessagePod4 getMessageById(int messageId) {
		String sql = "SELECT * from messages WHERE message_id=?";
		try {
			PreparedStatement ps = GetConnection.getPreparedStatement(sql);
			ps.setInt(1, messageId);
			ResultSet result = ps.executeQuery();
			result.next();
			MessagePod4 message = new MessagePod4();
			message.setSenderId(result.getString("sender_id"));
			message.setGroupReceiverId(result.getInt("group_receiver_id"));
			message.setMessageBody(result.getString("message_id"));
			String dateOfMessage = result.getDate("time_of_messaging").toString();
			String timeOfMessage = result.getTime("time_of_messaging").toString();
			message.setTimeOfMessaging(dateOfMessage + "T" + timeOfMessage);
			message.setDeletedSender(result.getInt("deleted_sender"));
			message.setDeletedReceiver(result.getInt("deleted_receiver"));
			message.setReplyToAMessage(result.getInt("reply_to_a_message"));
			return message;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	public boolean saveNewMessage(MessagePod4 message) {
		String sql = "INSERT INTO messages(sender_id, group_receiver_id, message_body, reply_to_a_message) VALUES(?,?,?,?)";
		try {
			PreparedStatement ps = GetConnection.getMySQLConn().prepareStatement(sql);
			ps.setString(1, message.getSenderId());
			ps.setInt(2, message.getGroupReceiverId());
			ps.setString(3, message.getMessageBody());
			if (message.getReplyToAMessage() > 0) {
				ps.setInt(4, message.getReplyToAMessage());
			} else {
				ps.setInt(4, 0);
			}
			return ps.executeUpdate() > 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
}
