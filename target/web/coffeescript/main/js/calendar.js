(function() {
  var calUrlToEventType;

  $(document).ready(function() {
    $("body").on("hidden.bs.modal", ".modal", function() {
      return $(this).removeData("bs.modal");
    });
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
          editable: true,
          color: "#92E1C0"
        }, {
          url: "https://www.google.com/calendar/feeds/gehqh0ptgh0i2hkh3f1l4tlerg%40group.calendar.google.com/private-65a3820d5b7a4aa1ac390d21d85d93fc/basic",
          editable: true,
          color: "#9FC6E7"
        }, {
          url: "https://www.google.com/calendar/feeds/3jg1lna270kjsjb0jjrhhqo5m8%40group.calendar.google.com/private-57e4356bbde4ecb5ba981a2eedb4dd91/basic",
          editable: true,
          color: "#FAD165"
        }, {
          url: "https://www.google.com/calendar/feeds/hq8a7ru1eh0qoj7bpn05amtsg8%40group.calendar.google.com/private-14076798185cd1615e25439fbd969ae8/basic",
          editable: true,
          color: "#CABDBF"
        }
      ],
      defaultView: "agendaWeek",
      firstDay: 1,
      selectable: true,
      selectHelper: true,
      unselectCancel: ".form-horizontal",
      select: function(startDate, endDate, allDay, jsEvent, view) {
        var pos;
        $(".popover").remove();
        $("#startDate").attr("value", startDate.getTime());
        $("#endDate").attr("value", endDate.getTime());
        $("#allDay").attr("value", allDay);
        pos = (allDay ? "bottom" : "top");
        $(jsEvent.target).popover({
          trigger: "manual",
          placement: pos,
          container: "body",
          html: true,
          content: function() {
            return $("#newEventPopover").html();
          }
        });
        $(jsEvent.target).popover("show");
        $(".inputEventName").focus();
        return $(".selectEventType").change(function(e) {
          var eventType, s;
          s = e.currentTarget;
          eventType = s.options[s.selectedIndex].value;
          if (eventType === 'INSTALLATION') {
            return $.get("/events", function(events) {
              $(".selectAction").html('<option class="blank" value="">-- Priradená akcia --</option>');
              $.each(events, function(index, event) {
                var opt;
                opt = $("<option>").text(event.name);
                opt.prop("value", event.id);
                return $(".selectAction").append(opt);
              });
              return $(".selectActionContainer").html($("#selectActionGroup").html());
            });
          } else {
            return $(".selectActionContainer").html("");
          }
        });
      },
      unselect: function(view, jsEvent) {
        $(".popover").remove();
        return $(".selectActionContainer").html("");
      },
      eventClick: function(event, jsEvent, view) {
        var pos, type;
        $(".popover").remove();
        pos = (event.allDay ? "bottom" : "top");
        $(jsEvent.target).popover({
          trigger: "manual",
          placement: pos,
          container: "body",
          html: true,
          content: function() {
            return $("#eventClickPopover").html();
          }
        });
        $("h4").html(event.title);
        type = calUrlToEventType(event.source.url);
        if (type === "ACTION") {
          $("#eventClickUl").html('<li><a class="linkMove" href="#" >Zmenit na rezervaciu</a></li><li><a href="/event/priceOffer/' + type + '/' + event.id + '">Cenova ponuka</a></li>');
        }
        if (type === "RESERVATION") {
          $("#eventClickUl").html('<li><a class="linkMove" href="#">Zmenit na akciu</a></li><li><a href="/event/priceOffer/' + type + '/' + event.id + '">Cenova ponuka</a></li>');
        }
        if (type === "SELFTRANSPORT") {
          $("#eventClickUl").html('<li><a href="/event/priceOffer/' + type + '/' + event.id + '">Cenova ponuka</a></li>');
        }
        if (type === "INSTALLATION") {
          $("#eventClickUl").html('');
        }
        $(".btnDelete").attr("href", "/event/delete/" + type + "/" + event.id);
        $(jsEvent.target).popover("show");
        $(".linkMove").click(function() {
          return $.post("/event/move/" + type + "/" + event.id).done(function(data) {
            $(".popover").remove();
            return $("#calendar").fullCalendar("refetchEvents");
          });
        });
        $(".btnEdit").attr("href", "/event/" + type + "/" + event.id);
        return false;
      },
      eventResize: function(event, dayDelta, minuteDelta, revertFunc, jsEvent, ui, view) {
        return $.post("/event/drag", {
          id: event.id,
          eventType: calUrlToEventType(event.source.url),
          allDay: event.allDay,
          startDate: event.start.getTime(),
          endDate: event.end.getTime()
        }).done(function(data) {
          return console.log(data);
        });
      },
      eventDrop: function(event, dayDelta, minuteDelta, allDay, revertFunc, jsEvent, ui, view) {
        return $.post("/event/drag", {
          id: event.id,
          eventType: calUrlToEventType(event.source.url),
          allDay: event.allDay,
          startDate: event.start.getTime(),
          endDate: event.end.getTime()
        }).done(function(data) {
          return console.log(data);
        });
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
