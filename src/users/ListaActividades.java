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
    private ArrayList<GeneralActivity> actividades;
    public ListaActividades(){
        actividades= new ArrayList<GeneralActivity>();
    }
    public ArrayList<GeneralActivity> getActividades(){
       ArrayList<GeneralActivity> copia=new ArrayList<>();
     GeneralActivity aux;
      for(GeneralActivity g:this.actividades){
          if (g instanceof Distancia) {
            aux = ((Distancia) g).clone();    
            copia.add(aux);
            }
            if (g instanceof Desporto) {
                aux = ((Desporto) g).clone();
                copia.add(aux);
            }
            if (g instanceof Ambos) {
                aux = ((Ambos) g).clone();
                copia.add(aux);
            }
            if (g instanceof Outros) {
           aux = ((Outros) g).clone();
                copia.add(aux);     
            }
      }
       
     return copia;
    }
    public ListaActividades(ListaActividades l){
        this.actividades=new ArrayList<>();
        actividades=l.getActividades();
    }
    public ListaActividades clone(){
        return new ListaActividades(this);
    }
    public void AdicionarActividade(GeneralActivity g){
       GeneralActivity aux;
       ArrayList<GeneralActivity> copia;
                if (g instanceof Distancia) {
            aux = ((Distancia) g).clone();    
           this.actividades.add(aux);
            
                }
            if (g instanceof Desporto) {
                aux = ((Desporto) g).clone();
                this.actividades.add(aux);
            }
            if (g instanceof Ambos) {
                aux = ((Ambos) g).clone();
                this.actividades.add(aux);
            }
            if (g instanceof Outros) {
           aux = ((Outros) g).clone();
                this.actividades.add(aux);     
            }
           copia=this.getActividades();
       Collections.sort(copia, new DateComparator());
       
       this.setActividades(copia);
       
        
    }
    public String toString(){
        StringBuilder s=new StringBuilder("-----LISTA DE ACTIVIDADES-----\n");
        GeneralActivity aux;
        for(GeneralActivity g:this.actividades){
            if (g instanceof Distancia) {
            aux = ((Distancia) g).clone();    
            s.append(aux.toString());
            }
            if (g instanceof Desporto) {
                aux = ((Desporto) g).clone();
                s.append(aux.toString());
            }
            if (g instanceof Ambos) {
                aux = ((Ambos) g).clone();
                s.append(aux.toString());
            }
            if (g instanceof Outros) {
           aux = ((Outros) g).clone();
                s.append(aux.toString());    
            }
        }
        
        return s.toString();
    }
    

    private void setActividades(ArrayList<GeneralActivity> copia) {
    this.actividades=new ArrayList<>();
    GeneralActivity aux;
    for(GeneralActivity g:copia){
        
            if (g instanceof Distancia) {
            aux = ((Distancia) g).clone();    
            this.actividades.add(aux);
            }
            if (g instanceof Desporto) {
                aux = ((Desporto) g).clone();
               this.actividades.add(aux);
            }
            if (g instanceof Ambos) {
                aux = ((Ambos) g).clone();
                this.actividades.add(aux);
            }
            if (g instanceof Outros) {
           aux = ((Outros) g).clone();
               this.actividades.add(aux);   
            }
    }
    }

   public int NrdeActividades() {
   return this.actividades.size();
   }
}
