var database = require("../database/config");

function buscarUltimasMedidas(idMaquina, limite_linhas) {

    instrucaoSql = ''

    if (process.env.AMBIENTE_PROCESSO == "producao") {
        instrucaoSql = `select top ${limite_linhas}
        usoCpu as processador,
        leitura as disco,
        escrita as escrita,
        usoMemoria as memoria,
                        momento,
                        FORMAT(momento, 'HH:mm:ss') as momento_grafico
                    from dados
                    where fkMaquina = ${idMaquina}
                    order by idDado desc`;
    } else if (process.env.AMBIENTE_PROCESSO == "desenvolvimento") {
        instrucaoSql = `select temperatura as temperatura, 
        porcentCPU as processador,
        leitura as leitura,
        escrita as escrita,
        porcentMemoria as memoria,
        time_format(horaCaptura, '%h:%m:%s') as momento_grafico
          from dados where fkMaquina = ${idMaquina}
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
        usoCpu as processador,
        leitura as leitura,
        escrita as escrita,
        usoMemoria as memoria,
                        CONVERT(varchar, momento, 108) as momento_grafico, 
                        fkMaquina 
                        from dados where fkMaquina = ${idMaquina} 
                    order by idDado desc`;

    } else if (process.env.AMBIENTE_PROCESSO == "desenvolvimento") {
        instrucaoSql = `select 
        porcentCPU as processador,
        porcentDisco as disco,
        porcentMemoria as memoria,
        time_format(horaCaptura, '%h:%m:%s') as momento_grafico
          from dados where fkMaquina = ${idMaquina}`;
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
