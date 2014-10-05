$(document).ready ->

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
      }
      {
        url: INSTALLATIONS_URL
        color: INSTALLATIONS_COLOR
        borderColor: INSTALLATIONS_BORDER_COLOR
      }
      {
        url: RESERVATIONS_URL
        color: RESERVATIONS_COLOR
        borderColor: RESERVATIONS_BORDER_COLOR
      }
      {
        url: SELFTRANSPORTS_URL
        backgroundColor: SELFTRANSPORTS_COLOR
        borderColor: SELFTRANSPORTS_BORDER_COLOR
        borderColor: SELFTRANSPORTS_BORDER_COLOR
      }
    ]
    defaultView: "agendaWeek"
    firstDay: 1
    eventTextColor: EVENT_TEXT_COLOR
    eventClick: (event, jsEvent, view) ->
      type = calUrlToEventType event.source.url
      return false if type is "INSTALLATION"
      title = event.title.split "#"
      document.location.href = jsRoutes.controllers.Kalendar.storemanEdit(type, event.id, title[0]).url
      false

  $("#datepicker").datepicker(
    format: "mm.dd. yyyy"
    weekStart: 1
    todayBtn: true
    language: "sk"
    todayHighlight: true
  ).on "changeDate", (ev) ->
    date = ev.date
    $("#calendar").fullCalendar "gotoDate", date.getFullYear(), date.getMonth(), date.getDate()