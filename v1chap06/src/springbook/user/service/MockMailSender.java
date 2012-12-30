package springbook.user.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

public class MockMailSender implements MailSender {
	private List<String> requests = new ArrayList<String>();
	
	public List<String> getRequests() {
		return requests;
	}

	@Override
	public void send(SimpleMailMessage mailMessage) throws MailException {
		requests.add(mailMessage.getTo()[0]);
	}

	@Override
	public void send(SimpleMailMessage[] arg0) throws MailException {
	}

}
