import com.twilio.sdk.TwilioRestClient;
import com.twilio.sdk.TwilioRestException;
import com.twilio.sdk.resource.factory.CallFactory;
import org.apache.http.message.BasicNameValuePair;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Random;

import static java.util.Arrays.asList;

public class CallServlet extends HttpServlet {

    private CallFactory callFactory;

    public CallServlet() {
        this.callFactory = new TwilioRestClient(
                Constants.TWILIO_ACCOUNT_SID, Constants.TWILIO_AUTH_TOKEN
        ).getAccount().getCallFactory();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String phoneNumber = req.getParameter("phoneNumber");
            String verificationCode = random(100_000, 999_999);

            NumberRepository.remove(phoneNumber);
            NumberRepository.save(new Number(phoneNumber, verificationCode));

            callFactory.create(asList(
                    new BasicNameValuePair("From", Constants.TWILIO_PHONE_NUMBER),
                    new BasicNameValuePair("To", phoneNumber),
                    new BasicNameValuePair("Url", Constants.TWILIO_SERVER_URL)
            ));

            resp.setContentType("application/json");
            resp.setCharacterEncoding("UTF-8");
            resp.getWriter().write(String.format("{\"verificationCode\": \"%s\"}", verificationCode));
            resp.getWriter().flush();
        } catch (TwilioRestException e) {
            throw new RuntimeException(e);
        }
    }

    static String random(int minimum, int maximum) {
        Random rand = new Random();
        Integer code = rand.nextInt(maximum - minimum + 1) + minimum;
        return code.toString();
    }

}
