package de.qaware.mail.sender.api;

/**
 * @author QAware GmbH
 */
public interface MailSender {

    void sendMessage(String to, MailMessage mailMessage);
}
