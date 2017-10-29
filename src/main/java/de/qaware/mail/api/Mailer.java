package de.qaware.mail.api;

import de.qaware.mail.sender.api.MailSender;

/**
 * @author QAware GmbH
 */
public interface Mailer {

    /**
     * Health check.
     */
    boolean isHealthy();

    MailSender getSender();
}
