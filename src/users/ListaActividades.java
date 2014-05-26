/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package users;


import java.util.*;
import comparators.*;
import activities.*;
/**
 *
 * @author Mesas
 */
public class ListaActividades {
    private TreeMap<GregorianCalendar,Actividades> actividades;
    public ListaActividades(){
        actividades=new TreeMap<GregorianCalendar,Actividades>(new DateComparator());
    }
    public TreeMap<GregorianCalendar,Actividades> getActividades(){
       TreeMap<GregorianCalendar,Actividades> copia=new TreeMap<GregorianCalendar,Actividades>(new DateComparator());
      Actividades aux;
      for(GregorianCalendar g:this.actividades.keySet()){
          aux=this.actividades.get(g).clone();
          copia.put(g, aux);
      }
       
     return copia;
    }
    public ListaActividades(ListaActividades l){
        this.actividades=new TreeMap<GregorianCalendar,Actividades>(new DateComparator());
        actividades=l.getActividades();
    }
    public ListaActividades clone(){
        return new ListaActividades(this);
    }
    public void AdicionarActividade(GeneralActivity g){
         Actividades a;
       if(actividades.containsKey(g.getData())==true){
        a=this.actividades.get(g.getData()).clone();
        a.AdicionarActividade(g);
        this.actividades.put(g.getData(),a);
        }else{
        a=new Actividades();
        a.AdicionarActividade(g);
        this.actividades.put(g.getData(),a);
        }
        
    }
    public String toString(){
        StringBuilder s=new StringBuilder("-----LISTA DE ACTIVIDADES-----\n");
        for(GregorianCalendar g:this.actividades.keySet()){
            s.append(this.actividades.get(g).toString());
        }
        
        return s.toString();
    }
}
