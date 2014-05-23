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

public class Ambos extends GeneralActivity {

    private double altitudemax;
    private double altitudemin;
    private double distanciasubida;
    private double distanciadescida;
    private double distancia;
    private double velocidademax;
    private double velocidademedia;

    public Ambos() {
        super();
        altitudemax = altitudemin = distanciasubida = distanciadescida = distancia = velocidademax = velocidademedia = 0.0;
    }

    public Ambos(GregorianCalendar date, String nome, double cal, double duration, double hidration, double altitudemax, double altitudemin, double distanciasubida, double distanciadescida, double distancia, double velocidademax, double velocidademedia) {
        super(date, nome, cal, duration, hidration);
        this.altitudemax = altitudemax;
        this.altitudemin = altitudemin;
        this.distanciadescida = distanciadescida;
        this.distanciasubida = distanciadescida;
        this.distancia = distancia;
        this.velocidademax = velocidademax;
        this.velocidademedia = velocidademedia;
    }

    public Ambos(Ambos a) {
        super(a.getData(), a.getNome(), a.getCalories(), a.getDuration(), a.getHidration());
        this.altitudemax = a.getAltitudemax();
        this.altitudemin = a.getAltitudemin();
        this.distanciadescida = a.getDistanciadescida();
        this.distanciasubida = a.getDistanciasubida();
        this.distancia = a.getDistancia();
        this.velocidademax = a.getVelocidademax();
        this.velocidademedia = a.getVelocidademedia();
    }

    public Ambos clone() {
        return new Ambos(this);
    }

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

    /**
     * @return the altitudemax
     */
    public double getAltitudemax() {
        return altitudemax;
    }

    /**
     * @return the altitudemin
     */
    public double getAltitudemin() {
        return altitudemin;
    }

    /**
     * @return the distanciasubida
     */
    public double getDistanciasubida() {
        return distanciasubida;
    }

    /**
     * @return the distanciadescida
     */
    public double getDistanciadescida() {
        return distanciadescida;
    }

    /**
     * @param altitudemax the altitudemax to set
     */
    public void setAltitudemax(double altitudemax) {
        this.altitudemax = altitudemax;
    }

    /**
     * @param altitudemin the altitudemin to set
     */
    public void setAltitudemin(double altitudemin) {
        this.altitudemin = altitudemin;
    }

    /**
     * @param distanciasubida the distanciasubida to set
     */
    public void setDistanciasubida(double distanciasubida) {
        this.distanciasubida = distanciasubida;
    }

    /**
     * @param distanciadescida the distanciadescida to set
     */
    public void setDistanciadescida(double distanciadescida) {
        this.distanciadescida = distanciadescida;
    }
public String toString(){
  StringBuilder s=new StringBuilder();
  s.append(super.toString());
  s.append("Distância: "+this.distancia+"\n");
  
    s.append("Velocidade Máxima: "+this.velocidademax+"\n");
    s.append("Velocidade Mínima: "+this.velocidademax+"\n");  
  s.append("Altitude Máxima: "+this.altitudemax+"\n");
    s.append("Altitude Mínima: "+this.altitudemin+"\n");
    s.append("Distância Subida: "+this.distanciasubida+"\n");
    s.append("Distância Descida: "+this.distanciadescida+"\n");
    return s.toString();
}
}
