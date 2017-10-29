package de.qaware.mail.sender.impl;

import de.qaware.mail.sender.api.MailMessage;
import de.qaware.mail.sender.api.MailSender;
import org.slf4j.Logger;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.SendFailedException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * @author QAware GmbH
 */
public class JavaMailSender implements MailSender {

    private static final Logger LOGGER = getLogger(JavaMailSender.class);

    private final String from;
    private final String host;

    /**
     * Constructor.
     *
     * @param from the sender
     * @param host the SMTP server
     */
    public JavaMailSender(String from, String host) {
        this.from = from;
        this.host = host;
    }

    @Override
    public void sendMessage(String to, MailMessage mailMessage) {
        // create some properties and get the default Session
        Properties props = new Properties();
        props.put("mail.smtp.host", host);
        Session session = Session.getInstance(props, null);

        try {
            MimeMessage msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress(from));
            InternetAddress[] address = {new InternetAddress(to)};
            msg.setRecipients(Message.RecipientType.TO, address);
            msg.setSubject(mailMessage.getSubject());
            msg.setSentDate(new Date());
            msg.setText(mailMessage.getBody());

            Transport.send(msg);
        } catch (SendFailedException e) {
            LOGGER.error("Error Sending mail", e);
        } catch (AddressException e) {
            LOGGER.error("Error with addresses", e);
        } catch (MessagingException e) {
            LOGGER.error("Error handling mail", e);
        }
    }
}
