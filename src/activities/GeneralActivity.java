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
import java.util.*;

public abstract class GeneralActivity {

    private GregorianCalendar data;
    private String nome;
    private double calories;

    private double duration;
    private double hidratacao;

    public GeneralActivity() {
        this.nome = "";
        this.calories = 0.0;
        this.hidratacao = 0.0;
        this.duration = 0.0;
        this.data = new GregorianCalendar();
    }

    public GeneralActivity(GregorianCalendar date, String nome, double cal, double duration, double hidration) {
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
public void setData(GregorianCalendar date){
    int dia,mes,ano;
    this.data=new GregorianCalendar();
    dia = date.get(Calendar.DATE);
        mes = date.get(Calendar.MONTH);
        ano = date.get(Calendar.YEAR);
        this.data.set(Calendar.DATE, dia);
        this.data.set(Calendar.MONTH, mes);
        this.data.set(Calendar.YEAR, ano);
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
    public double getDuration() {
        return duration;
    }

    /**
     * @param duration the duration to set
     */
    public void setDuration(double duration) {
        this.duration = duration;
    }

    public double getHidration() {
        return hidratacao;

    }

    public GregorianCalendar getData() {
        int dia, mes, ano;
        GregorianCalendar copia = new GregorianCalendar();
        dia = this.data.get(Calendar.DATE);
        mes = this.data.get(Calendar.MONTH);
        ano = this.data.get(Calendar.YEAR);
        copia.set(Calendar.DATE, dia);
        copia.set(Calendar.MONTH, mes);
        copia.set(Calendar.YEAR, ano);
        return copia;
    }
    public String toString(){
        int dia,mes,ano;
        StringBuilder s=new StringBuilder();
        dia=this.data.get(Calendar.DATE);
        mes=this.data.get(Calendar.MONTH);
        ano=this.data.get(Calendar.YEAR);
        s.append("Nome: "+this.nome+"\n");
        s.append("Data: "+dia+" - "+mes+" - "+ano+"\n");
        s.append("Duração: "+this.duration+"\n");
        s.append("Calorias: "+this.calories+"\n");
        s.append("Hidratação: "+this.hidratacao+"\n");
        return s.toString();
    }

}