package de.qaware.mail.monitor;

import de.qaware.mail.api.Mailer;

/**
 * @author QAware GmbH
 */
public class MailMonitor {

    private static final int CHECKING_INTERVAL = 5 * 60 * 1000; // 5 minutes

    private final Mailer mailer;
    private boolean active = true;

    /**
     * Constructor.
     *
     * @param mailer
     */
    public MailMonitor(Mailer mailer) {
        this.mailer = mailer;
    }

    public void check() {
        while (active) {
            if (!mailer.isHealthy()) {
                alert();
                try {
                    Thread.sleep(CHECKING_INTERVAL);
                } catch (InterruptedException e) {
                    // document the exception
                }
            }
        }
    }

    private void alert() {
        // alert someone.
    }

    public void stop() {
        this.active = false;
    }
}
