(function() {
  var loadAvailability, loadEvents;

  $(document).ready(function() {
    var d;
    $("#scroll-table").height($(window).height() - 450);
    $("body").toggleClass("fixed");
    fix_sidebar();
    $(window).resize(function() {
      return $("#scroll-table").height($(window).height() - 450);
    });
    $("body").on("hidden.bs.modal", ".modal", function() {
      return $(this).removeData("bs.modal");
    });
    d = new Date();
    d.setHours(0, 0, 0, 0);
    loadEvents(d);
    return $("#datepicker").datepicker({
      format: "mm.dd. yyyy",
      weekStart: 1,
      todayBtn: true,
      language: "sk",
      todayHighlight: true
    }).on("changeDate", function(ev) {
      if (typeof ev.date === "undefined") {
        return;
      }
      return loadEvents(ev.date);
    });
  });

  loadEvents = function(d) {
    $("#overlayEvents").attr("class", "overlay");
    $("#loadingEvents").attr("class", "loading-img");
    $("#overlayItems").attr("class", "overlay");
    $("#loadingItems").attr("class", "loading-img");
    $("#titleEvents").html("" + (d.getDate()) + "." + (d.getMonth() + 1) + ". " + (d.getFullYear()) + " Udalosti");
    $("#titleItems").html("" + (d.getDate()) + "." + (d.getMonth() + 1) + ". " + (d.getFullYear()) + " Dostupnosť položiek");
    return $.get("/events/" + (d.getTime()), function(events) {
      $("#overlayEvents").attr("class", "");
      $("#loadingEvents").attr("class", "");
      $("#tableEvents").html("");
      $.each(events, function(index, e) {
        var tr;
        if (e.eventType === "ACTION") {
          tr = $('<tr class="event" style="background-color: #92E1C0;">');
        } else if (e.eventType === "RESERVATION") {
          tr = $('<tr class="event" style="background-color: #FAD165;">');
        } else {
          tr = $('<tr class="event" style="background-color: #CABDBF;">');
        }
        tr.attr("eventType", e.eventType);
        tr.attr("eventId", e.id);
        tr.append($("<td>").text(e.name));
        tr.append($("<td>").text((e.start === null ? "" : e.start)));
        tr.append($("<td>").text((e.end === null ? "" : e.end)));
        tr.append($("<td>").html($("#availCalcGroup").html()));
        return $("#tableEvents").append(tr);
      });
      $(".btnTimes").click(function(e) {
        var a;
        a = $(e.currentTarget.parentNode).find(".btnCheck");
        a.attr("class", "btn btn-default btnCheck");
        $(this).attr("class", "btn btn-danger disabled btnTimes");
        $("#overlayItems").attr("class", "overlay");
        $("#loadingItems").attr("class", "loading-img");
        return loadAvailability();
      });
      $(".btnCheck").click(function(e) {
        var a;
        a = $(e.currentTarget.parentNode).find(".btnTimes");
        a.attr("class", "btn btn-default btnTimes");
        $(this).attr("class", "btn btn-success disabled btnCheck");
        $("#overlayItems").attr("class", "overlay");
        $("#loadingItems").attr("class", "loading-img");
        return loadAvailability();
      });
      return loadAvailability();
    });
  };

  loadAvailability = function() {
    var ids, types;
    types = new Array();
    ids = new Array();
    $(".event").each(function(i, obj) {
      var a, s;
      a = $(this).find(".btnCheck");
      s = a.attr("class");
      if (s === "btn btn-success disabled btnCheck") {
        types[i] = $(this).attr("eventtype");
        return ids[i] = $(this).attr("eventid");
      }
    });
    return $.post("/store/items", {
      types: types,
      ids: ids
    }).done(function(items) {
      $("#scroll-table").html("");
      $.each(items, function(i, item) {
        var tr;
        if (item.available < 0) {
          tr = $('<tr class="bg-red">');
        } else {
          tr = $('<tr>');
        }
        tr.attr("id", item.category);
        tr.append($("<td style='width: 390px;'>").text(item.name));
        tr.append($('<td>').text(item.available));
        tr.append($('<td>').text(item.reserved));
        tr.append($('<td>').text(item.rented));
        $("#btnInc").attr("href", "/store/item/" + item.id + "/inc");
        $("#linkDec").attr("href", "/store/item/" + item.id + "/dec");
        $("#linkEdit").attr("href", "/store/item/" + item.id);
        $("#linkDelete").attr("href", "/store/item/" + item.id + "/delete");
        tr.append($("<td style='width: 133px;'>").html($("#itemManipulationBtnsDiv").html()));
        return $("#scroll-table").append(tr);
      });
      $("#overlayItems").attr("class", "");
      $("#loadingItems").attr("class", "");
      return $("#scroll-table").scrollspy({
        target: "#scroll-target"
      });
    });
  };

}).call(this);

//# sourceMappingURL=store.js.map
