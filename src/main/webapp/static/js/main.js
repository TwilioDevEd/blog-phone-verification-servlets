$(document).ready(function(){
  $("#enter_number_form").submit(function(e) {
    e.preventDefault();
    initiateCall();
  });
});

function initiateCall() {
  $.post("/call/", $("#enter_number_form").serialize(), function(data) {
    showCodeForm(data.verificationCode);
  }, "json");
  checkStatus();
}

function showCodeForm(code) {
  $("#verificationCode").text(code);
  $("#verify_code").fadeIn();
  $("#enter_number_form").fadeOut();
}

function checkStatus() {
  $.post("/status/", $("#enter_number_form").serialize(), function(data) {
    updateStatus(data.status);
  }, "json");
}

function updateStatus(current) {
  if (current === "unverified") {
    $("#status").append(".");
    setTimeout(checkStatus, 3000);
  } else {
    $("#status").text("Verified!");
  }
}
