var maquinaModel = require("../models/maquinaModel");

var sessoes = [];

function testar(req, res) {
    console.log("ENTRAMOS NA usuarioController");
    res.json("ESTAMOS FUNCIONANDO!");
}

function listar(req, res) {
    maquinaModel.listar()
        .then(function (resultado) {
            if (resultado.length > 0) {
                res.status(200).json(resultado);
            } else {
                res.status(204).send("Nenhum resultado encontrado!")
            }
        }).catch(
            function (erro) {
                console.log(erro);
                console.log("Houve um erro ao realizar a consulta! Erro: ", erro.sqlMessage);
                res.status(500).json(erro.sqlMessage);
            }
        );
}

function entrar(req, res) {
    var email = req.body.emailServer;
    var senha = req.body.senhaServer;

    if (email == undefined) {
        res.status(400).send("Seu email está undefined!");
    } else if (senha == undefined) {
        res.status(400).send("Sua senha está indefinida!");
    } else {
        
        maquinaModel.entrar(email, senha)
            .then(
                function (resultado) {
                    console.log(`\nResultados encontrados: ${resultado.length}`);
                    console.log(`Resultados: ${JSON.stringify(resultado)}`); // transforma JSON em String

                    if (resultado.length == 1) {
                        console.log(resultado);
                        res.json(resultado[0]);
                    } else if (resultado.length == 0) {
                        res.status(403).send("Email e/ou senha inválido(s)");
                    } else {
                        res.status(403).send("Mais de um usuário com o mesmo login e senha!");
                    }
                }
            ).catch(
                function (erro) {
                    console.log(erro);
                    console.log("\nHouve um erro ao realizar o login! Erro: ", erro.sqlMessage);
                    res.status(500).json(erro.sqlMessage);
                }
            );
    }

}

function cadastrar(req, res) {
    var discoIdeal = req.body.discoIdealServer;
    var memoriaIdeal = req.body.memoriaIdealServer;
    var processadorIdeal = req.body.processadorIdealServer;
    var monitoraDisco = req.body.monitoraDiscoServer;
    var monitoraMemoria = req.body.monitoraMemoriaServer;
    var monitoraProcessador = req.body.monitoraProcessadorServer;
    var fkStudio = req.body.fkStudioServer;

    // Faça as validações dos valores
    if (discoIdeal == undefined) {
        res.status(400).send("Seu usuario está undefined!");
    } else if (memoriaIdeal == undefined) {
        res.status(400).send("Seu email está undefined!");
    } else if (processadorIdeal == undefined) {
        res.status(400).send("Sua senha está undefined!");
    } else {
        
        maquinaModel.cadastrar(fkStudio, discoIdeal, memoriaIdeal, processadorIdeal,
         monitoraDisco, monitoraMemoria, monitoraProcessador)
            .then(
                function (resultado) {
                    res.json(resultado);
                }
            ).catch(
                function (erro) {
                    console.log(erro);
                    console.log(
                        "\nHouve um erro ao realizar o cadastro! Erro: ",
                        erro.sqlMessage
                    );
                    res.status(500).json(erro.sqlMessage);
                }
            );
    }
}

function plotar(req, res) {
     var fkStudio = req.params.fkStudio;
     console.log(fkStudio);

    maquinaModel.getMaquinas(fkStudio).then(
        function (resultado) {
            res.json(resultado)
        }
    ).catch(
        function (erro) {
            console.log(erro);
            console.log(
                "\nHouve um erro ao realizar o cadastro! Erro: ",
                erro.sqlMessage
            );
            res.status(500).json(erro.sqlMessage); 
        }
    )
}

function infosMaquina(req, res) {
    var fkMaquina = req.params.fkMaquina;

   maquinaModel.getMaquina(fkMaquina).then(
       function (resultado) {
           res.json(resultado)
       }
   ).catch(
       function (erro) {
           console.log(erro);
           console.log(
               "\nHouve um erro ao realizar o cadastro! Erro: ",
               erro.sqlMessage
           );
           res.status(500).json(erro.sqlMessage); 
       }
   )
}

module.exports = {
    entrar,
    cadastrar,
    listar,
    testar,
    plotar,
    infosMaquina
}