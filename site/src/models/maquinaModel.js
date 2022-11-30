var database = require("../database/config")

function listar() {
    console.log("ACESSEI O USUARIO MODEL \n \n\t\t >> Se aqui der erro de 'Error: connect ECONNREFUSED',\n \t\t >> verifique suas credenciais de acesso ao banco\n \t\t >> e se o servidor de seu BD está rodando corretamente. \n\n function listar()");
    var instrucao = `
        SELECT * FROM usuario;
    `;
    console.log("Executando a instrução SQL: \n" + instrucao);
    return database.executar(instrucao);
}

function entrar(email, senha) {
    console.log("ACESSEI O USUARIO MODEL \n \n\t\t >> Se aqui der erro de 'Error: connect ECONNREFUSED',\n \t\t >> verifique suas credenciais de acesso ao banco\n \t\t >> e se o servidor de seu BD está rodando corretamente. \n\n function entrar(): ", email, senha)
    var instrucao = `
        SELECT * FROM cadastro WHERE email = '${email}' AND senha = '${senha}';
    `;
    console.log("Executando a instrução SQL: \n" + instrucao);
    return database.executar(instrucao);
}

// Coloque os mesmos parâmetros aqui. Vá para a var instrucao
function cadastrar(fkStudio, discoIdeal, memoriaIdeal, processadorIdeal,
     monitoraDisco, monitoraMemoria, monitoraProcessador) {
    var instrucao = `
        INSERT INTO maquinas (fkStudio, memoriaIdeal, discoIdeal, processamentoIdeal, monitoraDisco, monitoraProcessador,  monitoraMemoria) VALUES 
        ('${fkStudio}',   '${memoriaIdeal}', '${discoIdeal}', '${processadorIdeal}', '${monitoraDisco}', '${monitoraProcessador}', '${monitoraMemoria}');
    `;
    console.log("Executando a instrução SQL: \n" + instrucao);
    return database.executar(instrucao);
}

function getMaquinas(fkStudio) {
    var instrucao = `select * from maquinas where fkStudio = ${fkStudio} order by CASE WHEN situacao IS NULL THEN 3 END, situacao ;`
    return database.executar(instrucao);
}

function getMaquina(fkMaquina) {
    var instrucao = `select * from maquinas where idMaquina = ${fkMaquina}`
    return database.executar(instrucao);
}

module.exports = {
    entrar,
    cadastrar,
    listar,
    getMaquinas,
    getMaquina
};