/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package recordes;

import activities.Altitude;

/**
 *
 * @author Mesas
 */
public class RecordeAltitude extends Recorde {
    private double maxaltitudemax;
    private double maxaltitudemin;
    private double maxdistanciasubida;
    private double maxdistanciadescida;
    private double maxdistancia;
    private double maxvelocidademax;
    private double maxvelocidademedia;
    
    public RecordeAltitude(){
        super();
        maxaltitudemax=maxaltitudemin=maxdistancia=maxdistanciadescida=maxdistanciasubida=maxvelocidademax=maxvelocidademedia=0.0;
    }
    public RecordeAltitude(String nome,int hora,int minuto,double maxcal,double maxhidrat,double maxalt,double minalt,double maxdistsub,double maxdistdesc,double maxdist,double maxspd,double avgspd){
        super(nome,hora,minuto,maxcal, maxhidrat);
        this.maxaltitudemax=maxalt;
        this.maxaltitudemin=minalt;
        this.maxdistanciadescida=maxdistdesc;
        this.maxdistanciasubida=maxdistsub;
        this.maxdistancia=maxdist;
        this.maxvelocidademax=maxspd;
        this.maxvelocidademedia=avgspd;
    }
public RecordeAltitude(RecordeAltitude r){
    super(r.getNome(), r.getHora(),r.getMinuto(), r.getMaiorcal(), r.getMaiorhidrat());
    this.maxaltitudemax=r.getMaxaltitudemax();
    this.maxaltitudemin=r.getMaxaltitudemin();
    this.maxdistanciadescida=r.getMaxdistanciadescida();
    this.maxdistanciasubida=r.getMaxdistanciasubida();
    this.maxdistancia=r.getMaxdistancia();
    this.maxvelocidademax=r.getMaxvelocidademax();
    this.maxvelocidademedia=r.getMaxvelocidademedia();
}
public RecordeAltitude clone(){
    return new RecordeAltitude(this);
}
    /**
     * @return the maxaltitudemax
     */
    public double getMaxaltitudemax() {
        return maxaltitudemax;
    }

    /**
     * @param maxaltitudemax the maxaltitudemax to set
     */
    public void setMaxaltitudemax(double maxaltitudemax) {
        this.maxaltitudemax = maxaltitudemax;
    }

    /**
     * @return the maxaltitudemin
     */
    public double getMaxaltitudemin() {
        return maxaltitudemin;
    }

    /**
     * @param maxaltitudemin the maxaltitudemin to set
     */
    public void setMaxaltitudemin(double maxaltitudemin) {
        this.maxaltitudemin = maxaltitudemin;
    }

    /**
     * @return the maxdistanciasubida
     */
    public double getMaxdistanciasubida() {
        return maxdistanciasubida;
    }

    /**
     * @param maxdistanciasubida the maxdistanciasubida to set
     */
    public void setMaxdistanciasubida(double maxdistanciasubida) {
        this.maxdistanciasubida = maxdistanciasubida;
    }

    /**
     * @return the maxdistanciadescida
     */
    public double getMaxdistanciadescida() {
        return maxdistanciadescida;
    }

    /**
     * @param maxdistanciadescida the maxdistanciadescida to set
     */
    public void setMaxdistanciadescida(double maxdistanciadescida) {
        this.maxdistanciadescida = maxdistanciadescida;
    }

    /**
     * @return the maxdistancia
     */
    public double getMaxdistancia() {
        return maxdistancia;
    }

    /**
     * @param maxdistancia the maxdistancia to set
     */
    public void setMaxdistancia(double maxdistancia) {
        this.maxdistancia = maxdistancia;
    }

    /**
     * @return the maxvelocidademax
     */
    public double getMaxvelocidademax() {
        return maxvelocidademax;
    }

    /**
     * @param maxvelocidademax the maxvelocidademax to set
     */
    public void setMaxvelocidademax(double maxvelocidademax) {
        this.maxvelocidademax = maxvelocidademax;
    }

    /**
     * @return the maxvelocidademedia
     */
    public double getMaxvelocidademedia() {
        return maxvelocidademedia;
    }

    /**
     * @param maxvelocidademedia the maxvelocidademedia to set
     */
    public void setMaxvelocidademedia(double maxvelocidademedia) {
        this.maxvelocidademedia = maxvelocidademedia;
    }
    public void ActualizarRecorde(Altitude a){
        super.ActualizarRecorde(a);
        if(a.getAltitudemax()>this.maxaltitudemax){
            this.setMaxaltitudemax(a.getAltitudemax());
        }
        if(a.getAltitudemin()>this.maxaltitudemin){
            this.setMaxaltitudemin(a.getAltitudemin());
        }
        if(a.getDistancia()>this.maxdistancia){
            this.setMaxdistancia(a.getDistancia());
        }
        if(a.getDistanciadescida()>this.maxdistanciadescida){
            this.setMaxdistanciadescida(a.getDistanciadescida());
        }
        if(a.getDistanciasubida()>this.maxdistanciasubida){
            this.setMaxdistanciasubida(a.getDistanciasubida());
        }
        if(a.getVelocidademax()>this.maxvelocidademax){
            this.setMaxvelocidademax(a.getVelocidademax());
            
        }
        if(a.getVelocidademedia()>this.maxvelocidademedia){
            this.setMaxvelocidademedia(a.getVelocidademedia());
            
        }
    }
}
