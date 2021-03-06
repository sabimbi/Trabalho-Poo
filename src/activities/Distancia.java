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

    public Distancia(GregorianCalendar date, String nome,String tipo, double cal, double hidration, double distance, double velocidademax, double velocidademedia,int hora,int minuto) {
        super(date, nome,tipo, cal, hidration,hora,minuto);
        this.distancia = distance;
        this.velocidademax = velocidademax;
        this.velocidademedia = velocidademedia;
    }

    public Distancia(Distancia d) {
        super(d.getData(), d.getNome(), d.getTipo(),d.getCalories(), d.getHidration(),d.getHora(),d.getMinuto());
        this.distancia = d.getDistancia();
        this.velocidademax = d.getVelocidademax();
        this.velocidademedia = d.getVelocidademedia();
    }

    public Distancia clone() {
        return new Distancia(this);
    }
    public boolean equals(Object o){
        boolean op=false;
        if(this==o){
            op=true;
        }
        if(o==null || this.getClass()!=o.getClass()){
            op=false;
        }
   Distancia aux=(Distancia)o;
   if(super.equals(aux) && this.getDistancia()==aux.getDistancia() && this.getVelocidademax()==aux.getVelocidademax() && this.getVelocidademedia()==aux.getVelocidademedia())   
   op=true;
   return op;
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
