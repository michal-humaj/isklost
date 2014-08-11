$ ->
  loadItems document.getElementById("categorySelect0")
  renumber();

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
    $(".categorySelect").change (a) ->
      loadItems a.currentTarget
    $(".removeAccessory").click (a) ->
      a.currentTarget.parentNode.parentNode.remove()
      renumber();

  $("#form").submit ->
    $(".accessoryGroupTemplate").remove()

  $(".removeAccessory").click (e) ->
    e.currentTarget.parentNode.parentNode.remove()
    renumber();

  $(".categorySelect").change (e) ->
    loadItems e.currentTarget

renumber = ->
  $(".accessoryGroup").each (i) ->
    $(".categorySelect", this).each ->
      $(this).attr "id", "categorySelect" + i
      $(this).attr "name", $(this).attr("name").replace(/accessories\[.+?\]/g, "accessories[" + i + "]")

    $(".itemSelect", this).each ->
      $(this).attr "name", $(this).attr("name").replace(/accessories\[.+?\]/g, "accessories[" + i + "]")
      $(this).attr "id", "itemSelect" + i

    $(".amountInput", this).each ->
      $(this).attr "name", $(this).attr("name").replace(/accessories\[.+?\]/g, "accessories[" + i + "]")

loadItems = (e) ->
  cat = e.options[e.selectedIndex].value
  itemSelect = document.getElementById("itemSelect" + e.id.substr(14))
  selectedIndex = itemSelect.selectedIndex
  $.get "/store/items/" + cat, (items) ->
    $("#itemSelect" + e.id.substr(14)).html ""
    $.each items, (index, item) ->
      opt = $("<option>").text(item.name)
      opt.prop "value", item.id
      $("#itemSelect" + e.id.substr(14)).append opt
    itemSelect.selectedIndex = selectedIndex





