module.exports.register = function(Handlebars, options, params)  {
  Handlebars.registerHelper('onMenuItem', function(menuItem, selectedMenuItem) {
    return menuItem === selectedMenuItem ? 'active' : '';
  });
};