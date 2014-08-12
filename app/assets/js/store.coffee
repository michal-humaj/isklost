$(document).ready ->
  $("#scroll-table").height $(window).height() - 196
  $("body").toggleClass "fixed"
  fix_sidebar()

  $(window).resize ->
    $("#scroll-table").height $(window).height() - 196

  $("#scroll-table").scrollspy target: "#scroll-target"

  $("body").on "hidden.bs.modal", ".modal", ->
    $(this).removeData "bs.modal"

  $("#datepicker").datepicker
    format: "mm.dd. yyyy"
    weekStart: 1
    todayBtn: true
    language: "sk"
    todayHighlight: true