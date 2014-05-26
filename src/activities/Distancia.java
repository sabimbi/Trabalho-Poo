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

public class Distancia extends GeneralActivity {

    private double distancia;
    private double velocidademax;
    private double velocidademedia;

    public Distancia() {
        super();
        distancia = 0.0;
        velocidademax = 0.0;
        velocidademedia = 0.0;
    }

    public Distancia(GregorianCalendar date, String nome, double cal, String duration, double hidration, double distance, double velocidademax, double velocidademedia) {
        super(date, nome, cal, duration, hidration);
        this.distancia = distance;
        this.velocidademax = velocidademax;
        this.velocidademedia = velocidademedia;
    }

    public Distancia(Distancia d) {
        super(d.getData(), d.getNome(), d.getCalories(), d.getDuration(), d.getHidration());
        this.distancia = d.getDistancia();
        this.velocidademax = d.getVelocidademax();
        this.velocidademedia = d.getVelocidademedia();
    }

    public Distancia clone() {
        return new Distancia(this);
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
     * @return the velocidademax
     */
    public double getVelocidademax() {
        return velocidademax;
    }

    /**
     * @param velocidademax the velocidademax to set
     */
    public void setVelocidademax(double velocidademax) {
        this.velocidademax = velocidademax;
    }

    /**
     * @return the velocidademedia
     */
    public double getVelocidademedia() {
        return velocidademedia;
    }

    /**
     * @param velocidademedia the velocidademedia to set
     */
    public void setVelocidademedia(double velocidademedia) {
        this.velocidademedia = velocidademedia;
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(super.toString());
        s.append("Distância: " + this.distancia + " km\n");
        s.append("Velocidade Máxima: " + this.velocidademax + " km/h\n");
        s.append("Velocidade Média: " + this.velocidademedia + " km/h\n");
        return s.toString();
    }
}
