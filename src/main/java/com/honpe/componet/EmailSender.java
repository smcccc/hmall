package com.honpe.componet;

public interface EmailSender {
	void sendEmail(String template, String fromUser, String toUser, String subject, String content);
}
