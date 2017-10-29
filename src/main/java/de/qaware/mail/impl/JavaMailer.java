package de.qaware.mail.impl;

import de.qaware.mail.api.Mailer;
import de.qaware.mail.sender.api.MailSender;

/**
 * @author QAware GmbH
 */
public class JavaMailer implements Mailer {

    private final MailSender mailSender;

    public JavaMailer(MailSender mailSender) {
        this.mailSender = mailSender;
    }

    @Override
    public boolean isHealthy() {
        return true;
    }

    @Override
    public MailSender getSender() {
        return mailSender;
    }
}
