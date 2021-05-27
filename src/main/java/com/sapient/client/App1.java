//package com.sapient.client;
//
//import java.time.LocalDate;
//
//import com.sapient.dao.MessageRequestDAO;
//import com.sapient.dao.UpdateProfileDAO;
//import com.sapient.entity.MessageRequest;
//import com.sapient.exceptions.AgeLessThan18Exception;
//import com.sapient.exceptions.EmailNotValidException;
//import com.sapient.exceptions.NameTooSmallException;
//import com.sapient.exceptions.PasswordNotStrongException;
//import com.sapient.interfaces.IMessageRequestDAO;
//import com.sapient.interfaces.IUpdateProfileDAO;
//
//public class App1 {
//	public static void main(String[] args) {
//		MessageRequest m = new MessageRequest();
//		m.setSenderId("U1");
//		m.setReceiverId("U2");
//		m.setMessageBody("Hi Yogeshwar");
//		m.setIsAccepted(1);
//
//		IMessageRequestDAO dao = new MessageRequestDAO();
//		IUpdateProfileDAO dao1 = new UpdateProfileDAO();
//
//		try {
//			System.out.println(dao1.updateName("10001", "Yogeshwar") ? "Name Updated" : "Name Not Updated");
//		} catch (NameTooSmallException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		try {
//			System.out.println(dao1.updateEmail("10001", "kanhay8@yahoo.com") ? "Email Updated" : "Email Not updated");
//		} catch (EmailNotValidException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		try {
//			System.out.println(dao1.updatePassword("10001", "User3@789") ? "Password Updated" : "Password Not updated");
//		} catch (PasswordNotStrongException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		try {
//			System.out.println(dao1.updateDOB("10001", "1998-08-16") ? "DOB Updated" : "DOB Not updated");
//		} catch (AgeLessThan18Exception e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//
//		System.out.println(dao.saveMessage(m) ? "Inserted " : "Not Inserted");
//		System.out.println(dao.getMessage("10004", "10003"));
//		System.out.println(dao.getAllMessages());
//		System.out.println(dao.updateRequest(1, 1) ? "Updated" : "Not updated");
//
//	}
//}
