/*
Theme by: WebThemez.com 
*/
$(function () {
  $('#submit').on("click", function () {
    var email = $('#email').val();
    if (!validateEmail(email)) {
      alert(
          "Hey, seems like this is not an email. We understand parenting is hard, let us make it easier.");
      return
    }
    var osType = $("input[type='radio']:checked").val();
    console.log(osType)
    var user = {
      email: email,
      osType: osType
    }
    fetch("/api/user/subscribe", {
      method: 'POST',
      body: JSON.stringify(user),
      headers: {
        'content-type': 'application/json'
      }
    }).then(function (response) {
      if (response.status == 200) {
        alert("Subscribed! Stay Tuned. We are this... close to complete!")
      } else if (response.status == 409) {
        alert("Already subscribed. We love your passion toward us!")
      } else {
        alert("Something goes wrong, please try again.")
      }
    })
  });

  function validateEmail(email) {
    var re = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    return re.test(email);
  }


});
   