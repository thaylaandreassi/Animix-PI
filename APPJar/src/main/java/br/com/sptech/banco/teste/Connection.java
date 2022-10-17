package br.com.sptech.banco.teste;

import com.github.britooo.looca.api.core.Looca;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public class Connection {

    private JdbcTemplate connection; 
    
    // Exemplo de configuração utilizando H2
    // Obs. O código comentado é um exemplo de como se conectar ao mysql
    public Connection() {
        BasicDataSource datasource = new BasicDataSource();

        //datasource.setDriverClassName("org.h2.Driver");
        
        //datasource.setUrl("jdbc:h2:file:./meu_banco");
               
        //datasource.setUsername("sa");

        //datasource.setPassword("");
        
        try {
           DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());;
        } catch (java.sql.SQLException e) {
            
        }
        
        //datasource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        
        datasource.setUrl("jdbc:sqlserver://animix.database.windows.net/animix");
        
        datasource.setUsername("admin-1adsb-grupo07");
        
        datasource.setPassword("#Gfgrupo7");
        
        connection = new JdbcTemplate(datasource);
        
        
        
        //url=jdbc:sqlserver://$AZ_DATABASE_NAME.database.windows.net:1433;database=demo;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;
        //user=demo@$AZ_DATABASE_NAME
        //password=$AZ_SQL_SERVER_PASSWORD
        
        
        
    }

    public JdbcTemplate getConnection() {
        return connection;
    }
    
}
