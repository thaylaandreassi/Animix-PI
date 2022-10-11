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
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aluno
 */
public class App {
    public static void main(String[] args) {
        Looca looca = new Looca();
        TestDatabase test = new TestDatabase();
        //test.convert();
        test.TempoAtiv();
        test.temperatura();
        //test.Processos();
        
        
        //System.out.println(looca.getGrupoDeDiscos().getVolumes().get(0).getTipo());        
        //System.out.println(looca.getGrupoDeProcessos().getTotalProcessos());
        //System.out.println(looca.getGrupoDeServicos());
        //System.out.println(looca.getMemoria());
        //System.out.println(looca.getProcessador().getNumeroCpusFisicas());
        //System.out.println(looca.getSistema().getTempoDeAtividade());
        //System.out.println(looca.getTemperatura().getTemperatura());
    }
}
