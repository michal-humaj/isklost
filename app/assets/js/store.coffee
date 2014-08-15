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
    return if typeof ev.date is "undefined"
    $("#overlayEvents").attr "class", "overlay"
    $("#loadingEvents").attr "class", "loading-img"
    $("#overlayItems").attr "class", "overlay"
    $("#loadingItems").attr "class", "loading-img"
    d = ev.date
    $("#titleEvents").html "#{d.getDate()}.#{d.getMonth()+1}. #{d.getFullYear()} Udalosti"
    $("#titleItems").html "#{d.getDate()}.#{d.getMonth()+1}. #{d.getFullYear()} Dostupnosť položiek"
    $.get "/events/#{d.getTime()}", (events) ->
      $("#overlayEvents").attr "class", ""
      $("#loadingEvents").attr "class", ""
      $("#tableEvents").html ""
      $.each events, (index, e) ->
        tr = $('<tr class="event">')
        tr.attr "eventType", e.eventType
        tr.attr "eventId", e.id
        tr.append $("<td>").text e.name
        tr.append $("<td>").text (if e.start is null then "" else e.start )
        tr.append $("<td>").text (if e.end is null then "" else e.end )
        tr.append $("<td>").html $("#availCalcGroup").html()
        $("#tableEvents").append tr
      loadAvailability()

loadAvailability = ->
  types = new Array()
  ids = new Array()
  $(".event").each (i, obj) ->
    types[i] = $(this).attr "eventtype"
    ids[i] = $(this).attr "eventid"
  $.post("/store/items",
    types: types
    ids: ids
  ).done (data) ->
    $("#overlayItems").attr "class", ""
    $("#loadingItems").attr "class", ""