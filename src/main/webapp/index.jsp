<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Phone Verification by Twilio</title>
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
    <script type="text/javascript" src="/static/js/main.js"></script>
    <link rel="stylesheet" href="/static/css/style.css">
  </head>
  <body>
    <form id="enter_number_form">
      <p>Enter your phone number:</p>
      <p><input type="text" name="phoneNumber" id="phoneNumber" /></p>
      <p><input type="submit" name="submit" value="Verify" /></p>
    </form>

    <div id="verify_code" style="display: none;">
      <p>Calling you now.</p>
      <p>When prompted, enter the verification code:</p>
      <h1 id="verificationCode"></h1>
      <p><strong id="status">Waiting...</strong></p>
    </div>
  </body>
</html>
