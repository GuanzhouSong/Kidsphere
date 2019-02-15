/*
Theme by: WebThemez.com 
*/
$(function () {
  var endDate = "March 15, 2019 00:00:00";

  $('.countdown.simple').countdown({date: endDate});

  $('.countdown.styled').countdown({
    date: endDate,
    render: function (data) {
      $(this.el).html(
          "<div class='countdownNum'>" + this.leadingZeros(data.days, 3)
          + " <span>days</span></div><div class='countdownNum'>"
          + this.leadingZeros(data.hours, 2)
          + " <span>hrs</span></div><div>" + this.leadingZeros(data.min, 2)
          + " <span >min</span></div><div>" + this.leadingZeros(data.sec, 2)
          + " <span>sec</span></div>");
    }
  });

  $('.countdown.callback').countdown({
    date: +(new Date) + 10000,
    render: function (data) {
      $(this.el).text(this.leadingZeros(data.sec, 2) + " sec");
    },
    onEnd: function () {
      $(this.el).addClass('ended');
    }
  }).on("click", function () {
    $(this).removeClass('ended').data('countdown').update(
        +(new Date) + 10000).start();
  });

  $('#submit').on("click", function () {
    var email = $('#email').val();
    if (!validateEmail(email)) {
      alert("hmmm…… seems like it's not an email, please check again");
      return
    }
    var user = {
      email: email
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
   