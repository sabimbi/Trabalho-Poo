/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package users;
import java.util.*;
import activities.*;
import java.io.*;
import comparators.DateComparator;
/**
 *
 * @author Mesas
 */
public class ListadeActividades implements Serializable{
    private ArrayList<GeneralActivity> actividades;
    public ListadeActividades(){
        actividades=new ArrayList<>();
    }
    public ListadeActividades(ArrayList<GeneralActivity> l){
     this.setActividades(l);
    }
    public ListadeActividades(ListadeActividades l){
        actividades=new ArrayList<>();
        actividades=l.getActividades();
    }
    public ListadeActividades clone(){
        return new ListadeActividades(this);
    }
    public ArrayList<GeneralActivity> getActividades() {
        ArrayList<GeneralActivity> copia = new ArrayList<>();
        GeneralActivity aux;
        for (GeneralActivity g : this.actividades) {
            if (g instanceof Distancia) {
                aux = ((Distancia) g).clone();
                copia.add(aux);
            }
            if (g instanceof Desporto) {
                aux = ((Desporto) g).clone();
                copia.add(aux);
            }
            if (g instanceof Altitude) {
                aux = ((Altitude) g).clone();
                copia.add(aux);
            }
            if (g instanceof Outros) {
                aux = ((Outros) g).clone();
                copia.add(aux);
            }
        }

        return copia;
    }
    public void setActividades(ArrayList<GeneralActivity> copia) {
        this.actividades = new ArrayList<>();
        GeneralActivity aux;
        for (GeneralActivity g : copia) {

            if (g instanceof Distancia) {
                aux = ((Distancia) g).clone();
                this.actividades.add(aux);
            }
            if (g instanceof Desporto) {
                aux = ((Desporto) g).clone();
                this.actividades.add(aux);
            }
            if (g instanceof Altitude) {
                aux = ((Altitude) g).clone();
                this.actividades.add(aux);
            }
            if (g instanceof Outros) {
                aux = ((Outros) g).clone();
                this.actividades.add(aux);
            }
        }
    }

public String toString() {
        StringBuilder s = new StringBuilder("-----LISTA DE ACTIVIDADES-----\n");
        GeneralActivity aux;
        for (GeneralActivity g : this.actividades) {
            if (g instanceof Distancia) {
                aux = ((Distancia) g);
                s.append(aux.toString());
            }
            if (g instanceof Desporto) {
                aux = ((Desporto) g);
                s.append(aux.toString());
            }
            if (g instanceof Altitude) {
                aux = ((Altitude) g);
                s.append(aux.toString());
            }
            if (g instanceof Outros) {
                aux = ((Outros) g);
                s.append(aux.toString());
            }
        }

        return s.toString();
    }
        public void AdicionarActividade(GeneralActivity g) {
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
        if (g instanceof Altitude) {
            aux = ((Altitude) g).clone();
            this.actividades.add(aux);
        }
        if (g instanceof Outros) {
            aux = ((Outros) g).clone();
            this.actividades.add(aux);
        }
        copia = this.getActividades();
        Collections.sort(copia, new DateComparator());

        this.setActividades(copia);

    }

    public int NrdeActividades() {
    return this.actividades.size();
    }
    
}
