/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 
package users;
import java.util.*;
import java.io.*;
import activities.*;
import exceptions.*;

/**
 *
 * @author Mesas
 */
public class ListaActividades implements Serializable {

    private TreeMap<GregorianCalendar, GeneralActivity> actividades;

    public ListaActividades() {
        actividades = new TreeMap<GregorianCalendar, GeneralActivity>();
    }

    public ListaActividades(TreeMap<GregorianCalendar, GeneralActivity> l) {
        this.setActividades(l);
    }

    public ListaActividades(ListaActividades l) {
        actividades = new TreeMap<GregorianCalendar, GeneralActivity>();
        actividades = l.getActividades();
    }

    public ListaActividades clone() {
        return new ListaActividades(this);
    }

    public TreeMap<GregorianCalendar, GeneralActivity> getActividades() {
        TreeMap<GregorianCalendar, GeneralActivity> copia = new TreeMap<GregorianCalendar, GeneralActivity>();
        GeneralActivity aux, a;
        for (GregorianCalendar g : this.actividades.keySet()) {
            a = this.actividades.get(g);
            if (a instanceof Distancia) {
                aux = ((Distancia) a).clone();
                copia.put(aux.getData(), aux);
            }
            if (a instanceof Competicao) {
                aux = ((Competicao) a).clone();
                copia.put(aux.getData(), aux);
            }
            if (a instanceof Altitude) {
                aux = ((Altitude) a).clone();
                copia.put(aux.getData(), aux);
            }
            if (a instanceof Fitness) {
                aux = ((Fitness) a).clone();
                copia.put(aux.getData(), aux);
            }
        }
        return copia;
    }

    public void setActividades(TreeMap<GregorianCalendar, GeneralActivity> lista) {
        this.actividades = new TreeMap<GregorianCalendar, GeneralActivity>();
        GeneralActivity aux, a;
        for (GregorianCalendar g : lista.keySet()) {
            a = lista.get(g);
            if (a instanceof Distancia) {
                aux = ((Distancia) a).clone();
                this.actividades.put(aux.getData(), aux);
            }
            if (a instanceof Competicao) {
                aux = ((Competicao) a).clone();
                this.actividades.put(aux.getData(), aux);
            }
            if (a instanceof Altitude) {
                aux = ((Altitude) a).clone();
                this.actividades.put(aux.getData(), aux);
            }
            if (a instanceof Fitness) {
                aux = ((Fitness) a).clone();
                this.actividades.put(aux.getData(), aux);
            }
        }
    }
public boolean equals(Object o){
    boolean op=false;
    if(this==o){
        op=true;
    }
    if(o==null | this.getClass() !=o.getClass()){
        op=false;
    }
    ListaActividades aux=(ListaActividades)o;
    if(this.getActividades().equals(aux.getActividades())){
        op=true;
    }
    return op;
}
    public String toString() {
        StringBuilder s = new StringBuilder("-----ULTIMAS DEZ ACTIVIDADES-----\n");
        int i = 0;
        int dia,mes,ano,hora,minuto;
 GeneralActivity g;
 GregorianCalendar date;
                Iterator<GregorianCalendar> it=this.actividades.descendingKeySet().iterator();
                while(it.hasNext() && i!=10){
date=it.next();
g=this.actividades.get(date);
dia=date.get(Calendar.DAY_OF_MONTH);
mes=date.get(Calendar.MONTH);
ano=date.get(Calendar.YEAR);
hora=date.get(Calendar.HOUR_OF_DAY);
minuto=date.get(Calendar.MINUTE);
s.append("Data da actividade: "+dia+"-"+mes+"-"+ano+" Hora: "+hora+":"+minuto+" Descrição da actividade: "+g.getNome()+" Desporto: "+g.getTipo()+"\n");
i++;
            }
    
        return s.toString();   
    }


    public boolean ExisteActividade(GregorianCalendar g) {
        return this.actividades.containsKey(g);
    }

    public void AdicionarActividade(GeneralActivity g) {
        GeneralActivity aux;

        if (g instanceof Distancia) {
            aux = ((Distancia) g).clone();
            this.actividades.put(aux.getData(), aux);

        }
        if (g instanceof Competicao) {
            aux = ((Competicao) g).clone();
            this.actividades.put(aux.getData(), aux);
        }
        if (g instanceof Altitude) {
            aux = ((Altitude) g).clone();
            this.actividades.put(aux.getData(), aux);
        }
        if (g instanceof Fitness) {
            aux = ((Fitness) g).clone();
            this.actividades.put(aux.getData(), aux);
        }

    }

    public String ConsultarActividade(GregorianCalendar date) throws Excepcoes {
        GeneralActivity aux;
        String details=new String();
        try {
            if(this.NrdeActividades()==0 || this.ExisteActividade(date) ==false ) {
                throw new ActividadeNaoExiste();
            } else {
               aux=this.actividades.get(date);
               return aux.toString();
            }
        }catch(ActividadeNaoExiste e){
            System.out.println(e.getMessage());
        }
    
    return details;}
  
    public int NrdeActividades() {
        return this.actividades.size();
    }

  public  void RemoverActividade(GregorianCalendar date) {
  this.actividades.remove(date);
  }

 public  boolean TemActividades(String tipo) {
 for(GregorianCalendar g:this.actividades.keySet()){
     if(this.actividades.get(g).getTipo().equals(tipo)==true){
         return true;
     }
 }
 return false;
 }

}