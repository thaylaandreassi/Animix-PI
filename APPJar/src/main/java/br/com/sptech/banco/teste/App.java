/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.sptech.banco.teste;

import com.github.britooo.looca.api.core.Looca;
import java.util.concurrent.TimeUnit;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author aluno
 */
public class App {
    
    private JdbcTemplate connection;
    
       
    public void exec() throws InterruptedException {
         
        
        Connection connectionn = new Connection();
        
        BasicDataSource datasource = new BasicDataSource();
        
        datasource.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        
        
        datasource.setUrl("jdbc:sqlserver://animix.database.windows.net:1433;database=animix;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;");
        
        
        datasource.setUsername("admin-1adsb-grupo07");
        
        datasource.setPassword("#Gfgrupo7");
        
        connection = new JdbcTemplate(datasource);
        
        
        Looca looca = new Looca();
        TestDatabase test = new TestDatabase();

        

    }

    public static void main(String[] args) {
        TestDatabase test = new TestDatabase();
        Login log = new Login();
        log.show();
        test.Execut();

    }
    
    
    public JdbcTemplate getConnection() {
        return connection;
    }
    
    
    
    //System.out.println(looca.getGrupoDeDiscos().getVolumes().get(0).getDisponivel());        
    //System.out.println(looca.getGrupoDeProcessos().getProcessos().get(0).getUsoCpu());        
    //System.out.println(looca.getGrupoDeProcessos().getProcessos().get(0).getBytesUtilizados());

    //System.out.println(looca.getGrupoDeServicos().getServicos());
    //System.out.println(looca.getMemoria());
    //System.out.println(looca.getProcessador().getNumeroCpusFisicas());
    //System.out.println(looca.getSistema().getTempoDeAtividade());
    //System.out.println(looca.getTemperatura().getTemperatura());
}
