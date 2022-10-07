var express = require("express");
var router = express.Router();

var graficosController = require("../controllers/graficosController");

router.get("/ultimas/:idMaquina", function (req, res) {
    graficosController.buscarUltimasMedidas(req, res);
});

router.get("/tempo-real/:idMaquina", function (req, res) {
    graficosController.buscarMedidasEmTempoReal(req, res);
})

module.exports = router;