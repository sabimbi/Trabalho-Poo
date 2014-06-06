/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 package activities;

/**
 *
 * @author Mesas
 */
import java.util.*;

public class Competicao extends GeneralActivity {

    private double distancia;
    private String resultado;
 private double avgspd;
 private double maxspd;
    public Competicao() {
        super();
        distancia = 0.0;
        resultado = "";
    }

    public Competicao(GregorianCalendar date, String nome, double cal, double hidration, double distance, String result,double avgspd,double maxspd,int hora,int minuto) {
        super(date, nome, cal, hidration,hora,minuto);
        this.resultado = result;
        this.distancia = distance;
        this.avgspd=avgspd;
        this.maxspd=maxspd;
    }

    public Competicao(Competicao a) {
        super(a.getData(), a.getNome(), a.getCalories(), a.getHidration(),a.getHora(),a.getMinuto());
        this.resultado = a.getResultado();
        this.distancia = a.getDistancia();
        this.avgspd=a.getAvgspd();
        this.maxspd=a.getMaxspd();
    }

    public Competicao clone() {
        return new Competicao(this);
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(super.toString());
        s.append("Distância: " + this.distancia + "km\n");
        s.append("Resultado: " + this.resultado + "\n");
        s.append("Velocidade Máxima: " + this.maxspd + "\n");
        s.append("Velocidade Média: " + this.avgspd + "\n");

        return s.toString();
    }

    /**
     * @return the distancia
     */
    public double getDistancia() {
        return distancia;
    }

    /**
     * @param distancia the distancia to set
     */
    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    /**
     * @return the resultado
     */
    public String getResultado() {
        return resultado;
    }

    /**
     * @param resultado the resultado to set
     */
    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    /**
     * @return the avgspd
     */
    public double getAvgspd() {
        return avgspd;
    }

    /**
     * @return the maxspd
     */
    public double getMaxspd() {
        return maxspd;
    }

    /**
     * @param avgspd the avgspd to set
     */
    public void setAvgspd(double avgspd) {
        this.avgspd = avgspd;
    }

    /**
     * @param maxspd the maxspd to set
     */
    public void setMaxspd(double maxspd) {
        this.maxspd = maxspd;
    }
}
