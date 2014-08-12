$(document).ready ->
  allDayChange()
  $("#jozo").click ->
    allDayChange()
  $(".iCheck-helper").click ->
    allDayChange()


allDayChange = ->
  checked = $(".icheckbox_minimal").attr 'aria-checked'
  if checked is 'true'
    $("#timeInputStart").hide()
    $("#timeInputEnd").hide()
  else
    $("#timeInputStart").show()
    $("#timeInputEnd").show()
