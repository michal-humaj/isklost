$("#addAccessory").click (e) ->
  template = $(".accessoryGroupTemplate")
  template.before '<tr class="accessoryGroup">' + template.html() + "</tr>"
  renumber()

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