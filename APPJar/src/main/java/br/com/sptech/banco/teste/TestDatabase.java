package br.com.sptech.banco.teste;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.memoria.Memoria;
import com.github.britooo.looca.api.group.processos.ProcessoGrupo;
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
       ProcessoGrupo processo = new ProcessoGrupo();
       
       String processos = null;
        processos = Long.toString(processo.getTotalProcessos());
        
        
        
        String insertStatement = "INSERT INTO dados VALUES (null, ?)";
        con.update(insertStatement, processos);
        List<Dados> onlyFireType = con.query("SELECT * FROM Dados",
                new BeanPropertyRowMapper(Dados.class));

        System.out.println("Exibindo somente Dados:");
        
        for (Dados dados : onlyFireType) {
            System.out.println("Total de Processos" + dados.getQtdProcessosAtuantes());
        }
    }    
    
    public void TempoAtiv(){
        Sistema sistema = new Sistema();
       
       String sistemas = null;
        sistemas = Long.toString(sistema.getTempoDeAtividade());
        
        
        
        String insertStatement = "INSERT INTO dados VALUES (null,?,?,?,?,?)";
        con.update(insertStatement, null, null, null, sistemas, null);
        List<Dados> onlyFireType = con.query("SELECT * FROM Dados",
                new BeanPropertyRowMapper(Dados.class));

        System.out.println("Exibindo somente Dados:");
        
        for (Dados dados : onlyFireType) {
            System.out.println("Tempo de Atividade :" + dados.getTempoAtiv());
        }
    }
        
    public void Execut() {
        
        Memoria memoria = new Memoria();
        
        
        String teste = null;
        teste = Long.toString(memoria.getEmUso());
        
        
        
        String insertStatement = "INSERT INTO dados VALUES (null, ?)";
        con.update(insertStatement, teste);
        List<Dados> onlyFireType = con.query("SELECT * FROM Dados",
                new BeanPropertyRowMapper(Dados.class));

        System.out.println("Exibindo somente Dados:");
        
        for (Dados dados : onlyFireType) {
            System.out.println("Memória Ram: " + dados.getIdDados());
        }
        
         //Dessa vez usando "forEach":
        //onlyFireType.forEach(Dados -> System.out.println(Dados);
        
        
        
        //con.execute("DROP TABLE IF EXISTS studio");
        //StringBuilder createStatement = new StringBuilder();
        //createStatement.append("CREATE TABLE studio(");
        //createStatement.append("idStrudio INT PRIMARY KEY AUTO_INCREMENT,");
        //createStatement.append("nomeEmpresa VARCHAR(255),");
        
        //String insertStatement = "INSERT INTO dados VALUES (null, ?)";
        //String temperatura = looca.getMemoria();
        //con.update(insertStatement, memoria.getDisponivel());
        //List<Dados> dadosAdvancedUse = con.query("SELECT * FROM dados", new BeanPropertyRowMapper(Dados.class));
        //System.out.println("\nEXIBINDO DA MANEIRA MAIS ÚTIL:");
        //for (Dados Dados : dadosAdvancedUse) {
            //System.out.println("Memória dilsponível: " + Dados.getMemoria());
        //}
        
        
    } 
    
}