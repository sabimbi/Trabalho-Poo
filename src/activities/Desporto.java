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

public class Desporto extends GeneralActivity {

    private double distancia;
    private String resultado;
 private double avgspd;
 private double maxspd;
    public Desporto() {
        super();
        distancia = 0.0;
        resultado = "";
    }

    public Desporto(GregorianCalendar date, String nome, double cal, String duration, double hidration, double distance, String result) {
        super(date, nome, cal, duration, hidration);
        this.resultado = result;
        this.distancia = distance;
    }

    public Desporto(Desporto a) {
        super(a.getData(), a.getNome(), a.getCalories(), a.getDuration(), a.getHidration());
        this.resultado = a.getResultado();
        this.distancia = a.getDistancia();
    }

    public Desporto clone() {
        return new Desporto(this);
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(super.toString());
        s.append("Distância: " + this.distancia + "m\n");
        s.append("Resultado: " + this.resultado + "\n");

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
}
