# Blog Phone Verification Servlets
[![Java Servlet CI](https://github.com/TwilioDevEd/blog-phone-verification-servlets/actions/workflows/gradle.yml/badge.svg)](https://github.com/TwilioDevEd/blog-phone-verification-servlets/actions/workflows/gradle.yml)

## Set up

### Requirements

- [Java Development Kit](https://adoptopenjdk.net/) version 8
- A Twilio account - [sign up](https://www.twilio.com/try-twilio)

### Twilio Account Settings

This application should give you a ready-made starting point for writing your
own appointment reminder application. Before we begin, we need to collect
all the config values we need to run the application:

| Config Value | Description                                                                                                                                                  |
| :---------------- | :----------------------------------------------------------------------------------------------------------------------------------------------------------- |
| Account Sid  | Your primary Twilio account identifier - find this [in the Console](https://www.twilio.com/console).                                                         |
| Auth Token   | Used to authenticate - [just like the above, you'll find this here](https://www.twilio.com/console).                                                         |
| Phone number | A Twilio phone number in [E.164 format](https://en.wikipedia.org/wiki/E.164) - you can [get one here](https://www.twilio.com/console/phone-numbers/incoming) |

### Local development

1. First clone this repository and `cd` into it.

   ```bash
   git clone git@github.com:TwilioDevEd/blog-phone-verification-servlets.git
   cd blog-phone-verification-servlets
   ```

1.  Set your environment variables

    ```bash
    cp .env.example .env
    ```
    See [Twilio Account Settings](#twilio-account-settings) to locate the necessary environment variables.


1. Start the server.

   ```bash
   ./gradlew appRun
   ```

1. Check it out at [http://localhost:8080](http://localhost:8080).

That's it!

## Meta

* No warranty expressed or implied. Software is as is. Diggity.
* [MIT License](http://www.opensource.org/licenses/mit-license.html)
* Lovingly crafted by Twilio Developer Education.
