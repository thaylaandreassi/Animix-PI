var database = require("../database/config");

function buscarUltimasMedidas(idMaquina, limite_linhas) {

    instrucaoSql = ''

    if (process.env.AMBIENTE_PROCESSO == "producao") {
        instrucaoSql = `select top ${limite_linhas}
        temperatura as temperatura, 
        usoCpu as processador,
        usoDisco as disco,
        usoMemoria as memoria,
                        horaCaptura,
                        FORMAT(horaCaptura, 'HH:mm:ss') as momento_grafico
                    from dados
                    where idMaquina = ${idMaquina}
                    order by idDados desc`;
    } else if (process.env.AMBIENTE_PROCESSO == "desenvolvimento") {
        instrucaoSql = `select temperatura as temperatura, 
        porcentCPU as processador,
        porcentDisco as disco,
        porcentMemoria as memoria,
        time_format(horaCaptura, '%h:%m:%s') as momento_grafico
          from dados where idMaquina = ${idMaquina}
                    order by idDados desc limit ${limite_linhas}`;
    } else {
        console.log("\nO AMBIENTE (produção OU desenvolvimento) NÃO FOI DEFINIDO EM app.js\n");
        return
    }

    console.log("Executando a instrução SQL: \n" + instrucaoSql);
    return database.executar(instrucaoSql);
}

function buscarMedidasEmTempoReal(idMaquina) {

    instrucaoSql = ''

    if (process.env.AMBIENTE_PROCESSO == "producao") {
        instrucaoSql = `select top 1
        temperatura as temperatura, 
        usoCpu as processador,
        usoDisco as disco,
        usoMemoria as memoria,
                        CONVERT(varchar, horaCaptura, 108) as momento_grafico, 
                        idMaquina 
                        from dados where idMaquina = ${idMaquina} 
                    order by idDados desc`;

    } else if (process.env.AMBIENTE_PROCESSO == "desenvolvimento") {
        instrucaoSql = `select temperatura as temperatura, 
        porcentCPU as processador,
        porcentDisco as disco,
        porcentMemoria as memoria,
        time_format(horaCaptura, '%h:%m:%s') as momento_grafico
          from dados where idMaquina = ${idMaquina}`;
    } else {
        console.log("\nO AMBIENTE (produção OU desenvolvimento) NÃO FOI DEFINIDO EM app.js\n");
        return
    }

    console.log("Executando a instrução SQL: \n" + instrucaoSql);
    return database.executar(instrucaoSql);
}


module.exports = {
    buscarUltimasMedidas,
    buscarMedidasEmTempoReal
}
