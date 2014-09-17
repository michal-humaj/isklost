(function() {
  var allDayChange, loadItems, renumber;

  $(document).ready(function() {
    if ($(".checked").length === 1) {
      $("#timeInputStart").hide();
      $("#timeInputEnd").hide();
    }
    $("#checkboxAllDay").click(function() {
      return allDayChange();
    });
    $(".iCheck-helper").click(function() {
      return allDayChange();
    });
    loadItems(document.getElementById("categorySelect0"));
    renumber();
    $("#addEntry").click(function(e) {
      var template;
      template = $(".entryGroupTemplate");
      template.before('<tr class="entryGroup">' + template.html() + "</tr>");
      renumber();
      $(".entryGroup").find(".amountInput").each(function(i) {
        $(this).attr("required", "true");
        $(this).attr("min", "1");
        return $(this).attr("type", "number");
      });
      $(".entryGroup").find(".itemSelect").each(function(i) {
        return $(this).attr("required", "true");
      });
      $(".entryGroup").each(function(i) {
        return $(".categorySelect", this).each(function() {
          return loadItems(this);
        });
      });
      $(".categorySelect").change(function(a) {
        return loadItems(a.currentTarget);
      });
      return $(".removeEntry").click(function(a) {
        a.currentTarget.parentNode.parentNode.remove();
        return renumber();
      });
    });
    $("#form").submit(function() {
      return $(".entryGroupTemplate").remove();
    });
    $(".removeEntry").click(function(e) {
      e.currentTarget.parentNode.parentNode.remove();
      return renumber();
    });
    return $(".categorySelect").change(function(e) {
      return loadItems(e.currentTarget);
    });
  });

  allDayChange = function() {
    var checked;
    checked = $(".icheckbox_minimal").attr('aria-checked');
    if (checked === 'true') {
      $("#timeInputStart").hide();
      return $("#timeInputEnd").hide();
    } else {
      $("#timeInputStart").show();
      return $("#timeInputEnd").show();
    }
  };

  renumber = function() {
    return $(".entryGroup").each(function(i) {
      $(".categorySelect", this).each(function() {
        $(this).attr("id", "categorySelect" + i);
        return $(this).attr("name", $(this).attr("name").replace(/entries\[.+?\]/g, "entries[" + i + "]"));
      });
      $(".itemSelect", this).each(function() {
        $(this).attr("name", $(this).attr("name").replace(/entries\[.+?\]/g, "entries[" + i + "]"));
        return $(this).attr("id", "itemSelect" + i);
      });
      return $(".amountInput", this).each(function() {
        return $(this).attr("name", $(this).attr("name").replace(/entries\[.+?\]/g, "entries[" + i + "]"));
      });
    });
  };

  loadItems = function(e) {
    var a, cat, itemSelect, selectedIndex;
    cat = e.options[e.selectedIndex].value;
    itemSelect = document.getElementById("itemSelect" + e.id.substr(14));
    selectedIndex = itemSelect.selectedIndex;
    $.get("/store/items/" + cat, function(items) {
      $("#itemSelect" + e.id.substr(14)).html("");
      $.each(items, function(index, item) {
        var opt;
        opt = $("<option>").text(item.name);
        opt.prop("value", item.id);
        return $("#itemSelect" + e.id.substr(14)).append(opt);
      });
      return itemSelect.selectedIndex = selectedIndex;
    });
    a = $(e.parentNode.parentNode).find(".amountInput");
    if (cat === "CARPETS") {
      a.attr("min", "0.01");
      return a.attr("step", "0.01");
    } else {
      a.attr("min", "1");
      return a.attr("step", "1");
    }
  };

}).call(this);

//# sourceMappingURL=event.js.map
