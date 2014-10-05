$(document).ready ->
  loadItems document.getElementById("categorySelect0")
  renumber ".accessoryGroup", "accessories"

  $("#addAccessory").click (e) ->
    template = $(".accessoryGroupTemplate")
    template.before '<tr class="accessoryGroup">' + template.html() + "</tr>"
    renumber ".accessoryGroup", "accessories"
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
      renumber ".accessoryGroup", "accessories"

  $("#form").submit ->
    $(".accessoryGroupTemplate").remove()

  $(".removeAccessory").click (e) ->
    e.currentTarget.parentNode.parentNode.remove()
    renumber ".accessoryGroup", "accessories"

  $(".categorySelect").change (e) ->
    loadItems e.currentTarget