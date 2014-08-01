$ ->
  $.get "/store/items/TABLES", (items) ->
    $.each items, (index, item) ->
      opt = $("<option>").text item.name
      opt.prop 'value', item.id
      $('#itemSelect').append opt

$("#categorySelect").change ->
  cat = this.options[this.selectedIndex].value
  $.get "/store/items/#{cat}", (items) ->
    $('#itemSelect').html ""
    $.each items, (index, item) ->
      opt = $("<option>").text item.name
      opt.prop 'value', item.id
      $('#itemSelect').append opt
