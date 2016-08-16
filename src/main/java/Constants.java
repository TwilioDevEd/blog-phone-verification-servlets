final class Constants {

    private Constants() { }

    // See your account sid & auth token: https://www.twilio.com/user/account/settings
    static final String TWILIO_ACCOUNT_SID = "my-account-sid";
    static final String TWILIO_AUTH_TOKEN = "my-auth-token";

    // See your phone number: https://www.twilio.com/user/account/phone-numbers/incoming
    static final String TWILIO_PHONE_NUMBER = "my-phone-number";

    // Your URL should be accessible through the web. If you are testing locally, you can use 'ngrok' to expose it.
    // Remember to append the /twiml/ suffix.
    static final String TWILIO_SERVER_URL = "https://example.ngrok.io/twiml/";

}
