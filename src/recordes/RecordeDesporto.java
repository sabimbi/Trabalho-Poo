/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package recordes;

import activities.Desporto;

/**
 *
 * @author Mesas
 */
public class RecordeDesporto extends Recorde{
    private double maxdistancia;
    private int nvictorias;
    private int nderrotas;
    private int nempates;
 private double maxspdmedia;
 private double maxspdmax;
 
 public RecordeDesporto(){
     this.maxdistancia=this.maxspdmedia=this.maxspdmax=0.0;
     this.nderrotas=this.nvictorias=this.nempates=0;
 }
public RecordeDesporto(String nome,int hora,int minuto,double maxcal,double maxhidrat,double maxdistancia,int nvictorias,int nderrotas,int nempates,double maxspdmedia,double maxspdmax){
   super(nome, hora,minuto, maxcal, maxhidrat);
   this.nderrotas=nderrotas;
   this.nvictorias=nvictorias;
   this.nempates=nempates;
   this.maxdistancia=maxdistancia;
   this.maxspdmax=maxspdmax;
   this.maxspdmedia=maxspdmedia;
    
}
public RecordeDesporto(RecordeDesporto r){
    super(r.getNome(),r.getHora(),r.getMinuto(),r.getMaiorcal(),r.getMaiorhidrat());
    this.nvictorias=r.getNvictorias();
    this.nderrotas=r.getNderrotas();
    this.maxdistancia=r.getMaxdistancia();
    this.maxspdmax=r.getMaxspdmax();
    this.maxspdmedia=r.getMaxspdmedia();
}

public RecordeDesporto clone(){
    return new RecordeDesporto(this);
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
     * @return the nvictorias
     */
    public int getNvictorias() {
        return nvictorias;
    }

    /**
     * @param nvictorias the nvictorias to set
     */
    public void setNvictorias(int nvictorias) {
        this.nvictorias = nvictorias;
    }

    /**
     * @return the nderrotas
     */
    public int getNderrotas() {
        return nderrotas;
    }

    /**
     * @param nderrotas the nderrotas to set
     */
    public void setNderrotas(int nderrotas) {
        this.nderrotas = nderrotas;
    }

    /**
     * @return the maxspdmedia
     */
    public double getMaxspdmedia() {
        return maxspdmedia;
    }

    /**
     * @param maxspdmedia the maxspdmedia to set
     */
    public void setMaxspdmedia(double maxspdmedia) {
        this.maxspdmedia = maxspdmedia;
    }

    /**
     * @return the maxspdmax
     */
    public double getMaxspdmax() {
        return maxspdmax;
    }

    /**
     * @param maxspdmax the maxspdmax to set
     */
    public void setMaxspdmax(double maxspdmax) {
        this.maxspdmax = maxspdmax;
    }
    public void ActualizarRecorde(Desporto d){
        if(d.getDistancia()>this.maxdistancia){
            this.setMaxdistancia(d.getDistancia());
        }
        if(d.getMaxspd()>this.maxspdmax){
            this.setMaxspdmax(d.getMaxspd());
            
        }
        if(d.getAvgspd()>this.maxspdmedia){
            this.setMaxspdmedia(d.getAvgspd());
        }
        if(d.getResultado().equals("Victória")==true){
            this.AddVictoria();
        }else{
            if(d.getResultado().equals("Derrota")==true){
            this.AddDerrota();
        }else{
             if(d.getResultado().equals("Empate")==true){
            this.AddEmpate();
        }   
            }
        }
    }
    public void AddVictoria(){
        this.nvictorias++;
    }
    public void AddDerrota(){
        this.nderrotas++;
    }
    public void AddEmpate(){
        this.setNempates(this.getNempates() + 1);
    }

    /**
     * @return the nempates
     */
    public int getNempates() {
        return nempates;
    }

    /**
     * @param nempates the nempates to set
     */
    public void setNempates(int nempates) {
        this.nempates = nempates;
    }
    public String toString(){
        StringBuilder s=new StringBuilder();
        s.append(super.toString());
        s.append("Máxima distância percorrida de sempre: "+this.maxdistancia+" km\n");
    s.append("Melhor velocidade máxima de sempre: "+this.maxspdmax+" km/h\n");
    s.append("Melhor velocidade média de sempre: "+this.maxspdmedia+" km/h\n");
    s.append("Nr de Victórias de sempre: "+this.nvictorias+"\n");
    s.append("Nr de Derrotas de sempre: "+this.nderrotas+"\n");
    s.append("Nr de Empates de sempre: "+this.nempates+"\n");
    return s.toString();
    }
}
