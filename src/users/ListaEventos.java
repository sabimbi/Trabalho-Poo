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
public class ListaEventos implements Serializable{
    private TreeSet<String> eventos;
    public ListaEventos(){
        this.eventos=new TreeSet<String>();
    }
    public ListaEventos(TreeSet<String> events){
        this.eventos=new TreeSet<String>();
        for(String s:events){
            this.eventos.add(s);
        }
    }
    
    public ListaEventos(ListaEventos l){
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
    public ListaEventos clone(){
        return new ListaEventos(this);
    }

   public void InscreverEvento(String nome) {
   this.eventos.add(nome);
   }
}
