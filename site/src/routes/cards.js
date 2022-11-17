var express = require("express");
var router = express.Router();

var cardsController = require("../controllers/cardsController");


router.get("/tempo-real/:idMaquina", function (req, res) {
    cardsController.buscarMedidasEmTempoReal(req, res);
})
router.get("/tempo-real-kpi/:idMaquina", function (req, res) {
    cardsController.buscarKpiEmTempoReal(req, res);
})

module.exports = router;