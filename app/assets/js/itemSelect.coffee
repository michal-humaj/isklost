$ ->
  loadItems document.getElementById("categorySelect0")

$("#addAccessory").click (e) ->
  template = $(".accessoryGroupTemplate")
  template.before '<tr class="accessoryGroup">' + template.html() + "</tr>"
  renumber()
  $(".accessoryGroup").find(".amountInput").each (i) ->
    $(this).attr "required", "true"
    $(this).attr "min", "1"
    $(this).attr "type", "number"
  $(".accessoryGroup").find(".itemSelect").each (i) ->
    $(this).attr "required", "true"
  $(".accessoryGroup").each (i) ->
    $(".categorySelect", this).each ->
      loadItems this

$("#form").submit ->
  $(".accessoryGroupTemplate").remove()