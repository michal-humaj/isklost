$(document).ready ->
  $("#scroll-table").height $(window).height() - 450
  $("body").toggleClass "fixed"
  fix_sidebar()

  $(window).resize ->
    $("#scroll-table").height $(window).height() - 450

  $("body").on "hidden.bs.modal", ".modal", ->
    $(this).removeData "bs.modal"

  d = new Date()
  d.setHours 0,0,0,0
  loadEvents d

  $("#datepicker").datepicker(
    format: "mm.dd. yyyy"
    weekStart: 1
    todayBtn: true
    language: "sk"
    todayHighlight: true
  ).on "changeDate", (ev) ->
    return if typeof ev.date is "undefined"
    loadEvents ev.date

loadEvents = (d) ->
  $("#overlayEvents").attr "class", "overlay"
  $("#loadingEvents").attr "class", "loading-img"
  $("#overlayItems").attr "class", "overlay"
  $("#loadingItems").attr "class", "loading-img"
  $("#titleEvents").html "#{d.getDate()}.#{d.getMonth()+1}. #{d.getFullYear()} Udalosti"
  $("#titleItems").html "#{d.getDate()}.#{d.getMonth()+1}. #{d.getFullYear()} Dostupnosť položiek"
  $.get "/events/#{d.getTime()}", (events) ->
    $("#overlayEvents").attr "class", ""
    $("#loadingEvents").attr "class", ""
    $("#tableEvents").html ""
    $.each events, (index, e) ->
      if e.eventType is "ACTION"
        tr = $('<tr class="event" style="background-color: #92E1C0;">')
      else if e.eventType is "RESERVATION"
        tr = $('<tr class="event" style="background-color: #FAD165;">')
      else
        tr = $('<tr class="event" style="background-color: #CABDBF;">')
      tr.attr "eventType", e.eventType
      tr.attr "eventId", e.id
      tr.append $("<td>").text e.name
      tr.append $("<td>").text (if e.start is null then "" else e.start )
      tr.append $("<td>").text (if e.end is null then "" else e.end )
      tr.append $("<td>").html $("#availCalcGroup").html()
      $("#tableEvents").append tr
    $(".btnTimes").click (e) ->
      a = $(e.currentTarget.parentNode).find ".btnCheck"
      a.attr "class", "btn btn-default btnCheck"
      $(this).attr "class", "btn btn-danger disabled btnTimes"
      $("#overlayItems").attr "class", "overlay"
      $("#loadingItems").attr "class", "loading-img"
      loadAvailability()
    $(".btnCheck").click (e) ->
      a = $(e.currentTarget.parentNode).find ".btnTimes"
      a.attr "class", "btn btn-default btnTimes"
      $(this).attr "class", "btn btn-success disabled btnCheck"
      $("#overlayItems").attr "class", "overlay"
      $("#loadingItems").attr "class", "loading-img"
      loadAvailability()
    loadAvailability()

loadAvailability = ->
  types = new Array()
  ids = new Array()
  $(".event").each (i, obj) ->
    a = $(this).find ".btnCheck"
    s = a.attr "class"
    if s is "btn btn-success disabled btnCheck"
      types[i] = $(this).attr "eventtype"
      ids[i] = $(this).attr "eventid"
  $.post("/store/items",
    types: types
    ids: ids
  ).done (items) ->
    $("#scroll-table").html ""
    $.each items, (i, item) ->
      if item.available < 0
        tr = $('<tr class="bg-red">')
      else
        tr = $('<tr>')
      tr.attr "id", item.category
      tr.append $("<td style='width: 390px;'>").text item.name
      tr.append $('<td>').text item.available
      tr.append $('<td>').text item.reserved
      tr.append $('<td>').text item.rented
      $("#btnInc").attr "href", "/store/item/#{item.id}/inc"
      $("#linkDec").attr "href", "/store/item/#{item.id}/dec"
      $("#linkEdit").attr "href", "/store/item/#{item.id}"
      $("#linkDelete").attr "href", "/store/item/#{item.id}/delete"
      tr.append $("<td style='width: 133px;'>").html $("#itemManipulationBtnsDiv").html()
      $("#scroll-table").append tr
    $("#overlayItems").attr "class", ""
    $("#loadingItems").attr "class", ""
    $("#scroll-table").scrollspy target: "#scroll-target"

