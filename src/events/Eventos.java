/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

 
package events;
/**
 *
 * @author Mesas
 */
import java.io.Serializable;
import java.util.*;
import exceptions.*;

public class Eventos implements Serializable{
    private HashMap<String,Evento> eventos;
    public Eventos(){
        eventos=new HashMap<>();
    }
    
    public Eventos(HashMap<String,Evento> list){
        eventos=new HashMap<>();
        for(String s:list.keySet()){
            eventos.put(s,list.get(s).clone());
        }
    }
    public Eventos(Eventos e){
        eventos=new HashMap<>();
        eventos=e.getEventos();
    }
    public Eventos clone(){
        return new Eventos(this);
    }
    public HashMap<String,Evento> getEventos(){
        HashMap<String,Evento> copia=new HashMap<>();
        for(String s:this.eventos.keySet()){
            copia.put(s, this.eventos.get(s).clone());
        }
        return copia;
    }
    public String toString(){
    StringBuilder s=new StringBuilder();
    Evento e;
    GregorianCalendar data=new GregorianCalendar();
    GregorianCalendar date;
    int dia,mes,ano;
    s.append("-----LISTA DE EVENTOS----\n");
    for(String event:this.eventos.keySet()){
        e=this.eventos.get(event);
       s.append(e.toString());
        
    }
    return s.toString();
    }

    public void RemoverEvento(String event) {
    this.eventos.remove(event);
    }

    public boolean ExisteEvento(String event) throws Excepcoes {
    return this.eventos.containsKey(event);
    }

    public int NrdeEventos() {
    return this.eventos.size();
    }

    public void AdicionarEvento(Evento e) {
    this.eventos.put(e.getNome(), e);
    }

    public int NrdeEventosValidos() {
    int n=0;
    Evento e;
    GregorianCalendar hoje=new GregorianCalendar();
        for(String s:this.eventos.keySet()){
        e=this.eventos.get(s);
        if(e.getDatafim().after(hoje)==true){
            n++;
        }else{
            break;
        }
    }
        return n;
    }

    public Evento getEvento(String nome) {
    return this.eventos.get(nome).clone();
    }
    public boolean equals(Object o){
    boolean op=false;
    if(this==o){
        op=true;
    }
    if(o==null || this.getClass()!=o.getClass()){
        op=false;
    }
    Eventos aux=(Eventos)o;
    if(this.getEventos().equals(aux.getEventos())){
        op=true;
    }
    return op;
}
}
