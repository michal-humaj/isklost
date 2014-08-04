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
  $(".accessoryGroup").each (i) ->
    $(".categorySelect", this).each ->
      loadItems this

renumber = () ->
  $(".accessoryGroup").each (i) ->
    $(".categorySelect", this).each ->
      $(this).attr "id", "categorySelect" + i
    $(".itemSelect", this).each ->
      $(this).attr "name", $(this).attr("name").replace(/accessories\[.+?\]/g, "accessories[" + i + "]")
      $(this).attr "id", "itemSelect" + i
    $(".amountInput", this).each ->
      $(this).attr "name", $(this).attr("name").replace(/accessories\[.+?\]/g, "accessories[" + i + "]")

$("#form").submit ->
  $(".accessoryGroupTemplate").remove()