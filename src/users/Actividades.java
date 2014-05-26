/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package users;

/**
 *
 * @author Mesas
 */
import java.util.*;
import activities.*;

public class Actividades {

    private ArrayList<GeneralActivity> listactividades;

    public Actividades() {
        listactividades = new ArrayList<>();
    }

    public ArrayList<GeneralActivity> getActividades() {
        ArrayList<GeneralActivity> copia = new ArrayList<>();
        GeneralActivity aux;
        for (GeneralActivity g : listactividades) {
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

    public Actividades(ArrayList<GeneralActivity> list) {
        listactividades = new ArrayList<>();
        GeneralActivity aux;
        for (GeneralActivity g : list) {
            if (g instanceof Distancia) {
                aux = ((Distancia) g).clone();
                this.listactividades.add(aux);
            }
            if (g instanceof Desporto) {
                aux = ((Desporto) g).clone();
                this.listactividades.add(aux);
            }
            if (g instanceof Ambos) {
                aux = ((Ambos) g).clone();
                this.listactividades.add(aux);
            }
            if (g instanceof Outros) {
                aux = ((Outros) g).clone();
                this.listactividades.add(aux);
            }
        }
    }

    public Actividades(Actividades a) {
        this.listactividades = new ArrayList<>();
        this.listactividades = a.getActividades();
    }

    public Actividades clone() {
        return new Actividades(this);
    }

    public void AdicionarActividade(GeneralActivity g) {
       GeneralActivity aux;
        if (g instanceof Distancia) {
            aux = ((Distancia) g).clone();    
            this.listactividades.add(aux);
            }
            if (g instanceof Desporto) {
                aux = ((Desporto) g).clone();
                this.listactividades.add(aux);
            }
            if (g instanceof Ambos) {
                aux = ((Ambos) g).clone();
                this.listactividades.add(aux);
            }
            if (g instanceof Outros) {
           aux = ((Outros) g).clone();
                this.listactividades.add(aux);     
            }
        
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        GeneralActivity aux;
        for (GeneralActivity g : this.listactividades) {
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
}
