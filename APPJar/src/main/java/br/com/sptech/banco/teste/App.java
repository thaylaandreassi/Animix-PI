/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.sptech.banco.teste;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.discos.DiscoGrupo;
import com.github.britooo.looca.api.group.memoria.Memoria;
import com.github.britooo.looca.api.group.processador.Processador;
import com.github.britooo.looca.api.group.processos.ProcessoGrupo;
import com.github.britooo.looca.api.group.servicos.ServicoGrupo;
import com.github.britooo.looca.api.group.sistema.Sistema;
import com.github.britooo.looca.api.group.temperatura.Temperatura;
import com.github.britooo.looca.api.util.Conversor;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author aluno
 */
public class App {

    private JdbcTemplate connection;
    private JdbcTemplate connectionMySql;

    public void exec() throws InterruptedException {

        Connection connectionn = new Connection();
        BasicDataSource datasource = new BasicDataSource();
        connection = new JdbcTemplate(datasource);

        Looca looca = new Looca();
        TestDatabase test = new TestDatabase();
    }
 public void exec2() throws InterruptedException {

        ConnectionMySqlLocal connectionnLocal = new ConnectionMySqlLocal();
        BasicDataSource datasourceMySql = new BasicDataSource();
        connectionMySql = new JdbcTemplate(datasourceMySql);

        Looca looca = new Looca();
        TestDatabase2 test2 = new TestDatabase2();
    }
    public static void main(String[] args) {
        Looca looca = new Looca();
        Login log = new Login();
        log.show();

        // Uso da API
        Conversor conversor = new Conversor();
        Sistema sistema = new Sistema();
        String sistemas = null;
        sistemas = conversor.formatarSegundosDecorridos(sistema.getTempoDeAtividade());

        Memoria memoria = new Memoria();
        String memorias = null;
        memorias = conversor.formatarBytes(memoria.getEmUso());

        Date dataHoraAtual = new Date();
        String data = new SimpleDateFormat("dd/MM/yyyy").format(dataHoraAtual);
        String Dt = new SimpleDateFormat("HH:mm:ss").format(dataHoraAtual);

        Processador processador = new Processador();
        Temperatura temperatura = new Temperatura();
        DiscoGrupo disco = new DiscoGrupo();
        ServicoGrupo servicos = new ServicoGrupo();
        ProcessoGrupo processos = new ProcessoGrupo();

        //System.out.println("USO DA API:"
        // + "\n Tempo de Atividade: \n" + sistemas
        //    + "\n Memoria em Uso: " + memorias
        //      + "\n Data: " + data
        //      + "\n Hora: " + Dt
        //      + "\n Frabicante do processador: " + processador.getFabricante()
        //      + "\n Frequ??ncia: " + processador.getFrequencia()
        //      + "\n Identificador: " + processador.getIdentificador()
        //      + "\n Microarquitetura: " + processador.getMicroarquitetura()
        //      + "\n Nome processador: " + processador.getNome()
        //      + "\n N??mero de CPUs F??sicas: " + processador.getNumeroCpusFisicas()
        //      + "\n N??mero de CPUs L??gicas:" + processador.getNumeroCpusLogicas()
        //      + "\n N??mero de Pacotes F??sicos: " + processador.getNumeroPacotesFisicos()
        //      + "\n Uso processador: " + processador.getUso()
        //      + "\n Temperatura: " + temperatura.getTemperatura()
        //      + "\n Lista detalhes Disco: " + disco.getDiscos()
        //      + "\n Servi??os: " + servicos.getServicos() 
        //                        + servicos.getServicosAtivos()
        //                         + servicos.getServicosInativos()
        //       + "\n Detalhes processos: " + processos.getProcessos()
        //  );
    }

    public JdbcTemplate getConnection() {
        return connection;
    }

    public JdbcTemplate getConnectionMySql() {
        return connectionMySql;
    }

    String getTempoAtiv() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
