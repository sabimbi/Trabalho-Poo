/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package users;

/**
 *
 * @author Mesas
 */
import java.io.*;
import java.util.*;
public class ListaRecordes implements Serializable{
    private Map<String,Recorde> records;


    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ListaRecordes other = (ListaRecordes) obj;
        if (!this.records.equals(other.records)) {
            return false;
        }
        return true;
    }
    
    public ListaRecordes(){
        this.records=new TreeMap<String,Recorde>();
    }

    public ListaRecordes(Map<String, Recorde> records) {
        this.setRecords(records);
    }
public ListaRecordes(ListaRecordes l){
    this.setRecords(l.getRecords());
}
public ListaRecordes clone(){
    return new ListaRecordes(this);
}
    /**
     * @return the records
     */
    public Map<String,Recorde> getRecords() {
       TreeMap<String,Recorde> copia=new TreeMap<String,Recorde>();
       for(String s:this.records.keySet()){
           copia.put(s, this.records.get(s).clone());
       }
       return copia;
    }

    /**
     * @param records the records to set
     */
    public void setRecords(Map<String,Recorde> records) {
        this.records = new TreeMap<String,Recorde>();{
        for(String s:records.keySet()){
            this.records.put(s, records.get(s).clone());
        }
    }
    }
    public void ActualizarRecordes(String tipo,double distancia,int hora,int minuto){
        Recorde r;
        if(!this.records.containsKey(tipo)){
            r=new Recorde();
            r.setNome(tipo);
            r.ActualizarRecorde(hora,minuto,distancia);
            this.records.put(tipo,r);
        }else{
            r=this.records.get(tipo).clone();
            r.ActualizarRecorde(hora,minuto,distancia);
            this.records.put(tipo, r);
        }
    }
    public String toString(){
        StringBuilder s=new StringBuilder("----LISTA DE RECORDES----\n");
        for(String str:this.records.keySet()){
            s.append(str+"\n");
                   
        }
    return s.toString();
    }
    public boolean TemRecordes(){
        return this.records.isEmpty();
    }

  public  boolean ExisteRecorde(String tipo) {
  return this.records.containsKey(tipo);
  }

 public  String ConsultaRecorde(String tipo) {
 return this.records.get(tipo).toString();
 }
}
