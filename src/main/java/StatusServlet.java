import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

public class StatusServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String phoneNumber = req.getParameter("phoneNumber");
        Optional<Number> numberOptional = NumberRepository.findByPhoneNumberAndVerified(phoneNumber, true);
        String status = numberOptional.isPresent() ? "verified" : "unverified";

        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(String.format("{\"status\": \"%s\"}", status));
        resp.getWriter().flush();
    }

}
