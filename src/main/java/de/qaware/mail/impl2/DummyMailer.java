package de.qaware.mail.impl2;

import de.qaware.mail.api.Mailer;
import de.qaware.mail.sender.api.MailSender;

/**
 * @author QAware GmbH
 */
public class DummyMailer implements Mailer {

    @Override
    public boolean isHealthy() {
        return false;
    }

    @Override
    public MailSender getSender() {
        return null;
    }
}
