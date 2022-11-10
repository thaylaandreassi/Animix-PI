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
        SELECT * FROM funcionario WHERE email = '${email}' AND senha = '${senha}';
    `;
    console.log("Executando a instrução SQL: \n" + instrucao);
    return database.executar(instrucao);
}

// Coloque os mesmos parâmetros aqui. Vá para a var instrucao
function cadastrar(nome, telefone, logradouro, cnpj, email, senha) {
    var instrucao = `
    INSERT INTO studio (nomeEmpresa, email, senha, logradouro, telefone, CNPJ ) VALUES ('${nome}', '${email}', '${senha}', '${logradouro}', '${telefone}', '${cnpj}');`;
    console.log("Executando a instrução SQL: \n" + instrucao);
    return database.executar(instrucao);
}

function cadastrarAdmin(nome, email, senha, fkStudio) {
    var instrucao = `INSERT INTO funcionario (cargo, nome, email, senha, fkStudio)VALUES ('Admin', '${nome}', '${email}', '${senha}', '${fkStudio}');`
    return database.executar(instrucao);
}
function getFkStudio(){
    var instrucao = `select top 1 idStudio as fkStudio from studio order by idStudio desc;`
    return database.executar(instrucao);
}

module.exports = {
    entrar,
    cadastrar,
    listar,
    cadastrarAdmin,
    getFkStudio
};