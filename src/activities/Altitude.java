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

public class Altitude extends GeneralActivity {

    private double distancia;
    private double altitudemax;
    private double altitudemin;
    private double distanciasubida;
    private double distanciadescida;

    public Altitude() {
        super();
        altitudemax = altitudemin = distanciadescida = distanciasubida = distancia = 0.0;
    }

    public Altitude(GregorianCalendar date, String nome, double cal, double duration, double hidration, double distance, double maxaltitude, double minaltitude, double ascent, double descent) {
        super(date, nome, cal, duration, hidration);
        this.altitudemax = maxaltitude;
        this.altitudemin = minaltitude;
        this.distanciadescida = descent;
        this.distanciasubida = ascent;
        this.distancia = distance;
    }

    public Altitude(Altitude a) {
        super(a.getData(), a.getNome(), a.getCalories(), a.getDuration(), a.getHidration());
        this.altitudemax = a.getAltitudemax();
        this.altitudemin = a.getAltitudemin();
        this.distanciadescida = a.getDistanciadescida();
        this.distanciasubida = a.getDistanciasubida();
        this.distancia = a.getDistancia();
    }

    public Altitude clone() {
        return new Altitude(this);
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

    public double getDistancia() {
        return this.distancia;
    }
public String toString(){
    StringBuilder s=new StringBuilder();
    s.append(super.toString());
    s.append("Distância: "+this.distancia+"\n");
    s.append("Altitude Máxima: "+this.altitudemax+"\n");
    s.append("Altitude Mínima: "+this.altitudemin+"\n");
    s.append("Distância Subida: "+this.distanciasubida+"\n");
    s.append("Distância Descida: "+this.distanciadescida+"\n");
    return s.toString();
}
}
