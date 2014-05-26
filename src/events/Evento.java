/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package events;

import java.util.*;
import users.*;
/**
 *
 * @author Mesas
 */
public class Evento {
    private String nome;
    private String local;
    private int ninscritos;
    private GregorianCalendar datainicio;
private GregorianCalendar datafim;
    private HashMap<String,User> inscritos;
public Evento(){
    nome=local="";
    ninscritos=0;
    datafim=datainicio=new GregorianCalendar();
    inscritos=new HashMap<>();
}
public Evento(String name,String local,int num,GregorianCalendar init,GregorianCalendar fim,HashMap<String,User> list){
    int dia,mes,ano;
    this.nome=name;
    this.local=local;
    this.ninscritos=num;
    this.datafim=this.datainicio=new GregorianCalendar();
    dia=init.get(Calendar.DATE);
    mes=init.get(Calendar.MONTH);
    ano=init.get(Calendar.YEAR);
    this.datainicio.set(Calendar.DATE, dia);
    this.datainicio.set(Calendar.MONTH, mes);
    this.datainicio.set(Calendar.YEAR, ano);
dia=fim.get(Calendar.DATE);
    mes=fim.get(Calendar.MONTH);
    ano=fim.get(Calendar.YEAR);
    this.datafim.set(Calendar.DATE, dia);
    this.datafim.set(Calendar.MONTH, mes);
    this.datafim.set(Calendar.YEAR, ano);
    this.inscritos=new HashMap<>();
    for(String s:list.keySet()){
       this.inscritos.put(s, list.get(s).clone());
    }
}
public Evento(Evento e){
    this.nome=e.getNome();
    this.local=e.getLocal();
    this.datainicio=e.getDatainicio();
    this.datafim=e.getDatafim();
    this.ninscritos=e.getInscritos();
    this.inscritos=e.getUsersInscritos();
}
public Evento clone(){
    return new Evento(this);
}
public String toString(){
    int dia,mes,ano;
    StringBuilder s=new StringBuilder();
    s.append("Nome: "+this.nome+"\n");
    s.append("Local: "+this.local+"\n");
    s.append("Nº de inscrições até agora: "+this.inscritos);
    dia=this.datainicio.get(Calendar.DATE);
    mes=this.datainicio.get(Calendar.MONTH);
    ano=this.datainicio.get(Calendar.YEAR);
    s.append("Data de início de inscrições: "+dia+" - "+mes+" - "+ano+"\n");
dia=this.datafim.get(Calendar.DATE);
    mes=this.datafim.get(Calendar.MONTH);
    ano=this.datafim.get(Calendar.YEAR);
    s.append("Data de fim de inscrições: "+dia+" - "+mes+" - "+ano+"\n");
    return s.toString();
}
    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @return the local
     */
    public String getLocal() {
        return local;
    }

    /**
     * @return the inscritos
     */
    public int getInscritos() {
        return ninscritos;
    }

    /**
     * @return the datainicio
     */
    public GregorianCalendar getDatainicio() {
        int dia,mes,ano;
        GregorianCalendar aux=new GregorianCalendar();
        dia=this.datainicio.get(Calendar.DATE);
    mes=this.datainicio.get(Calendar.MONTH);
    ano=this.datainicio.get(Calendar.YEAR);
    aux.set(Calendar.DATE, dia);
   aux.set(Calendar.MONTH, mes);
    aux.set(Calendar.YEAR, ano);
        return aux;
    }

    /**
     * @return the datafim
     */
    public GregorianCalendar getDatafim() {
        int dia,mes,ano;
        GregorianCalendar aux=new GregorianCalendar();
        dia=this.datafim.get(Calendar.DATE);
    mes=this.datafim.get(Calendar.MONTH);
    ano=this.datafim.get(Calendar.YEAR);
    aux.set(Calendar.DATE, dia);
   aux.set(Calendar.MONTH, mes);
    aux.set(Calendar.YEAR, ano);
    return aux;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @param local the local to set
     */
    public void setLocal(String local) {
        this.local = local;
    }

    /**
     * @param inscritos the inscritos to set
     */
    public void setInscritos(int inscritos) {
        this.ninscritos = inscritos;
    }

    /**
     * @param datainicio the datainicio to set
     */
    public void setDatainicio(GregorianCalendar datainicio) {
        int dia,mes,ano;
        this.datainicio=new GregorianCalendar();
        dia=datainicio.get(Calendar.DATE);
    mes=datainicio.get(Calendar.MONTH);
    ano=datainicio.get(Calendar.YEAR);
    this.datainicio.set(Calendar.DATE, dia);
   this.datainicio.set(Calendar.MONTH, mes);
    this.datainicio.set(Calendar.YEAR, ano);
    }

    /**
     * @param datafim the datafim to set
     */
    public void setDatafim(GregorianCalendar datafim) {
        int dia,mes,ano;
        this.datafim=new GregorianCalendar();
        dia=datafim.get(Calendar.DATE);
    mes=datafim.get(Calendar.MONTH);
    ano=datafim.get(Calendar.YEAR);
    this.datafim.set(Calendar.DATE, dia);
   this.datafim.set(Calendar.MONTH, mes);
    this.datafim.set(Calendar.YEAR, ano);
    }

    private HashMap<String, User> getUsersInscritos() {
    HashMap<String,User> copia=new HashMap<>();
    for(String s:this.inscritos.keySet()){
        copia.put(s, this.inscritos.get(s).clone());
    }
    return copia;
    }
}

