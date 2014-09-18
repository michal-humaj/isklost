(function() {
  var calUrlToEventType;

  $(document).ready(function() {
    $("#calendar").fullCalendar({
      editable: true,
      header: {
        left: "prev,next today",
        center: "title",
        right: "month,agendaWeek,agendaDay"
      },
      buttonText: {
        prev: "<span class='fa fa-caret-left'></span>",
        next: "<span class='fa fa-caret-right'></span>",
        today: "today",
        month: "month",
        week: "week",
        day: "day"
      },
      height: $(window).height() - 120,
      windowResize: function(view) {
        return $("#calendar").fullCalendar("option", "height", $(window).height() - 120);
      },
      eventSources: [
        {
          url: "https://www.google.com/calendar/feeds/o776rmha219v92fvejs0hahsso%40group.calendar.google.com/private-6968d2f0aa2dee4823410b8e47fa040c/basic",
          color: "#7BD148",
          borderColor: "#48A015"
        }, {
          url: "https://www.google.com/calendar/feeds/gehqh0ptgh0i2hkh3f1l4tlerg%40group.calendar.google.com/private-65a3820d5b7a4aa1ac390d21d85d93fc/basic",
          color: "#F83A22",
          borderColor: "#C50700"
        }, {
          url: "https://www.google.com/calendar/feeds/3jg1lna270kjsjb0jjrhhqo5m8%40group.calendar.google.com/private-57e4356bbde4ecb5ba981a2eedb4dd91/basic",
          color: "#F691B2",
          borderColor: "#C36080"
        }, {
          url: "https://www.google.com/calendar/feeds/hq8a7ru1eh0qoj7bpn05amtsg8%40group.calendar.google.com/private-14076798185cd1615e25439fbd969ae8/basic",
          backgroundColor: "#FAD165",
          borderColor: "#C7A032"
        }
      ],
      defaultView: "agendaWeek",
      firstDay: 1,
      eventTextColor: '#000000',
      eventClick: function(event, jsEvent, view) {
        var title, type;
        type = calUrlToEventType(event.source.url);
        if (type === "INSTALLATION") {
          return false;
        }
        title = event.title.split("#");
        window.open("" + window.location + "storeman/event/" + type + "/" + event.id + "/" + title[0], "_self");
        return false;
      }
    });
    return $("#datepicker").datepicker({
      format: "mm.dd. yyyy",
      weekStart: 1,
      todayBtn: true,
      language: "sk",
      todayHighlight: true
    }).on("changeDate", function(ev) {
      var date;
      date = ev.date;
      return $("#calendar").fullCalendar("gotoDate", date.getFullYear(), date.getMonth(), date.getDate());
    });
  });

  calUrlToEventType = function(url) {
    if (url === "https://www.google.com/calendar/feeds/o776rmha219v92fvejs0hahsso%40group.calendar.google.com/private-6968d2f0aa2dee4823410b8e47fa040c/basic") {
      return "ACTION";
    } else if (url === "https://www.google.com/calendar/feeds/gehqh0ptgh0i2hkh3f1l4tlerg%40group.calendar.google.com/private-65a3820d5b7a4aa1ac390d21d85d93fc/basic") {
      return "INSTALLATION";
    } else if (url === "https://www.google.com/calendar/feeds/3jg1lna270kjsjb0jjrhhqo5m8%40group.calendar.google.com/private-57e4356bbde4ecb5ba981a2eedb4dd91/basic") {
      return "RESERVATION";
    } else {
      if (url === "https://www.google.com/calendar/feeds/hq8a7ru1eh0qoj7bpn05amtsg8%40group.calendar.google.com/private-14076798185cd1615e25439fbd969ae8/basic") {
        return "SELFTRANSPORT";
      }
    }
  };

}).call(this);

//# sourceMappingURL=calendar.js.map
