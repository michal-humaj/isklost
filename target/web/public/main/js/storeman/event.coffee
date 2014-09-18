$(document).ready ->
  renumber();

  $("#addEntry").click (e) ->
    template = $(".entryGroupTemplate")
    itemSelect = template.find("#itemSelect0")
    itemSelect.html ""
    $.get "/store/items/CARPETS", (items) ->
      $.each items, (index, item) ->
        opt = $("<option>").text(item.name)
        opt.prop "value", item.id
        itemSelect.append opt
      template.before '<tr class="entryGroup">' + template.html() + "</tr>"
      renumber()
      $(".entryGroup").find(".amountInput").each (i) ->
        $(this).attr "required", "true"
        $(this).attr "min", "0.01"
        $(this).attr "step", "0.01"
        $(this).attr "type", "number"
      $(".entryGroup").find(".itemSelect").each (i) ->
        $(this).attr "required", "true"
      $(".removeEntry").click (a) ->
        a.currentTarget.parentNode.parentNode.remove()
        renumber()


  $("#form").submit ->
    $(".entryGroupTemplate").remove()

  $(".removeEntry").click (e) ->
    e.currentTarget.parentNode.parentNode.remove()
    renumber()

renumber = ->
  $(".entryGroup").each (i) ->
    $(".itemSelect", this).each ->
      $(this).attr "name", $(this).attr("name").replace(/entries\[.+?\]/g, "entries[" + i + "]")
      $(this).attr "id", "itemSelect" + i
    $(".amountInput", this).each ->
      $(this).attr "name", $(this).attr("name").replace(/entries\[.+?\]/g, "entries[" + i + "]")

