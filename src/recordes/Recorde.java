/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package recordes;

import activities.GeneralActivity;

/**
 *
 * @author Mesas
 */
public abstract class Recorde {
    private String nome;
   
    private double maiorcal;
    private double maiorhidrat;
    private int hora;
    private int minuto;
    public Recorde(){
        this.nome="";
        this.hora=this.minuto=0;
        this.maiorhidrat=0.0;
        this.maiorcal=0.0;
    }
    public Recorde(String nome,int hora,int minuto,double maxcal,double maxhidrat){
        this.nome=nome;
        this.maiorcal=maxcal;
        
        this.maiorhidrat=maxhidrat;
        this.hora=hora;
        this.minuto=minuto;
    }
public Recorde(Recorde r){
    this.nome=r.getNome();
    this.hora=r.getHora();
    this.minuto=r.getMinuto();
    this.maiorcal=r.getMaiorcal();
    this.maiorhidrat=r.getMaiorhidrat();
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

    public void ActualizarRecorde(GeneralActivity g) {
    int hora,minuto;
    if(g.getCalories()>this.maiorcal){
        this.setMaiorcal(g.getCalories());
    }
    if(g.getHidration()>this.maiorhidrat){
        this.setMaiorhidrat(g.getHidration());
    }
    hora=g.getHora();
    minuto=g.getMinuto();
    if(hora>this.hora ){
        this.setHora(hora);
        this.setMinuto(minuto);
    }else{
        if(hora==this.hora && minuto >this.minuto){
           this.setHora(hora);
        this.setMinuto(minuto); 
        }
    }
    }
public String toString(){
    StringBuilder s=new StringBuilder();
    s.append("Máxima quantidade de calorias gastas de sempre: "+this.maiorcal+" kcal\n");
    s.append("Máxima duração deste tipo de actividade: "+this.hora+":"+this.minuto+" horas\n");
    s.append("Máxima hidratação: "+this.maiorhidrat+" litros\n");
    return s.toString();
}

    /**
     * @return the hora
     */
    public int getHora() {
        return hora;
    }

    /**
     * @return the minuto
     */
    public int getMinuto() {
        return minuto;
    }

    /**
     * @param hora the hora to set
     */
    public void setHora(int hora) {
        this.hora = hora;
    }

    /**
     * @param minuto the minuto to set
     */
    public void setMinuto(int minuto) {
        this.minuto = minuto;
    }
}
