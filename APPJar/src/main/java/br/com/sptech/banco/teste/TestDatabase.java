package br.com.sptech.banco.teste;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.discos.DiscoGrupo;
import oshi.SystemInfo;
import oshi.hardware.HardwareAbstractionLayer;
import com.github.britooo.looca.api.group.memoria.Memoria;
import com.github.britooo.looca.api.group.processador.Processador;
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

    public void Execut() {
        Connection connection = new Connection();
        JdbcTemplate con = connection.getConnection();
        Looca looca = new Looca();
        Conversor conversor = new Conversor();
        Date dataHoraAtual = new Date();
       
        // TempoAtiv
        Sistema sistema = new Sistema();
        Long sistemas = sistema.getTempoDeAtividade();
       
        // Temperatura:
       
        Temperatura temperatura = new Temperatura();
        Double temperaturaPC = temperatura.getTemperatura();
         
        // Disco
       
        DiscoGrupo disco = new DiscoGrupo();
        Long discoPC = disco.getDiscos().get(0).getBytesDeEscritas();
       
        // Processador
       
        Processador processadors = new Processador();
        Double processador = processadors.getUso();
       
        // Memória

        Memoria memoria = new Memoria();
        Long memoriaHard = memoria.getEmUso();

        //Date Time
        String data = new SimpleDateFormat("dd/MM/yyyy").format(dataHoraAtual);
        String Dt = new SimpleDateFormat("HH:mm:ss").format(dataHoraAtual);
       
        // Momento de Subida no banco Azure

        System.out.println("Ainda falta subir");
        
        con.execute("INSERT INTO dadosJar VALUES (null,'" + sistemas + "','"
                + temperaturaPC + "','" + discoPC + "','" + processador +
                "','" + memoriaHard + "','" + data + "','" + Dt + "')");
       
        System.out.println("Subiu");
    }

    String getTempoAtiv() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
