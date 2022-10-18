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
        
        datasource.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        
        
        datasource.setUrl("jdbc:sqlserver://animix.database.windows.net:1433;database=animix;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;");
        
        
        datasource.setUsername("admin-1adsb-grupo07");
        
        datasource.setPassword("#Gfgrupo7");
        
        connection = new JdbcTemplate(datasource);
       
        //Class.forName("com.mysql.cj.jdbc.Driver");
        //Connection con = DriverManager.getConnection("jdbc:mysql://localhost/animix?useSSL=false", "root", "@");
        //datasource.setUrl("jdbc:mysql://localhost/animix");
    }

    public JdbcTemplate getConnection() {
        return connection;
    }
    
}
