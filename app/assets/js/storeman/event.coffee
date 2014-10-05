$(document).ready ->
  renumber ".entryGroup", "entries"

  $("#addEntry").click (e) ->
    template = $(".entryGroupTemplate")
    itemSelect = template.find("#itemSelect0")
    itemSelect.html ""
    jsRoutes.controllers.Store.listInCategory("CARPETS").ajax
      success: (items) ->
        $.each items, (index, item) ->
          opt = $("<option>").text(item.name)
          opt.prop "value", item.id
          itemSelect.append opt
        template.before '<tr class="entryGroup">' + template.html() + "</tr>"
        renumber ".entryGroup", "entries"
        $(".entryGroup").find(".amountInput").each (i) ->
          $(this).attr "required", "true"
          $(this).attr "min", "0.01"
          $(this).attr "step", "0.01"
          $(this).attr "type", "number"
        $(".entryGroup").find(".itemSelect").each (i) ->
          $(this).attr "required", "true"
        $(".removeEntry").click (a) ->
          a.currentTarget.parentNode.parentNode.remove()
          renumber ".entryGroup", "entries"


  $("#form").submit ->
    $(".entryGroupTemplate").remove()

  $(".removeEntry").click (e) ->
    e.currentTarget.parentNode.parentNode.remove()
    renumber ".entryGroup", "entries"