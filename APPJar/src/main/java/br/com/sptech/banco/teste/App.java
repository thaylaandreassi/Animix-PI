/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.sptech.banco.teste;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.temperatura.Temperatura;
import com.github.britooo.looca.api.group.memoria.Memoria;
import com.github.britooo.looca.api.group.sistema.Sistema;
import com.google.gson.Gson;
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
        
        test.Execut();
        
        //Memoria memoria = new Memoria();
        
        
        //System.out.println( memoria.getTotal());
        
    }
}
