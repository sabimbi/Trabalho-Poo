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
public class Eventos implements Serializable{
    private ArrayList<Evento> eventos;
    public Eventos(){
        eventos=new ArrayList<>();
    }
    
    public Eventos(ArrayList<Evento> list){
        eventos=new ArrayList<>();
        for(Evento e:list){
            eventos.add(e.clone());
        }
    }
    public Eventos(Eventos e){
        eventos=new ArrayList<>();
        eventos=e.getEventos();
    }
    public Eventos clone(){
        return new Eventos(this);
    }
    public ArrayList<Evento> getEventos(){
        ArrayList<Evento> copia=new ArrayList<>();
        for(Evento e:this.eventos){
            copia.add(e.clone());
        }
        return copia;
    }
}
