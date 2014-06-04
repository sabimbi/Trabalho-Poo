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
    s.append("-----LISTA DE EVENTOS DISPONÍVEIS----");
    for(String event:this.eventos.keySet()){
        s.append(event+"\n");
    }
    return s.toString();
    }

    public void RemoverEvento(String event) {
    this.eventos.remove(event);
    }

    public boolean ExisteEvento(String event) throws Excepcoes {
    if(this.eventos.containsKey(event)==false){
        throw new EventoNaoExiste(event);
    }else{
        return true;
    }
    }
    
}
