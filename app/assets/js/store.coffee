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
    return if ev.date.getTime() < d.getTime()
    loadEvents ev.date

loadEvents = (d) ->
  $("#overlayEvents").attr "class", "overlay"
  $("#loadingEvents").attr "class", "loading-img"
  $("#overlayItems").attr "class", "overlay"
  $("#loadingItems").attr "class", "loading-img"
  $("#titleEvents").html "#{d.getDate()}.#{d.getMonth()+1}. #{d.getFullYear()} Udalosti"
  $("#titleItems").html "#{d.getDate()}.#{d.getMonth()+1}. #{d.getFullYear()} Dostupnosť položiek"

  jsRoutes.controllers.Kalendar.toDateEvents(d.getTime()).ajax
    success: (events) ->
      $("#overlayEvents").attr "class", ""
      $("#loadingEvents").attr "class", ""
      $("#tableEvents").html ""
      $.each events, (index, e) ->
        tr = $('<tr class="event" >')
        tr.attr "eventType", e.eventType
        tr.attr "eventId", e.id
        if e.eventType is "ACTION"
          tr.append $("<td>").html "<span class='badge' style='background-color: " + ACTIONS_COLOR + "; color: #000000;' >#{e.name}</span>"
        else if e.eventType is "RESERVATION"
          tr.append $("<td>").html "<span class='badge' style='background-color: " + RESERVATIONS_COLOR + "; color: #000000;'>#{e.name}</span>"
        else
          tr.append $("<td>").html "<span class='badge' style='background-color: " + SELFTRANSPORTS_COLOR + "; color: #000000;'>#{e.name}</span>"
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
      jsRoutes.controllers.Kalendar.sinceNowToDateEvents(d.getTime()).ajax
        success: (events) ->
          $.each events, (index, e) ->
            tr = $('<tr class="eventSinceNow" >')
            tr.attr "eventType", e.eventType
            tr.attr "eventId", e.id
            $("#tableEvents").append tr
          loadAvailability()


loadAvailability = ->
  console.log "load availability"
  types = new Array()
  ids = new Array()
  $(".event").each (i, obj) ->
    a = $(this).find ".btnCheck"
    s = a.attr "class"
    if s is "btn btn-success disabled btnCheck"
      types[i] = $(this).attr "eventtype"
      ids[i] = $(this).attr "eventid"
  jsRoutes.controllers.Store.availability().ajax
    data:
      types: types
      ids: ids
    success: (items) ->
      $("#scroll-table").html ""
      $.each items, (i, item) ->
        appendItemRow i, item
      typesSinceNow = new Array()
      idsSinceNow = new Array()
      $(".eventSinceNow").each (i, obj) ->
        typesSinceNow[i] = $(this).attr "eventtype"
        idsSinceNow[i] = $(this).attr "eventid"
      jsRoutes.controllers.Store.carpetsPbAvailability().ajax
        data:
          types: typesSinceNow.concat types
          ids: idsSinceNow.concat ids
        success: (carpets) ->
          $.each carpets, (i, carpet) ->
            appendItemRow i, carpet
          $("#overlayItems").attr "class", ""
          $("#loadingItems").attr "class", ""
          $("#scroll-table").scrollspy target: "#scroll-target"

appendItemRow = (i, item) ->
  if item.available < 0
    tr = $('<tr class="bg-red">')
  else
    tr = $('<tr>')
  tr.attr "id", item.category
  tr.append $("<td style='width: 390px;'>").text item.name
  tr.append $('<td>').text item.available
  tr.append $('<td>').text item.reserved
  tr.append $('<td>').text item.rented
  $("#btnInc").attr "href", jsRoutes.controllers.Store.increaseModal(item.id).url
  $("#linkDec").attr "href", jsRoutes.controllers.Store.decreaseModal(item.id).url
  $("#linkEdit").attr "href", jsRoutes.controllers.Store.editModal(item.id).url
  $("#linkDelete").attr "href", jsRoutes.controllers.Store.deleteModal(item.id).url
  tr.append $("<td style='width: 133px;'>").html $("#itemManipulationBtnsDiv").html()
  $("#scroll-table").append tr


