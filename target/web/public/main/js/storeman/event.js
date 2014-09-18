(function() {
  var renumber;

  $(document).ready(function() {
    renumber();
    $("#addEntry").click(function(e) {
      var itemSelect, template;
      template = $(".entryGroupTemplate");
      itemSelect = template.find("#itemSelect0");
      itemSelect.html("");
      return $.get("/store/items/CARPETS", function(items) {
        $.each(items, function(index, item) {
          var opt;
          opt = $("<option>").text(item.name);
          opt.prop("value", item.id);
          return itemSelect.append(opt);
        });
        template.before('<tr class="entryGroup">' + template.html() + "</tr>");
        renumber();
        $(".entryGroup").find(".amountInput").each(function(i) {
          $(this).attr("required", "true");
          $(this).attr("min", "0.01");
          $(this).attr("step", "0.01");
          return $(this).attr("type", "number");
        });
        $(".entryGroup").find(".itemSelect").each(function(i) {
          return $(this).attr("required", "true");
        });
        return $(".removeEntry").click(function(a) {
          a.currentTarget.parentNode.parentNode.remove();
          return renumber();
        });
      });
    });
    $("#form").submit(function() {
      return $(".entryGroupTemplate").remove();
    });
    return $(".removeEntry").click(function(e) {
      e.currentTarget.parentNode.parentNode.remove();
      return renumber();
    });
  });

  renumber = function() {
    return $(".entryGroup").each(function(i) {
      $(".itemSelect", this).each(function() {
        $(this).attr("name", $(this).attr("name").replace(/entries\[.+?\]/g, "entries[" + i + "]"));
        return $(this).attr("id", "itemSelect" + i);
      });
      return $(".amountInput", this).each(function() {
        return $(this).attr("name", $(this).attr("name").replace(/entries\[.+?\]/g, "entries[" + i + "]"));
      });
    });
  };

}).call(this);

//# sourceMappingURL=event.js.map
