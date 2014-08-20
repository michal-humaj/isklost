$(document).ready ->
  $("#scroll-table").height $(window).height() - 450
  $("body").toggleClass "fixed"
  fix_sidebar()

  $(window).resize ->
    $("#scroll-table").height $(window).height() - 450

  $("body").on "hidden.bs.modal", ".modal", ->
    $(this).removeData "bs.modal"

  $("#scroll-table").scrollspy target: "#scroll-target"