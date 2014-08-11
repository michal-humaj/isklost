$ ->
  $("body").on "hidden.bs.modal", ".modal", ->
    $(this).removeData "bs.modal"

  $("#calendar").fullCalendar
    editable: true
    header:
      left: "prev,next today"
      center: "title"
      right: "month,agendaWeek,agendaDay"

    buttonText: #This is to add icons to the visible buttons
      prev: "<span class='fa fa-caret-left'></span>"
      next: "<span class='fa fa-caret-right'></span>"
      today: "today"
      month: "month"
      week: "week"
      day: "day"

    height: $(window).height() - 120
    windowResize: (view) ->
      $("#calendar").fullCalendar "option", "height", $(window).height() - 120
    eventSources: [
      {
        url: "https://www.google.com/calendar/feeds/o776rmha219v92fvejs0hahsso%40group.calendar.google.com/private-6968d2f0aa2dee4823410b8e47fa040c/basic"
        editable: true
        color: "#92E1C0"
      }
      {
        url: "https://www.google.com/calendar/feeds/gehqh0ptgh0i2hkh3f1l4tlerg%40group.calendar.google.com/private-65a3820d5b7a4aa1ac390d21d85d93fc/basic"
        editable: true
        color: "#9FC6E7"
      }
      {
        url: "https://www.google.com/calendar/feeds/3jg1lna270kjsjb0jjrhhqo5m8%40group.calendar.google.com/private-57e4356bbde4ecb5ba981a2eedb4dd91/basic"
        editable: true
        color: "#FAD165"
      }
      {
        url: "https://www.google.com/calendar/feeds/hq8a7ru1eh0qoj7bpn05amtsg8%40group.calendar.google.com/private-14076798185cd1615e25439fbd969ae8/basic"
        editable: true
        color: "#CABDBF"
      }
    ]
    defaultView: "agendaWeek"
    firstDay: 1
    selectable: true
    selectHelper: true
    unselectCancel: ".form-horizontal"
    select: (startDate, endDate, allDay, jsEvent, view) ->
      $(".popover").remove()
      $("#startDate").attr "value", startDate.getTime()
      $("#endDate").attr "value", endDate.getTime()
      $("#allDay").attr "value", allDay
      pos = (if allDay then "bottom" else "top")
      $(jsEvent.target).popover
        trigger: "manual"
        placement: pos
        container: "body"
        html: true
        content: ->
          $("#newEventPopover").html()
      $(jsEvent.target).popover "show"
      $(".inputEventName").focus()

    unselect: (view, jsEvent) ->
      $(".popover").remove()

    eventClick: (event, jsEvent, view) ->
      $(".popover").remove()
      pos = (if event.allDay then "bottom" else "top")
      $(jsEvent.target).popover
        trigger: "manual"
        placement: pos
        container: "body"
        html: true
        content: ->
          $("#eventClickPopover").html()

      $("h4").html event.title
      type = calUrlToEventType event.source.url
      if type is "ACTION"
        $("#eventClickUl").html '<li><a class="linkMove" href="#" >Zmenit na rezervaciu</a></li><li><a href="#">Cenova ponuka</a></li>'
      if type is "RESERVATION"
        $("#eventClickUl").html '<li><a class="linkMove" href="#">Zmenit na akciu</a></li><li><a href="#">Cenova ponuka</a></li>'
      if type is "SELFTRANSPORT"
        $("#eventClickUl").html '<li><a href="#">Cenova ponuka</a></li>'
      if type is "INSTALLATION"
        $("#eventClickUl").html ''
      $(".btnDelete").attr "href", "/event/delete/#{type}/#{event.id}"
      $(jsEvent.target).popover "show"
      $(".linkMove").click ->
        $.post("/event/move/#{type}/#{event.id}").done (data) ->
          $(".popover").remove()
          $("#calendar").fullCalendar "refetchEvents"
      false

    eventResize: (event, dayDelta, minuteDelta, revertFunc, jsEvent, ui, view) ->
      $.post("/event/drag",
        id: event.id
        eventType: calUrlToEventType event.source.url
        allDay: event.allDay
        startDate: event.start.getTime()
        endDate: event.end.getTime()
      ).done (data) ->
        console.log data

    eventDrop: (event, dayDelta, minuteDelta, allDay, revertFunc, jsEvent, ui, view) ->
      $.post("/event/drag",
        id: event.id
        eventType: calUrlToEventType event.source.url
        allDay: event.allDay
        startDate: event.start.getTime()
        endDate: event.end.getTime()
      ).done (data) ->
        console.log data

calUrlToEventType = (url) ->
  if url is "https://www.google.com/calendar/feeds/o776rmha219v92fvejs0hahsso%40group.calendar.google.com/private-6968d2f0aa2dee4823410b8e47fa040c/basic"
    "ACTION"
  else if url is "https://www.google.com/calendar/feeds/gehqh0ptgh0i2hkh3f1l4tlerg%40group.calendar.google.com/private-65a3820d5b7a4aa1ac390d21d85d93fc/basic"
    "INSTALLATION"
  else if url is "https://www.google.com/calendar/feeds/3jg1lna270kjsjb0jjrhhqo5m8%40group.calendar.google.com/private-57e4356bbde4ecb5ba981a2eedb4dd91/basic"
    "RESERVATION"
  else "SELFTRANSPORT"  if url is "https://www.google.com/calendar/feeds/hq8a7ru1eh0qoj7bpn05amtsg8%40group.calendar.google.com/private-14076798185cd1615e25439fbd969ae8/basic"



