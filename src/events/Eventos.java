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
    GregorianCalendar fim;
    int dia,mes,ano;
    s.append("-----LISTA DE EVENTOS DISPONÍVEIS----\n");
    for(String event:this.eventos.keySet()){
        e=this.eventos.get(event);
        fim=e.getDatafim();
        dia=fim.get(Calendar.DAY_OF_MONTH);
        mes=fim.get(Calendar.MONTH);
        ano=fim.get(Calendar.YEAR);
        if(fim.after(data)==true){
        s.append(event+" Data de fim de inscrições: "+dia+"-"+mes+"-"+ano+"\n");
        }
    }
    return s.toString();
    }

    public void RemoverEvento(String event) {
    this.eventos.remove(event);
    }

    public boolean ExisteEvento(String event) throws Excepcoes {
    if(this.eventos.containsKey(event)==true){
        throw new EventoJaExistente(event);
    }else{
        return false;
    }
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
    
}
