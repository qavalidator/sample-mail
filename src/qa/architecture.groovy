architecture(name: "T-View", prefix: "tview", reflexMLversion: "1.0") {

    excludes "java.lang.**", "java.util.**", "org.slf4j.**"

    component ("Monitor") {
        // uses "IMail" --> is allowed implicitly, because the components are siblings
        impl "de.qaware.mail.monitor.**"
    }

    component ("Mail") {
        api "IMail" : "de.qaware.mail.api.**"
        impl "de.qaware.mail.impl.**", "de.qaware.mail.impl2.**"

        component ("MailSender") {
            api "de.qaware.mail.sender.api.**"
            impl "de.qaware.mail.sender.impl.JavaMailSender"
            uses "JavaMail"
        }
    }

    component ("3rdParty") {
        component("JavaMail") {api "javax.mail.**"}
    }
}
