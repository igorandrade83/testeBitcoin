window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.Modais = window.blockly.js.blockly.Modais || {};

/**
 * Modais
 */
window.blockly.js.blockly.Modais.AbrirTransferencia = function() {
 var item;
  this.cronapi.screen.showModal("modalTransferencia");
  this.cronapi.screen.notify('warning','5455');
  this.cronapi.screen.changeValueOfField("vars.input-nomeCarteira", 'lalal');
}
