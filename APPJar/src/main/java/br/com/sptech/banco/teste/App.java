/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.sptech.banco.teste;

import com.github.britooo.looca.api.core.Looca;
import oshi.SystemInfo;
import oshi.hardware.HardwareAbstractionLayer;
import com.github.britooo.looca.api.group.temperatura.Temperatura;
import com.github.britooo.looca.api.group.memoria.Memoria;
import com.github.britooo.looca.api.group.sistema.Sistema;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.LongSerializationPolicy;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author aluno
 */
public class App {
    public static void main(String[] args) throws InterruptedException {
        Looca looca = new Looca();
        TestDatabase test = new TestDatabase();
        
        for (int i = 0; i < 50; i++) {
            TimeUnit.SECONDS.sleep(1);
            test.Execut();
    }
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

