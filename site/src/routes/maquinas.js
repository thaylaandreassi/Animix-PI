var express = require("express");
var router = express.Router();

var maquinaController = require("../controllers/maquinaController");

router.get("/", function (req, res) {
    maquinaController.testar(req, res);
});

router.get("/listar", function (req, res) {
    maquinaController.listar(req, res);
});

router.get("/plotar/:fkStudio", function (req, res) {
    maquinaController.plotar(req, res);
});

router.get("/infosMaquina/:fkMaquina", function (req, res) {
    maquinaController.infosMaquina(req, res);
});

//Recebendo os dados do html e direcionando para a função cadastrar de usuarioController.js
router.post("/cadastrar", function (req, res) {
    maquinaController.cadastrar(req, res);
})

router.post("/autenticar", function (req, res) {
    maquinaController.entrar(req, res);
});


module.exports = router;