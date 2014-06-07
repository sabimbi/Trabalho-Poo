/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

 package users;
import java.io.Serializable;
import java.util.*;
/**
 *
 * @author Mesas
 */
public class EventosInscritos implements Serializable{
    private TreeSet<String> eventos;
    public EventosInscritos(){
        this.eventos=new TreeSet<String>();
    }
    public EventosInscritos(TreeSet<String> events){
        this.eventos=new TreeSet<String>();
        for(String s:events){
            this.eventos.add(s);
        }
    }
    
    public EventosInscritos(EventosInscritos l){
        this.eventos=new TreeSet<String>();
        this.eventos=l.getEventos();
    }
    public TreeSet<String> getEventos(){
        TreeSet<String> copia=new TreeSet<String>();
        for(String s:this.eventos){
            copia.add(s);
        }
        return copia;
    }
    public EventosInscritos clone(){
        return new EventosInscritos(this);
    }

   public void InscreverEvento(String nome) {
   this.eventos.add(nome);
   }
   public boolean equals(Object o){
    boolean op=false;
    if(this==o){
        op=true;
    }
    if(o==null | this.getClass() !=o.getClass()){
        op=false;
    }
    EventosInscritos aux=(EventosInscritos)o;
    if(this.getEventos().equals(aux.getEventos())){
        op=true;
    }
    return op;
}
 
}
