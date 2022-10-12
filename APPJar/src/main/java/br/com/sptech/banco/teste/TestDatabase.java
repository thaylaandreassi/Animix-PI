package br.com.sptech.banco.teste;

import com.github.britooo.looca.api.core.Looca;
import oshi.SystemInfo;
import oshi.hardware.HardwareAbstractionLayer;
import com.github.britooo.looca.api.group.memoria.Memoria;
import com.github.britooo.looca.api.group.processos.Processo;
import com.github.britooo.looca.api.group.processos.ProcessoGrupo;
//import com.github.britooo.looca.api.group.processos.ProcessoGrupo;
import com.github.britooo.looca.api.group.sistema.Sistema;
import com.github.britooo.looca.api.group.temperatura.Temperatura;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.lang.ProcessBuilder.Redirect.Type;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class TestDatabase {
        Connection connection = new Connection();
        JdbcTemplate con = connection.getConnection();
        Looca looca = new Looca();
        Memoria memoria = new Memoria();
        
        
        
    public void temperatura(){
       Temperatura temperatura = looca.getTemperatura();
       
       String temp = null;
        temp = Double.toString(temperatura.getTemperatura());
        
       String insertStatement = "INSERT INTO dados VALUES (null,?,?,?,?,?)";
        con.update(insertStatement, temp, null, null, null, null);
        List<Dados> onlyFireType = con.query("SELECT * FROM Dados",
                new BeanPropertyRowMapper(Dados.class));

        System.out.println("Exibindo somente Dados:");
        
        for (Dados dados : onlyFireType) {
            System.out.println("temperatura: " + dados.getTemperaturaHard());
        }
    }    
   
        
    public void Execut() {
        // Temperatura:
        
        Temperatura temperatura = looca.getTemperatura();
       
       Double temp = 0.0;
        temp = temperatura.getTemperatura();
        
        
        // PorcentCPU e BytesEmEscrita:
        
        ProcessoGrupo processo = new ProcessoGrupo();
        
        
                 Double porcentCPU = 0.0;
                 Long porcentDisco = null;
        
           porcentCPU = looca.getGrupoDeProcessos().getProcessos().get(0).getUsoCpu();           
           porcentDisco = looca.getGrupoDeDiscos().getDiscos().get(0).getTamanho();
        
        // TempoAtiv
        
                Sistema sistema = new Sistema();
       
        Long sistemas = null;
        sistemas = sistema.getTempoDeAtividade();
        
        
        String insertStatement = "INSERT INTO dados VALUES (null,?,?,?,?)";
        con.update(insertStatement, temp, porcentCPU, porcentDisco, sistemas);
        List<Dados> onlyFireType = con.query("SELECT * FROM Dados",
                new BeanPropertyRowMapper(Dados.class));
        
        for (Dados dados : onlyFireType) {
            System.out.println("temperatura: \n" + dados.getTemperaturaHard()
                + "\n Porcentagem CPU: \n" + dados.getPorcentCPU()
                 + "\n Bytes Escritos no Disco: \n" + dados.getPorcentdiscos()
                  + "\n Tempo de Atividade: \n" + dados.getTempoAtiv()
            );
        }
    } 
    
}