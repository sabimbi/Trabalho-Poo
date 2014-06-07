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
    private String localderealizacao;
    private String localdeinscricao;
    private String tipo;
    private int ninscritos; 
    private int maxinscritos;
    private GregorianCalendar dataderealizacao;
private GregorianCalendar datafim;
    private TreeSet<String> usersinscritos;
public Evento(){
    nome=localdeinscricao=localderealizacao=tipo="";
    ninscritos=0;
    maxinscritos=10;
    datafim=new GregorianCalendar();
    usersinscritos=new TreeSet<String>();
    dataderealizacao=new GregorianCalendar();
    
}

public Evento(String name,String tipo,String localrealizacao,String localinscricao,GregorianCalendar realizacao,GregorianCalendar fim,int maxinscritos){
   
    this.nome=name;
    this.tipo=tipo;
    this.localderealizacao=localrealizacao;
    this.localdeinscricao=localinscricao;
    this.ninscritos=0;
    this.maxinscritos=maxinscritos;
    
    
this.dataderealizacao=realizacao;
    this.datafim=fim;
    this.usersinscritos=new TreeSet<String>();
    
}
public Evento(Evento e){
    this.nome=e.getNome();
    this.localderealizacao=e.getLocalRealizacao();
    this.localdeinscricao=e.getLocalInscricao();
    this.datafim=e.getDatafim();
    this.ninscritos=e.getNinscritos();
  this.maxinscritos=e.getMaxinscritos();
    this.dataderealizacao=e.getDataderealizacao();
    this.usersinscritos=e.getUsersInscritos();
    this.tipo=e.getTipo();
}
public Evento clone(){
    return new Evento(this);
}
 public boolean equals(Object o){
    boolean op=false;
    if(this==o){
        op=true;
    }
    if(o==null || this.getClass()!=o.getClass()){
        op=false;
    }
    Evento aux=(Evento)o;
    if(this.getNome().equals(aux.getNome()) && this.getTipo().equals(aux.getTipo()) && this.getUsersInscritos().equals(aux.getUsersInscritos()) && this.getNinscritos()==aux.getNinscritos() && this.getMaxinscritos()==aux.getMaxinscritos() && this.getLocalInscricao().equals(aux.getLocaldeinscricao()) && this.getLocalderealizacao().equals(aux.getLocalderealizacao() )&& this.getDatafim().equals(aux.getDatafim()) && this.getDataderealizacao().equals(aux.getDataderealizacao())){
        op=true;
    }
    return op;
}
public String toString(){
    int dia,mes,ano;
    StringBuilder s=new StringBuilder();
    s.append("Nome: "+this.nome+"\n");
    s.append("Tipo de Actividade: "+this.tipo+"\n");
    s.append("Local de inscrição: "+this.getLocaldeinscricao()+"\n");
    s.append("Local de realização: "+this.getLocaldeinscricao()+"\n");
    s.append("Nº de inscrições até agora: "+this.ninscritos+"\n");
s.append("Máximo número de inscrições: "+this.maxinscritos+"\n");
    dia=this.datafim.get(Calendar.DATE);
    mes=this.datafim.get(Calendar.MONTH);
    ano=this.datafim.get(Calendar.YEAR);
    s.append("Data de fim de inscrições: "+dia+"-"+mes+"-"+ano+"\n");
    dia=this.dataderealizacao.get(Calendar.DATE);
    mes=this.dataderealizacao.get(Calendar.MONTH);
    ano=this.dataderealizacao.get(Calendar.YEAR);
    s.append("Data de realização do evento: "+dia+"-"+mes+"-"+ano+"\n");
    return s.toString();
}
public String getTipo(){
    return this.tipo;
}
public void setTipo(String tipo){
    this.tipo=tipo;
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
    public String getLocalRealizacao() {
        return this.getLocalderealizacao();
    }
public String getLocalInscricao() {
        return this.getLocaldeinscricao();
    }
    /**
     * @return the inscritos
     */
  

   

    /**
     * @return the datafim
     */
    public GregorianCalendar getDatafim() {
       
    return this.datafim;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

  
    public void setInscritos(int inscritos) {
        this.setNinscritos(inscritos);
    }

   
    public void setDatafim(GregorianCalendar datafim) {
       this.datafim=datafim;
    }

   public TreeSet<String> getUsersInscritos() {
    TreeSet<String> copia=new TreeSet<String>();
    for(String s:this.usersinscritos){
        copia.add(s);
    }
    return copia;
    }

    public void InscreverUser(String nome) {
    this.usersinscritos.add(nome);
    this.ninscritos++;
    }

    /**
     * @return the localderealizacao
     */
    public String getLocalderealizacao() {
        return localderealizacao;
    }

    /**
     * @return the localdeinscricao
     */
    public String getLocaldeinscricao() {
        return localdeinscricao;
    }

    /**
     * @return the ninscritos
     */
    public int getNinscritos() {
        return ninscritos;
    }

    /**
     * @return the maxinscritos
     */
    public int getMaxinscritos() {
        return maxinscritos;
    }

    /**
     * @param localderealizacao the localderealizacao to set
     */
    public void setLocalderealizacao(String localderealizacao) {
        this.localderealizacao = localderealizacao;
    }

    /**
     * @param localdeinscricao the localdeinscricao to set
     */
    public void setLocaldeinscricao(String localdeinscricao) {
        this.localdeinscricao = localdeinscricao;
    }

    /**
     * @param ninscritos the ninscritos to set
     */
    public void setNinscritos(int ninscritos) {
        this.ninscritos = ninscritos;
    }

    /**
     * @param maxinscritos the maxinscritos to set
     */
    public void setMaxinscritos(int maxinscritos) {
        this.maxinscritos = maxinscritos;
    }

    /**
     * @return the dataderealizacao
     */
    public GregorianCalendar getDataderealizacao() {
        return dataderealizacao;
    }

    /**
     * @param dataderealizacao the dataderealizacao to set
     */
    public void setDataderealizacao(GregorianCalendar dataderealizacao) {
        this.dataderealizacao = dataderealizacao;
    }

    
    
}

