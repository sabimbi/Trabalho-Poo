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
    
    private String duration;
    private double hidratacao;

    public GeneralActivity() {
        this.nome = "";
        this.calories = 0.0;
        this.hidratacao = 0.0;
        this.duration = "";
        this.data = new GregorianCalendar();
        
    }

    public GeneralActivity(GregorianCalendar date, String nome, double cal, String duration, double hidration) {
        this.data = date;
        this.nome = nome;
        this.calories = cal;
        this.hidratacao = hidration;
        this.duration = duration;
        
    }

    public GeneralActivity(GeneralActivity g) {
        this.nome = g.getNome();
        this.calories = g.getCalories();
        this.hidratacao = g.getHidration();
        this.duration = g.getDuration();
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
    public String getDuration() {
        return duration;
    }

    /**
     * @param duration the duration to set
     */
    public void setDuration(String duration) {
        this.duration = duration;
    }

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
        s.append("Duração: " + this.duration + " horas\n");
        s.append("Calorias: " + this.calories + " kcal\n");
        s.append("Hidratação: " + this.hidratacao + " litros\n");
        return s.toString();
    }

}
