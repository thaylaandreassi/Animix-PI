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
    
    public void deserialize(){
        Looca looca = new Looca();
    }
        
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
        
        String insertStatement = "INSERT INTO dados VALUES (null, ?)";
        con.update(insertStatement, memoria.getDisponivel());
        List<Dados> onlyFireType = con.query("SELECT * FROM Dados",
                new BeanPropertyRowMapper(Dados.class));

        System.out.println("Exibindo somente Dados:");
        
         //Dessa vez usando "forEach":
        onlyFireType.forEach(Dados -> System.out.println(Dados.getMemoria()));
        
        
        
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