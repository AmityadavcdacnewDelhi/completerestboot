package org.fi.spring.completerestboot.services;

public interface MailService
{
	public void sendMail(String to, String subject, String contents);
}
