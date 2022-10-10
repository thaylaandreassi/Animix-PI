/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.sptech.banco.teste;

/**
 *
 * @author Eduardo
 */
public class Dados {
    private Integer idDados;
    private Double temperatura;
    private Double PorcentCPU;
    private Double Porcentdiscos;
    private String TempoAtiv;
    private Integer QtdProcessosAtuantes;

    public Integer getIdDados() {
        return idDados;
    }

    public void setIdDados(Integer idDados) {
        this.idDados = idDados;
    }

    public Double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(Double temperatura) {
        this.temperatura = temperatura;
    }

    public Double getPorcentCPU() {
        return PorcentCPU;
    }

    public void setPorcentCPU(Double PorcentCPU) {
        this.PorcentCPU = PorcentCPU;
    }

    public Double getPorcentdiscos() {
        return Porcentdiscos;
    }

    public void setPorcentdiscos(Double Porcentdiscos) {
        this.Porcentdiscos = Porcentdiscos;
    }

    public String getTempoAtiv() {
        return TempoAtiv;
    }

    public void setTempoAtiv(String TempoAtiv) {
        this.TempoAtiv = TempoAtiv;
    }

    public Integer getQtdProcessosAtuantes() {
        return QtdProcessosAtuantes;
    }

    public void setQtdProcessosAtuantes(Integer QtdProcessosAtuantes) {
        this.QtdProcessosAtuantes = QtdProcessosAtuantes;
    }

}
