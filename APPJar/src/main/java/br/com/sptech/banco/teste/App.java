/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.sptech.banco.teste;

import com.github.britooo.looca.api.core.Looca;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author aluno
 */
public class App {

    public void exec() throws InterruptedException {
        Looca looca = new Looca();
        TestDatabase test = new TestDatabase();

        for (int i = 0; i < 1; i++) {
            TimeUnit.SECONDS.sleep(0);
            test.Execut();

        }

    }

    public static void main(String[] args) {
        Login log = new Login();
        log.show();

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
