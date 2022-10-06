var express = require("express");
var router = express.Router();

var cardsController = require("../controllers/cardsController");

// router.get("/ultimas/:idAquario", function (req, res) {
//     medidaController.buscarUltimasMedidas(req, res);
// });

router.get("/tempo-real/:idMaquina", function (req, res) {
    cardsController.buscarMedidasEmTempoReal(req, res);
})

module.exports = router;