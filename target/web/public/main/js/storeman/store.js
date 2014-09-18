(function() {
  $(document).ready(function() {
    $("#scroll-table").height($(window).height() - 450);
    $("body").toggleClass("fixed");
    fix_sidebar();
    $(window).resize(function() {
      return $("#scroll-table").height($(window).height() - 450);
    });
    $("body").on("hidden.bs.modal", ".modal", function() {
      return $(this).removeData("bs.modal");
    });
    return $("#scroll-table").scrollspy({
      target: "#scroll-target"
    });
  });

}).call(this);

//# sourceMappingURL=store.js.map
