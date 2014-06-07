/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package users;

import java.util.*;
import java.math.*;
/**
 *
 * @author Mesas
 */
public class Recorde {

    private String nome;
    private Map<Integer, Double> records;

    public Recorde() {
        this.nome = "";
        records = new TreeMap<Integer, Double>();
        
    }

    public Recorde(String nome, Map<Integer, Double> list) {
        this.setNome(nome);
        this.setRecords(list);
    }
    public Recorde(String nome,int hora,int minuto,double distancia){
        double recorde,km;
         int total;
        
         this.records=new TreeMap<Integer, Double>();
        this.nome=nome;
       
    km=((double)hora+((double)minuto/60));
   
   
    total=(int)(Math.round(km));
 
    
   
        recorde=(distancia/km);
     this.records.put(total,recorde);   
        
    }

    public Recorde(Recorde r) {
        this.setNome(r.getNome());
        this.setRecords(r.getRecords());
    }

    public Recorde clone() {
        return new Recorde(this);
    }
    public void ActualizarRecorde(int hora,int minuto,double distancia){
    double recorde1,recorde2,km;
    
       int total;
       km=((double)hora+((double)minuto/60));
   
   
    total=(int)(Math.round(km));
    if(this.records.containsKey(total)){
    recorde1=(this.records.get(total));
     recorde2=distancia/km;
     if(recorde2>recorde1){
        this.records.put(total,recorde2);
        }
    }else{
    recorde2=distancia/total;
    this.records.put(total,recorde2);
    
    }}
   public boolean equals(Object o){
    boolean op=false;
    if(this==o){
        op=true;
    }
    if(o==null | this.getClass() !=o.getClass()){
        op=false;
    }
    Recorde aux=(Recorde)o;
    if(this.getNome().equals(aux.getNome()) && this.getRecords().equals(aux.getRecords())){
        op=true;
    }
    return op;
}


    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @return the records
     */
    public Map<Integer, Double> getRecords() {
        TreeMap<Integer, Double> copia = new TreeMap<Integer, Double>();
        for (Integer n : this.records.keySet()) {
            copia.put(n, this.records.get(n));
        }
        return copia;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @param records the records to set
     */
    public void setRecords(Map<Integer, Double> records) {
        this.records = new TreeMap<Integer, Double>();
        for (Integer n : this.records.keySet()) {
            records.put(n, this.records.get(n));
        }
    }
}
