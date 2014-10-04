$(document).ready ->
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
        url: ACTIONS_URL
        color: ACTIONS_COLOR
        borderColor: ACTIONS_BORDER_COLOR
        editable: true
      }
      {
        url: INSTALLATIONS_URL
        color: INSTALLATIONS_COLOR
        borderColor: INSTALLATIONS_BORDER_COLOR
        editable: true
      }
      {
        url: RESERVATIONS_URL
        color: RESERVATIONS_COLOR
        borderColor: RESERVATIONS_BORDER_COLOR
        editable: true
      }
      {
        url: SELFTRANSPORTS_URL
        backgroundColor: SELFTRANSPORTS_COLOR
        borderColor: SELFTRANSPORTS_BORDER_COLOR
        editable: true
      }
    ]
    defaultView: "agendaWeek"
    firstDay: 1
    selectable: true
    selectHelper: true
    eventTextColor: EVENT_TEXT_COLOR
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
      $(".selectEventType").change (e) ->
        s = e.currentTarget
        eventType = s.options[s.selectedIndex].value
        if eventType is 'INSTALLATION'
          jsRoutes.controllers.Kalendar.upcomingActions().ajax
            success: (events) ->
              $(".selectAction").html '<option class="blank" value="">-- Priradená akcia --</option>'
              $.each events, (index, event) ->
                opt = $("<option>").text(event.name)
                opt.prop "value", event.id
                $(".selectAction").append opt
              $(".selectActionContainer").html $("#selectActionGroup").html()
        else
          $(".selectActionContainer").html ""

    unselect: (view, jsEvent) ->
      $(".popover").remove()
      $(".selectActionContainer").html ""

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
        $("#eventClickUl").html '<li><a class="linkMove" href="#" >Zmenit na rezervaciu</a></li><li><a href="' + jsRoutes.controllers.Kalendar.priceOffer(type, event.id).url + '">Cenova ponuka</a></li>'
      if type is "RESERVATION"
        $("#eventClickUl").html '<li><a class="linkMove" href="#">Zmenit na akciu</a></li><li><a href="' + jsRoutes.controllers.Kalendar.priceOffer(type, event.id).url + '">Cenova ponuka</a></li>'
      if type is "SELFTRANSPORT"
        $("#eventClickUl").html '<li><a href="' + jsRoutes.controllers.Kalendar.priceOffer(type, event.id).url + '">Cenova ponuka</a></li>'
      if type is "INSTALLATION"
        $("#eventClickUl").html ''
      $(".btnDelete").attr "href", jsRoutes.controllers.Kalendar.deleteModal(type, event.id).url
      $(jsEvent.target).popover "show"
      $(".linkMove").click ->
        jsRoutes.controllers.Kalendar.move(type, event.id).ajax
          success: (events) ->
            $(".popover").remove()
            $("#calendar").fullCalendar "refetchEvents"

      $(".btnEdit").attr "href", jsRoutes.controllers.Kalendar.edit(type, event.id).url
      false

    eventResize: (event, dayDelta, minuteDelta, revertFunc, jsEvent, ui, view) ->
      drag event

    eventDrop: (event, dayDelta, minuteDelta, allDay, revertFunc, jsEvent, ui, view) ->
      drag event

  $("#datepicker").datepicker(
    format: "mm.dd. yyyy"
    weekStart: 1
    todayBtn: true
    language: "sk"
    todayHighlight: true
  ).on "changeDate", (ev) ->
    date = ev.date
    $("#calendar").fullCalendar "gotoDate", date.getFullYear(), date.getMonth(), date.getDate()

# function to handle resize and drag and drop events
drag = (event) ->
  jsRoutes.controllers.Kalendar.drag().ajax
    data:
      id: event.id
      eventType: calUrlToEventType event.source.url
      allDay: event.allDay
      startDate: event.start.getTime()
      endDate: event.end.getTime()
    success: (data) ->
      console.log data
    error: (data) ->
      console.log  "error"