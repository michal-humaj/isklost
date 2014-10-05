$(document).ready ->
  if $(".checked").length is 1
    $("#timeInputStart").hide()
    $("#timeInputEnd").hide()

  $("#checkboxAllDay").click ->
    allDayChange()

  $(".iCheck-helper").click ->
    allDayChange()

  loadItems document.getElementById("categorySelect0")
  renumber();

  $("#addEntry").click (e) ->
    template = $(".entryGroupTemplate")
    template.before '<tr class="entryGroup">' + template.html() + "</tr>"
    renumber()
    $(".entryGroup").find(".amountInput").each (i) ->
      $(this).attr "required", "true"
      $(this).attr "min", "1"
      $(this).attr "type", "number"
    $(".entryGroup").find(".itemSelect").each (i) ->
      $(this).attr "required", "true"
    $(".entryGroup").each (i) ->
      $(".categorySelect", this).each ->
        loadItems this
    $(".categorySelect").change (a) ->
      loadItems a.currentTarget
    $(".removeEntry").click (a) ->
      a.currentTarget.parentNode.parentNode.remove()
      renumber();

  $("#form").submit ->
    $(".entryGroupTemplate").remove()

  $(".removeEntry").click (e) ->
    e.currentTarget.parentNode.parentNode.remove()
    renumber();

  $(".categorySelect").change (e) ->
    loadItems e.currentTarget

allDayChange = ->
  checked = $(".icheckbox_minimal").attr 'aria-checked'
  if checked is 'true'
    $("#timeInputStart").hide()
    $("#timeInputEnd").hide()
  else
    $("#timeInputStart").show()
    $("#timeInputEnd").show()

renumber = ->
  $(".entryGroup").each (i) ->
    $(".categorySelect", this).each ->
      $(this).attr "id", "categorySelect" + i
      $(this).attr "name", $(this).attr("name").replace(/entries\[.+?\]/g, "entries[" + i + "]")

    $(".itemSelect", this).each ->
      $(this).attr "name", $(this).attr("name").replace(/entries\[.+?\]/g, "entries[" + i + "]")
      $(this).attr "id", "itemSelect" + i

    $(".amountInput", this).each ->
      $(this).attr "name", $(this).attr("name").replace(/entries\[.+?\]/g, "entries[" + i + "]")



