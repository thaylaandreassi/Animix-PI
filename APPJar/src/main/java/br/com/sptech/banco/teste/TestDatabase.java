package br.com.sptech.banco.teste;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.memoria.Memoria;
import com.github.britooo.looca.api.group.sistema.Sistema;
import com.github.britooo.looca.api.group.temperatura.Temperatura;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class TestDatabase {
        Connection connection = new Connection();
        JdbcTemplate con = connection.getConnection();
    
    public void Execut() {
        Looca looca = new Looca();
        
        looca.getGrupoDeDiscos();
        looca.getGrupoDeProcessos();
        looca.getGrupoDeServicos();
        looca.getMemoria();
        looca.getProcessador();
        looca.getSistema();
        looca.getTemperatura();
        
        Memoria memoria = new Memoria();
        
        memoria.getDisponivel();
        
        
        
        //con.execute("DROP TABLE IF EXISTS studio");
        //StringBuilder createStatement = new StringBuilder();
        //createStatement.append("CREATE TABLE studio(");
        //createStatement.append("idStrudio INT PRIMARY KEY AUTO_INCREMENT,");
        //createStatement.append("nomeEmpresa VARCHAR(255),");
        String insertStatement = "INSERT INTO dados VALUES (null, ?)";
        //String temperatura = looca.getMemoria();
        con.update(insertStatement, memoria.getDisponivel().intValue());
        List<Dados> dadosAdvancedUse = con.query("SELECT * FROM dados", new BeanPropertyRowMapper(Dados.class));
        System.out.println("\nEXIBINDO DA MANEIRA MAIS ÚTIL:");
        for (Dados Dados : dadosAdvancedUse) {
            System.out.println("Memória disponível: " + Dados.getMemoria());
        }
        
        
    } 
    
}