(function() {
  var loadItems, renumber;

  $(document).ready(function() {
    loadItems(document.getElementById("categorySelect0"));
    renumber();
    $("#addAccessory").click(function(e) {
      var template;
      template = $(".accessoryGroupTemplate");
      template.before('<tr class="accessoryGroup">' + template.html() + "</tr>");
      renumber();
      $(".accessoryGroup").find(".amountInput").each(function(i) {
        $(this).attr("required", "true");
        $(this).attr("min", "1");
        return $(this).attr("type", "number");
      });
      $(".accessoryGroup").find(".itemSelect").each(function(i) {
        return $(this).attr("required", "true");
      });
      $(".accessoryGroup").each(function(i) {
        return $(".categorySelect", this).each(function() {
          return loadItems(this);
        });
      });
      $(".categorySelect").change(function(a) {
        return loadItems(a.currentTarget);
      });
      return $(".removeAccessory").click(function(a) {
        a.currentTarget.parentNode.parentNode.remove();
        return renumber();
      });
    });
    $("#form").submit(function() {
      return $(".accessoryGroupTemplate").remove();
    });
    $(".removeAccessory").click(function(e) {
      e.currentTarget.parentNode.parentNode.remove();
      return renumber();
    });
    return $(".categorySelect").change(function(e) {
      return loadItems(e.currentTarget);
    });
  });

  renumber = function() {
    return $(".accessoryGroup").each(function(i) {
      $(".categorySelect", this).each(function() {
        $(this).attr("id", "categorySelect" + i);
        return $(this).attr("name", $(this).attr("name").replace(/accessories\[.+?\]/g, "accessories[" + i + "]"));
      });
      $(".itemSelect", this).each(function() {
        $(this).attr("name", $(this).attr("name").replace(/accessories\[.+?\]/g, "accessories[" + i + "]"));
        return $(this).attr("id", "itemSelect" + i);
      });
      return $(".amountInput", this).each(function() {
        return $(this).attr("name", $(this).attr("name").replace(/accessories\[.+?\]/g, "accessories[" + i + "]"));
      });
    });
  };

  loadItems = function(e) {
    var cat, itemSelect, selectedIndex;
    cat = e.options[e.selectedIndex].value;
    itemSelect = document.getElementById("itemSelect" + e.id.substr(14));
    selectedIndex = itemSelect.selectedIndex;
    return $.get("/store/items/" + cat, function(items) {
      $("#itemSelect" + e.id.substr(14)).html("");
      $.each(items, function(index, item) {
        var opt;
        opt = $("<option>").text(item.name);
        opt.prop("value", item.id);
        return $("#itemSelect" + e.id.substr(14)).append(opt);
      });
      return itemSelect.selectedIndex = selectedIndex;
    });
  };

}).call(this);

//# sourceMappingURL=tents.js.map
