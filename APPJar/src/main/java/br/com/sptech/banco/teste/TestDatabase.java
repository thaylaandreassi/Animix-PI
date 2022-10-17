package br.com.sptech.banco.teste;

import com.github.britooo.looca.api.core.Looca;
import oshi.SystemInfo;
import oshi.hardware.HardwareAbstractionLayer;
import com.github.britooo.looca.api.group.memoria.Memoria;
import com.github.britooo.looca.api.group.sistema.Sistema;
import com.github.britooo.looca.api.group.temperatura.Temperatura;
import com.github.britooo.looca.api.util.Conversor;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.lang.ProcessBuilder.Redirect.Type;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class TestDatabase {

    Connection connection = new Connection();
    JdbcTemplate con = connection.getConnection();
    Looca looca = new Looca();
    Conversor conversor = new Conversor();

    public void Execut() {
        Date dataHoraAtual = new Date();
        // Temperatura:

       

        // PorcentCPU e BytesEmEscrita:

        Double porcentCPU = 0.0;

        Long porcentDisco = null;

//        porcentCPU = looca.getGrupoDeProcessos().getProcessos().get(0).getUsoCpu();
//        porcentDisco = looca.getGrupoDeDiscos().getDiscos().get(0).getTamanho();

        // TempoAtiv
        Sistema sistema = new Sistema();

        String sistemas = null;
        sistemas = conversor.formatarSegundosDecorridos(sistema.getTempoDeAtividade());

        Memoria memoria = new Memoria();

        String memorias = null;
        memorias = Conversor.formatarBytes(memoria.getEmUso());

        //Date Time
        String data = new SimpleDateFormat("dd/MM/yyyy").format(dataHoraAtual);
        String hora = new SimpleDateFormat("HH:mm:ss").format(dataHoraAtual);

        // Momento de Subida no banco
        String insertStatement = "INSERT INTO dados VALUES (null,?,?,?,?)";
        con.update(insertStatement, 
                sistemas, memorias, hora, data);

        // Retorno do Banco de dados
        List<dadosJar> onlyFireType = con.query("SELECT * FROM Dados",
                new BeanPropertyRowMapper(dadosJar.class));

        // Exibição
        for (dadosJar dados : onlyFireType) {
            System.out.println("\n Tempo de Atividade: \n" + dados.getTempoAtiv()
                    + "\n Memoria em Uso: " + dados.getMemoriaHard()
                    + "\n Data: " + dados.getDt()
                    + "\n Hora: " + dados.getHora()
            );
        }
    }
}
