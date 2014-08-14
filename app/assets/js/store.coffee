$(document).ready ->
  $("#scroll-table").height $(window).height() - 450
  $("body").toggleClass "fixed"
  fix_sidebar()

  $(window).resize ->
    $("#scroll-table").height $(window).height() - 450

  $("#scroll-table").scrollspy target: "#scroll-target"

  $("body").on "hidden.bs.modal", ".modal", ->
    $(this).removeData "bs.modal"

  $("#datepicker").datepicker(
    format: "mm.dd. yyyy"
    weekStart: 1
    todayBtn: true
    language: "sk"
    todayHighlight: true
  ).on "changeDate", (ev) ->
    d = ev.date
    $("#titleEvents").html "#{d.getDate()}.#{d.getMonth()+1}. #{d.getFullYear()} Udalosti"
    $("#titleItems").html "#{d.getDate()}.#{d.getMonth()+1}. #{d.getFullYear()} Dostupnosť položiek"
    $.get "/events/#{d.getTime()}", (events) ->
      $.each events, (index, e) ->
        console.log e
