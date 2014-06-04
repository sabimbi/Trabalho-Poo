/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package recordes;
import activities.*;
/**
 *
 * @author Mesas
 */
public class RecordeDistancia extends Recorde{
    private double maxdistancia;
    private double maxspdmax;
    private double maxspdmedia;
    public RecordeDistancia(){
        super();
        maxdistancia=maxspdmax=maxspdmedia=0.0;
    }
    public RecordeDistancia(String nome,int hora,int minuto,double maxcal,double maxhidrat,double maxdistancia,double maxspdmax,double maxspdmedia){
        super(nome,hora,minuto,maxcal,maxhidrat);
        this.maxdistancia=maxdistancia;
        this.maxspdmax=maxspdmax;
        this.maxspdmedia=maxspdmedia;
    }
    public RecordeDistancia(RecordeDistancia r){
        super(r.getNome(),r.getHora(),r.getMinuto(),r.getMaiorcal(),r.getMaiorhidrat());
        this.maxdistancia=r.getMaxdistancia();
        this.maxspdmax=r.getMaxspdmax();
        this.maxspdmedia=r.getMaxspdmedia();
    }
    public RecordeDistancia clone(){
        return new RecordeDistancia(this);
    }
public void ActualizarRecorde(Distancia d){
    super.ActualizarRecorde(d);
    if(d.getDistancia()>this.maxdistancia){
        this.setMaxdistancia(d.getDistancia());
    }
    if(d.getVelocidademax()>this.maxspdmax){
        this.setMaxspdmax(d.getVelocidademax());
    }
    if(d.getVelocidademedia()>this.maxspdmedia){
        this.setMaxspdmedia(d.getVelocidademedia());
    }
            }
    /**
     * @return the maxdistancia
     */
    public double getMaxdistancia() {
        return maxdistancia;
    }

    /**
     * @return the maxspdmax
     */
    public double getMaxspdmax() {
        return maxspdmax;
    }

    /**
     * @return the maxspdmedia
     */
    public double getMaxspdmedia() {
        return maxspdmedia;
    }

    /**
     * @param maxdistancia the maxdistancia to set
     */
    public void setMaxdistancia(double maxdistancia) {
        this.maxdistancia = maxdistancia;
    }

    /**
     * @param maxspdmax the maxspdmax to set
     */
    public void setMaxspdmax(double maxspdmax) {
        this.maxspdmax = maxspdmax;
    }

    /**
     * @param maxspdmedia the maxspdmedia to set
     */
    public void setMaxspdmedia(double maxspdmedia) {
        this.maxspdmedia = maxspdmedia;
    }
    public String toString(){
        StringBuilder s=new StringBuilder();
        s.append(super.toString());
        s.append("Máxima distância percorrida de sempre: "+this.maxdistancia+"km\n");
        s.append("Velocidade Máxima de sempre: "+this.maxspdmax+"km/h\n");
        s.append("Velocidade Média de sempre: "+this.maxspdmedia+"km/h\n");
        return s.toString();
    }
    
}
