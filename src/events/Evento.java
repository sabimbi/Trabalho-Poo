/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

 
package events;
import java.io.Serializable;
import java.util.*;

/**
 *
 * @author Mesas
 */
public class Evento implements Serializable{
    private String nome;
    private String local;
    private int ninscritos; 
private GregorianCalendar datafim;
    private TreeSet<String> inscritos;
public Evento(){
    nome=local="";
    ninscritos=0;
    datafim=new GregorianCalendar();
    inscritos=new TreeSet<String>();
}
public Evento(String name,String local,int num,GregorianCalendar fim){
    int dia,mes,ano;
    this.nome=name;
    this.local=local;
    this.ninscritos=num;
    this.datafim=new GregorianCalendar();
    
dia=fim.get(Calendar.DATE);
    mes=fim.get(Calendar.MONTH);
    ano=fim.get(Calendar.YEAR);
    this.datafim=new GregorianCalendar(ano, mes, dia);
    this.inscritos=new TreeSet<String>();
    
}
public Evento(Evento e){
    this.nome=e.getNome();
    this.local=e.getLocal();
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
dia=this.datafim.get(Calendar.DATE);
    mes=this.datafim.get(Calendar.MONTH);
    ano=this.datafim.get(Calendar.YEAR);
    s.append("Data de fim de inscrições: "+dia+"-"+mes+"-"+ano+"\n");
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
    

    /**
     * @param datafim the datafim to set
     */
    public void setDatafim(GregorianCalendar datafim) {
        int dia,mes,ano;
        
        dia=datafim.get(Calendar.DATE);
    mes=datafim.get(Calendar.MONTH);
    ano=datafim.get(Calendar.YEAR);
    this.datafim=new GregorianCalendar(ano, mes, dia);
    }

    private TreeSet<String> getUsersInscritos() {
    TreeSet<String> copia=new TreeSet<String>();
    for(String s:this.inscritos){
        copia.add(s);
    }
    return copia;
    }

    public void InscreverUser(String nome) {
    this.inscritos.add(nome);
    }
}

