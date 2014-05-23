/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package users;

import activities.*;
import java.util.*;
import comparators.*;
/**
 *
 * @author Mesas
 */
public class ListaActividades {
    private TreeMap<GregorianCalendar,GeneralActivity> actividades;
    public ListaActividades(){
        actividades=new TreeMap<GregorianCalendar,GeneralActivity>(new DateComparator());
    }
    public TreeMap<GregorianCalendar,GeneralActivity> getActividades(){
       TreeMap<GregorianCalendar,GeneralActivity> copia=new TreeMap<GregorianCalendar,GeneralActivity>(new DateComparator());
       GeneralActivity aux;
       for(GregorianCalendar g:actividades.keySet()){
           if((actividades.get(g)) instanceof Distancia){
               aux=((Distancia)(actividades.get(g))).clone();
               
               copia.put(g,aux );
           }
       }
     return copia;  
    }
    public ListaActividades(TreeMap<GregorianCalendar,GeneralActivity> list){
        actividades=new TreeMap<GregorianCalendar,GeneralActivity>(new DateComparator());
     GeneralActivity aux;
       for(GregorianCalendar g:list.keySet()){
           if((actividades.get(g)) instanceof Distancia){
               aux=((Distancia)(list.get(g))).clone();
           actividades.put(g, aux);    
              
           }else{
               if((actividades.get(g)) instanceof Altitude){
               aux=((Altitude)(list.get(g))).clone();
               actividades.put(g, aux);
              
           }
           }
           
       }
    }
    public ListaActividades(ListaActividades l){
        this.actividades=new TreeMap<GregorianCalendar,GeneralActivity>(new DateComparator());
        actividades=l.getActividades();
    }
    public ListaActividades clone(){
        return new ListaActividades(this);
    }
    public void AdicionarActividade(GeneralActivity g){
         
        if(g instanceof Altitude){
         GeneralActivity aux=((Altitude)g).clone();
         this.actividades.put(aux.getData(), aux);
        }else{
        if(g instanceof Distancia){
           GeneralActivity aux=((Distancia)g).clone();
         this.actividades.put(aux.getData(), aux);
        }else{
        if(g instanceof Ambos){
            GeneralActivity aux=((Ambos)g).clone();
         this.actividades.put(aux.getData(), aux);
        }else{
        if(g instanceof Outros){
           GeneralActivity aux=((Outros)g).clone();
         this.actividades.put(aux.getData(), aux);
        }}}}
       
    }
}
