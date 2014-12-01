// console.log fallback
if(typeof window.console === "undefined") {
  window.console = {
    log: function () {
    }
  };
}