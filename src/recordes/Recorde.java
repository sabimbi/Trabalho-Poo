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
public abstract class Recorde {
    private String nome;
    private String maiorduration;
    private double maiorcal;
    private double maiorhidrat;
    
    public Recorde(){
        this.nome="";
        this.maiorduration="";
        this.maiorhidrat=0.0;
        this.maiorcal=0.0;
    }
    public Recorde(String nome,String maxdur,double maxcal,double maxhidrat){
        this.nome=nome;
        this.maiorcal=maxcal;
        this.maiorduration=maxdur;
        this.maiorhidrat=maxhidrat;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the maiorduration
     */
    public String getMaiorduration() {
        return maiorduration;
    }

    /**
     * @param maiorduration the maiorduration to set
     */
    public void setMaiorduration(String maiorduration) {
        this.maiorduration = maiorduration;
    }

    /**
     * @return the maiorcal
     */
    public double getMaiorcal() {
        return maiorcal;
    }

    /**
     * @param maiorcal the maiorcal to set
     */
    public void setMaiorcal(double maiorcal) {
        this.maiorcal = maiorcal;
    }

    /**
     * @return the maiorhidrat
     */
    public double getMaiorhidrat() {
        return maiorhidrat;
    }

    /**
     * @param maiorhidrat the maiorhidrat to set
     */
    public void setMaiorhidrat(double maiorhidrat) {
        this.maiorhidrat = maiorhidrat;
    }
}
