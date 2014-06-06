/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 
package activities;
/**
 *
 * @author Dimz
 */
import java.io.Serializable;
import java.util.*;

public abstract class GeneralActivity implements Serializable{

    private GregorianCalendar data;
    private String nome;
    private double calories;
    
    private int hora;
    private int minuto;
    private double hidratacao;

    public GeneralActivity() {
        this.nome = "";
        this.calories = 0.0;
        this.hidratacao = 0.0;
        this.hora=this.minuto = 0;
        this.data = new GregorianCalendar();
        
    }

    public GeneralActivity(GregorianCalendar date, String nome, double cal,double hidration,int hora,int minuto) {
        this.data = date;
        this.nome = nome;
        this.calories = cal;
        this.hidratacao = hidration;
        this.hora = hora;
        this.minuto=minuto;
        
    }

    public GeneralActivity(GeneralActivity g) {
        this.nome = g.getNome();
        this.calories = g.getCalories();
        this.hidratacao = g.getHidration();
        this.hora = g.getHora();
        this.minuto=g.getMinuto();
        this.data = g.getData();
    }

    public void setData(GregorianCalendar date) {
        int dia, mes, ano,hora,minuto;
        this.data = date;
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
     * @return the calories
     */
    public double getCalories() {
        return calories;
    }

    /**
     * @param calories the calories to set
     */
    public void setCalories(double calories) {
        this.calories = calories;
    }

    /**
     * @return the duration
     */
   

    public double getHidration() {
        return hidratacao;

    }

    public GregorianCalendar getData() {
       
        return this.data;
    }

    public String toString() {
        int dia, mes, ano;
        StringBuilder s = new StringBuilder();
        dia = this.data.get(Calendar.DATE);
        mes = this.data.get(Calendar.MONTH);
        ano = this.data.get(Calendar.YEAR);
        
        s.append("Nome: " + this.nome + "\n");
        s.append("Data: " + dia + " - " + mes + " - " + ano + "\n");
        s.append("Duração: " + this.hora +":"+this.minuto+" horas\n");
        s.append("Calorias: " + this.calories + " kcal\n");
        s.append("Hidratação: " + this.hidratacao + " litros\n");
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
