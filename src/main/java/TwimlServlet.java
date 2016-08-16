import com.twilio.sdk.verbs.Gather;
import com.twilio.sdk.verbs.Say;
import com.twilio.sdk.verbs.TwiMLResponse;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.Optional;

import static org.apache.commons.lang3.StringUtils.isEmpty;

public class TwimlServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        try {
            String verificationCode = req.getParameter("Digits");
            String phoneNumber = req.getParameter("Called");

            TwiMLResponse twiml = new TwiMLResponse();
            if (isEmpty(verificationCode)) {
                Gather gather = new Gather();
                gather.setNumDigits(6);
                gather.append(new Say("Please enter your verification code."));
                twiml.append(gather);
            } else {
                Optional<Number> numberOptional = NumberRepository.findByPhoneNumberAndVerificationCode(phoneNumber, verificationCode);
                if (!numberOptional.isPresent()) {
                    Gather gather = new Gather();
                    gather.setNumDigits(6);
                    gather.append(new Say("Verification code incorrect, please try again."));
                    twiml.append(gather);
                } else {
                    Number number = numberOptional.get();
                    NumberRepository.markAsVerified(phoneNumber);
                    twiml.append(new Say("Thank you! Your phone number has been verified."));
                }
            }

            resp.setContentType("application/xml");
            resp.getWriter().print(twiml.toXML());
            resp.getWriter().flush();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
