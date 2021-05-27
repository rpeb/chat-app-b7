package com.sapient.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sapient.entity.MessageRequest;
import com.sapient.interfaces.IMessageRequestDAO;
import com.sapient.utils.GetConnection;

public class MessageRequestDAO implements IMessageRequestDAO {

	public boolean saveMessage(MessageRequest messageRequest) {
		String sql = "insert into messagerequest values(default,?,?,?,?)";
		try {
			PreparedStatement ps = GetConnection.getMySQLConn().prepareStatement(sql);
			ps.setString(1, messageRequest.getSenderId());
			ps.setString(2, messageRequest.getReceiverId());
			ps.setString(3, messageRequest.getMessageBody());
			ps.setInt(4, messageRequest.getIsAccepted());

			return ps.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public MessageRequest getMessage(String senderId, String receiverId) {
		String sql = "select request_id, sender_id, receiver_id, message_body, is_accepted from messagerequest where sender_id = ? and receiver_id = ?";

		try {
			PreparedStatement ps = GetConnection.getMySQLConn().prepareStatement(sql);
			ps.setString(1, senderId);
			ps.setString(2, receiverId);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				MessageRequest messageRequest = new MessageRequest();
				messageRequest.setRequestId(rs.getInt(1));
				messageRequest.setSenderId(rs.getString(2));
				messageRequest.setReceiverId(rs.getString(3));
				messageRequest.setMessageBody(rs.getString(4));
				messageRequest.setIsAccepted(rs.getInt(5));
				return messageRequest;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<MessageRequest> getMessage(String receiverId) {
		String sql = "select request_id, sender_id, receiver_id, message_body, is_accepted from messagerequest where receiver_id = ?";
		List<MessageRequest> list = null;
		try {
			PreparedStatement ps = GetConnection.getMySQLConn().prepareStatement(sql);
			ps.setString(1, receiverId);
			ResultSet rs = ps.executeQuery();
			list = new ArrayList<MessageRequest>();
			while (rs.next()) {
				MessageRequest messageRequest = new MessageRequest();
				messageRequest.setRequestId(rs.getInt(1));
				messageRequest.setSenderId(rs.getString(2));
				messageRequest.setReceiverId(rs.getString(3));
				messageRequest.setMessageBody(rs.getString(4));
				messageRequest.setIsAccepted(rs.getInt(5));
				list.add(messageRequest);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}


	public List<MessageRequest> getAllMessages() {
		String sql = "select request_id, sender_id, receiver_id, message_body, is_accepted from messagerequest";
		List<MessageRequest> list = null;
		try {
			PreparedStatement ps = GetConnection.getMySQLConn().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			list = new ArrayList<MessageRequest>();
			while (rs.next()) {
				MessageRequest messageRequest = new MessageRequest();
				messageRequest.setSenderId(rs.getString(2));
				messageRequest.setReceiverId(rs.getString(3));
				messageRequest.setMessageBody(rs.getString(4));
				messageRequest.setIsAccepted(rs.getInt(5));
				list.add(messageRequest);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public boolean updateRequest(int requestId, int isAccepted) {
		String sql = "update messagerequest set is_accepted = ? where request_id = ?";
		try {
			PreparedStatement ps = GetConnection.getMySQLConn().prepareStatement(sql);
			ps.setInt(1, isAccepted);
			ps.setInt(2, requestId);
			return ps.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
