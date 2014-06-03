/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package recordes;

/**
 *
 * @author Mesas
 */
public class RecordeDesporto extends Recorde{
    private double maxdistancia;
    private int nvictorias;
    private int nderrotas;
 private double maxspdmedia;
 private double maxspdmax;
 
 public RecordeDesporto(){
     this.maxdistancia=this.maxspdmedia=this.maxspdmax=0.0;
     this.nderrotas=this.nvictorias=0;
 }
public RecordeDesporto(String nome,String maiordur,double maxcal,double maxhidrat){
   super(nome, maiordur, maxcal, maxhidrat);
    
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
}
