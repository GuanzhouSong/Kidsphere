/*
Theme by: WebThemez.com 
*/
$(function () {
  $('#submit').on("click", function () {
    var email = $('#email').val();
    if (!validateEmail(email)) {
      alert("hmmm…… seems like it's not an email, please check again");
      return
    }
    var osType = $('#os :selected').val();
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
        alert("Subscribed! Thank you so much!")
      } else if (response.status == 409) {
        alert("Already subscribed, Thank you so much!")
      } else {
        alert("something goes wrong, please try again")
      }
    })
  });

  function validateEmail(email) {
    var re = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    return re.test(email);
  }


});
   